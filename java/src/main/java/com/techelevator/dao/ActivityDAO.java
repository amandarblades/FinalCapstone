package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.List;

public interface ActivityDao {

    public int logNewActivity(String username, Activity activity);

    public List<Activity> getActivitiesByUsername(String username);

    public List<Activity> getChildActivities(int userID);

    public List<Activity> getActivitiesByFamily();

    public void updateActivity();

    public void deleteActivity();

}