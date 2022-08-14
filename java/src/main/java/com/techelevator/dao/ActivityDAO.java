package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.List;

public interface ActivityDao {

    public void logNewActivity(String username, Activity activity);

    public List<Activity> getActivitiesByUsername(String username);

    public List<Activity> getActivitiesByFamily(String username);

    public void updateActivity();

    public void deleteActivity();

}