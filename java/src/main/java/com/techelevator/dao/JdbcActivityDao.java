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

    public void logNewActivity(String username, Activity activity){

        if(activity.getNotes()!= null){
            String sql = "INSERT INTO activity_log(user_id, book_id, format_id, minutes_read, notes)  " +
                    "VALUES((SELECT user_id FROM users WHERE username = ?), (SELECT id FROM book WHERE title = ?),  " +
                    "(SELECT id FROM format WHERE description = ?), ?, ?); ";
            jdbcTemplate.update(sql, username, activity.getTitle(), activity.getDescription(), activity.getMinutesRead(), activity.getNotes());
        } else{
            String sql = "INSERT INTO activity_log(user_id, book_id, format_id, minutes_read)  " +
                    "VALUES((SELECT user_id FROM users WHERE username = ?), (SELECT id FROM book WHERE title = ?),  " +
                    "(SELECT id FROM format WHERE description = ?), ?); ";
            jdbcTemplate.update(sql, username, activity.getTitle(), activity.getDescription(), activity.getMinutesRead());
        }
    }

    public List<Activity> getActivitiesByUsername(String username){
        List<Activity> returnList = new ArrayList<>();
        String sql = "SELECT * FROM activity_log where user_id = (select user_id from users where username = ?); ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while(results.next()){
            returnList.add(mapRowToActivity(results));
        }

        return returnList;
    }

    public List<Activity> getChildActivities(String username){
        List<Activity> returnList = new ArrayList<>();
        String sql = "SELECT * FROM activity_log where user_id = (select user_id from users where username = ?); ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while(results.next()){
            returnList.add(mapRowToActivity(results));
        }

        return returnList;
    }

    public List<Activity> getActivitiesByFamily(){
        List<Activity> returnList = new ArrayList<>();
        String sql = "SELECT u.username, b.title, f.description, al.minutes_read, al.notes  " +
                "FROM activity_log al JOIN users u ON u.user_id = al.user_id  " +
                "JOIN book b ON b.id = al.book_id  " +
                "JOIN format f ON f.id = al.format_id " +
                "WHERE (al.user_id IN " +
                "(SELECT user_id FROM user_family WHERE family_id = (SELECT id FROM family_unit WHERE  family_name =  " +
                "(SELECT family_name FROM family_unit WHERE id = (SELECT family_id from user_family WHERE user_id =  " +
                "(SELECT user_id from users WHERE username = ?))))));";


        return returnList;
    }

    public void updateActivity(){

    }

    public void deleteActivity(){

    }

    public Activity mapRowToActivity(SqlRowSet rs){
        Activity activity = new Activity();
        activity.setActivityID(rs.getInt("id"));
        activity.setBookID(rs.getInt("book_id"));
        activity.setUserID(rs.getInt("user_id"));
        activity.setFormatID(rs.getInt("format_id"));
        activity.setMinutesRead(rs.getInt("minutes_read"));
        activity.setNotes("notes");
        return activity;
    }
}