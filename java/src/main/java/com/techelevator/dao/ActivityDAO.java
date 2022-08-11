package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.List;

public interface ActivityDAO {

    public void logActivity();

    public List<Activity> getActivitiesByUsername();

    public List<Activity> getActivitiesByFamily();

    public void updateActivity();

    public void deleteActivity();


}
