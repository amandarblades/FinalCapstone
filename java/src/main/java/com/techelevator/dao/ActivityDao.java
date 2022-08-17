package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.List;

public interface ActivityDao {

    public void logNewActivity(Activity activity);

    public List<Activity> getActivities(String username, String userRole);

    public void updateActivity();

    public void deleteActivity();

}