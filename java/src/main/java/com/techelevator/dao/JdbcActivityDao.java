package com.techelevator.dao;

import com.techelevator.model.Activity;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcActivityDao implements ActivityDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcActivityDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    private final String roleAdmin = "ROLE_ADMIN";
    private final String roleUser = "ROLE_USER";

    public void logNewActivity(String username, Activity activity){

        if(activity.getNotes()!= null){
            String sql = "INSERT INTO activity_log(user_id, book_id, format_id, minutes_read, notes)  " +
                    "VALUES((SELECT user_id FROM users WHERE username = ?), (SELECT id FROM book WHERE title = ?),  " +
                    "(SELECT id FROM format WHERE description = ?), ?, ?) ;" ;
            jdbcTemplate.update(sql, username, activity.getTitle(), activity.getDescription(), activity.getMinutesRead(), activity.getNotes());
        } else{
            String sql = "INSERT INTO activity_log(user_id, book_id, format_id, minutes_read)  " +
                    "VALUES((SELECT user_id FROM users WHERE username = ?), (SELECT id FROM book WHERE title = ?),  " +
                    "(SELECT id FROM format WHERE description = ?), ?); ";
            jdbcTemplate.update(sql, username, activity.getTitle(), activity.getDescription(), activity.getMinutesRead());
        }
    }

    public List<Activity> getActivities(String username, String userRole){
        List<Activity> returnList = new ArrayList<>();
        if(userRole.equals(roleUser)) {
            String sql = "SELECT al.id, username, title, description, minutes_read, notes  " +
                    "FROM activity_log al JOIN users u ON u.user_id = al.user_id  " +
                    "JOIN book b ON b.id = al.book_id  " +
                    "JOIN format f ON f.id = al.format_id " +
                    "WHERE al.user_id = (SELECT user_id from users WHERE username = ?);";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while (results.next()) {
                returnList.add(mapRowToActivity(results));
            }
        } else if (userRole.equals(roleAdmin)) {
            String sql = "SELECT al.id, username, title, description, minutes_read, notes, al.date_logged  " +
                    "FROM activity_log al JOIN users u ON u.user_id = al.user_id  " +
                    "JOIN book b ON b.id = al.book_id  " +
                    "JOIN format f ON f.id = al.format_id " +
                    "WHERE (al.user_id IN " +
                    "(SELECT user_id FROM user_family WHERE family_id = (SELECT id FROM family_unit WHERE family_name =  " +
                    "(SELECT family_name FROM family_unit WHERE id = (SELECT family_id from user_family WHERE user_id =  " +
                    "(SELECT user_id from users WHERE username = ?)))))) " +
                    "ORDER BY username, date_logged DESC ;";


            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while(results.next()){
                returnList.add(mapRowToActivity(results));
            }
        }

        return returnList;
    }


    public void updateActivity(){

    }

    public void deleteActivity(){


    }

    public Activity mapRowToActivity(SqlRowSet rs){
        Activity activity = new Activity();
        activity.setActivityID(rs.getInt("id"));
        activity.setMinutesRead(rs.getInt("minutes_read"));
        activity.setUsername(rs.getString("username"));
        activity.setTitle(rs.getString("title"));
        activity.setDescription(rs.getString("description"));
       if(rs.getString("notes")!=null) {
           activity.setNotes(rs.getString("notes"));
       }
       activity.setDateLogged(rs.getDate("date_logged").toLocalDate());
        return activity;
    }

}