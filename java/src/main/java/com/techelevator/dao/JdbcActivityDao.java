package com.techelevator.dao;

import com.techelevator.model.Activity;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcActivityDao implements ActivityDao {

    public int logNewActivity(String username, Activity activity){

        return 1; //TODO: update return value
    }

    public List<Activity> getActivitiesByUsername(String username){
        List<Activity> returnList = new ArrayList<>();

        return returnList;
     }

    public List<Activity> getChildActivities(int userID){
        List<Activity> returnList = new ArrayList<>();

        return returnList;
    }

    public List<Activity> getActivitiesByFamily(){
        List<Activity> returnList = new ArrayList<>();

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
