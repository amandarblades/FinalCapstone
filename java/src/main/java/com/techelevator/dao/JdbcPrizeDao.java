package com.techelevator.dao;

import com.techelevator.model.Prize;
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
    

    public void createPrize(Prize newPrize){

    }

    public List<Prize> getActivePrizesByUser(String username){
        List<Prize> prizes = new ArrayList<>();
        String sql = "SELECT * FROM prize p " +
                "JOIN user_prize up ON up.prize_id = p.id " +
                "WHERE up.user_id = (SELECT user_id FROM users WHERE username = ?) AND p.is_active = true AND up.is_complete = false;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while(results.next()){
            prizes.add(mapRowToPrize(results));
        }

        return prizes;
    }

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

    public void updatePrizeCompletion(Prize prize){
        String sql = "UPDATE prize SET is_active = false " +
                "WHERE ? < CURRENT_DATE OR ? >= ?;";
        jdbcTemplate.update(sql, prize.getEndDate(), prize.getNumOfPrizeWinners(), prize.getMaxPrize());
    }

    //TODO: update prize
    public void updatePrize (Prize updatedPrize){}

    public void deletePrize (Prize deletedPrize){
        String sql = "DELETE FROM prize WHERE prize_id = ?;";
        jdbcTemplate.update(sql, deletedPrize.getPrizeID());
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
