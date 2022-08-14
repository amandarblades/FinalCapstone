package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.List;

public interface ActivityDao {

    public void logNewActivity(String username, Activity activity);

    public List<Activity> getActivitiesByUsername(String username);

    public List<Activity> getChildActivities(String username);

    public List<Activity> getActivitiesByFamily();

    public void updateActivity();

    public void deleteActivity();

}