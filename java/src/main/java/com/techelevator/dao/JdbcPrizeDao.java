package com.techelevator.dao;

import com.techelevator.model.Prize;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPrizeDao implements PrizeDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcPrizeDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    private final String roleAdmin = "ROLE_ADMIN";
    private final String roleUser = "ROLE_USER";
    

    @Override
    public Integer createPrize(Prize newPrize) {
        String insertSql = "INSERT INTO prize(prize_name, milestone, max_prize, description, user_role, start_date, end_date, is_active, prize_winners) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, true, ?) " +
                "RETURNING id;";
        Integer prizeId = jdbcTemplate.queryForObject(insertSql, Integer.class, newPrize.getPrizeName(), newPrize.getMilestone(), newPrize.getMaxPrize(),
                newPrize.getDescription(), newPrize.getUserRole(), newPrize.getStartDate(), newPrize.getEndDate(), newPrize.getNumOfPrizeWinners());

        return prizeId;
    }

    @Override
    public void addUsersToPrize(String username, Integer prizeId, String prizeRole){

        String sql = "INSERT INTO user_prize(user_id, prize_id, is_complete) VALUES(?,?, false);";

        if(prizeRole.equals(roleUser)){

            String usersToInsertSql = "SELECT user_id FROM user_family WHERE (family_id = (SELECT family_id FROM user_family " +
                    "WHERE user_id = (SELECT user_id FROM users WHERE username = ?)) " +
                    "AND user_id IN (SELECT user_id FROM users WHERE role = 'ROLE_USER' ));";
            List<Integer> userIDs = jdbcTemplate.queryForList(usersToInsertSql, Integer.class, username);
            for(int i = 0; i < userIDs.size(); i++){
                jdbcTemplate.update(sql, userIDs.get(i), prizeId);
            }
        } else if(prizeRole.equals(roleAdmin)){
            String adminsToInsertSql = "SELECT user_id FROM user_family WHERE (family_id = (SELECT family_id FROM user_family " +
                    "WHERE user_id = (SELECT user_id FROM users WHERE username = ?)) " +
                    "AND user_id IN (SELECT user_id FROM users WHERE role = 'ROLE_ADMIN' ));";
            List<Integer> adminIDs = jdbcTemplate.queryForList(adminsToInsertSql, Integer.class, username);
            for(int i = 0; i < adminIDs.size(); i++){
                jdbcTemplate.update(sql, adminIDs.get(i), prizeId);
            }
        } else {
            String familyToInsertSql = "SELECT user_id FROM user_family WHERE (family_id = (SELECT family_id FROM user_family " +
                    "WHERE user_id = (SELECT user_id FROM users WHERE username = ?)));";
            List<Integer> allFamilyIDs = jdbcTemplate.queryForList(familyToInsertSql, Integer.class, username);
            for(int i = 0; i < allFamilyIDs.size(); i++){
                jdbcTemplate.update(sql, allFamilyIDs.get(i), prizeId);
            }
        }

    }

    @Override
    public List<Prize> getActivePrizes(String username, String userRole){
        List<Prize> prizes = new ArrayList<>();

        if(userRole.equals(roleUser)){
            String sql = "SELECT * FROM prize p " +
                    "JOIN user_prize up ON up.prize_id = p.id " +
                    "WHERE up.user_id = (SELECT user_id FROM users WHERE username = ?) AND p.is_active = true AND up.is_complete = false " +
                    "ORDER BY end_date DESC;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while(results.next()){
                prizes.add(mapRowToPrize(results));
            }
        } else if (userRole.equals(roleAdmin)){
            String sql = "SELECT * FROM prize p JOIN user_prize up ON up.prize_id = p.id " +
                    "WHERE up.user_id IN (SELECT user_id FROM user_family WHERE  " +
                    "family_id = (SELECT family_id FROM user_family WHERE " +
                    "user_id = (SELECT user_id FROM users WHERE username = ?))) " +
                    "AND p.is_active = true  AND up.is_complete = false " +
                    "ORDER BY end_date DESC;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while (results.next()){
                prizes.add(mapRowToPrize(results));
            }
        }


        return prizes;
    }

    @Override
    public List<Prize> getActivePrizesByFamily(String username){
        List<Prize> prizes = new ArrayList<>();
        String sql = "SELECT * FROM prize p JOIN user_prize up ON up.prize_id = p.id " +
                "WHERE up.user_id IN (SELECT user_id FROM user_family WHERE  " +
                "family_id = (SELECT family_id FROM user_family WHERE " +
                "user_id = (SELECT user_id FROM users WHERE username = ?))) " +
                "AND p.is_active = true  AND up.is_complete = false;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while (results.next()){
            prizes.add(mapRowToPrize(results));
        }

        return prizes;
    }

    @Override
    public void updateUserPrizeCompletion(Prize prize, String username){

        String sql = "SELECT SUM(minutes_read) FROM activity_log " +
                "WHERE user_id = (SELECT user_id FROM users WHERE username = ?)  " +
                "AND date_logged BETWEEN ? AND ?;";
        Integer minutesReadForPrize = jdbcTemplate.queryForObject(sql, Integer.class, username, prize.getStartDate(), prize.getEndDate());

        String updateSql = "UPDATE user_prize SET is_complete = true " +
                "WHERE (user_id = (SELECT user_id FROM users WHERE username = ?) AND  " +
                "prize_id IN (SELECT id FROM prize WHERE milestone < ?));";
        jdbcTemplate.update(updateSql, username, prize.getMilestone());
    }

    @Override
    public void updatePrizeCompletion(Prize prize){
        String sql = "UPDATE prize SET is_active = false " +
                "WHERE ? < CURRENT_DATE OR ? >= ?;";
        jdbcTemplate.update(sql, prize.getEndDate(), prize.getNumOfPrizeWinners(), prize.getMaxPrize());
    }

    @Override
    public void updatePrize (Prize updatedPrize){
        String sql = "UPDATE prize SET prize_name = ?, milestone = ?, user_role = ?, " +
                "start_date = ?, end_date = ?, is_active = true, prize_winners = ? " +
                "WHERE id = ?;";
        jdbcTemplate.update(sql, updatedPrize.getPrizeName(), updatedPrize.getMilestone(), updatedPrize.getUserRole(),
            updatedPrize.getStartDate(), updatedPrize.getEndDate(), updatedPrize.getNumOfPrizeWinners(), updatedPrize.getPrizeID());
    }

    @Override
    public void deletePrize (int prizeID){
        String deleteSql = "DELETE FROM user_prize WHERE prize_id = ?";
        jdbcTemplate.update(deleteSql, prizeID);
        String sql = "DELETE FROM prize WHERE id = ?;";
        jdbcTemplate.update(sql, prizeID);
    }

    public Prize mapRowToPrize(SqlRowSet rs){
        Prize prize = new Prize();

            prize.setPrizeName(rs.getString("prize_name"));
            prize.setDescription(rs.getString("description"));
            prize.setActive(rs.getBoolean("is_active"));
            prize.setMaxPrize(rs.getInt("max_prize"));
            prize.setStartDate(rs.getDate("start_date").toLocalDate());
            prize.setEndDate(rs.getDate("end_date").toLocalDate());
            prize.setMilestone(rs.getInt("milestone"));
            prize.setNumOfPrizeWinners(rs.getInt("prize_winners"));
            prize.setPrizeID(rs.getInt("id"));
            prize.setUserRole(rs.getString("user_role"));

        return prize;
    }

}
