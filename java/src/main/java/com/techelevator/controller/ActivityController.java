package com.techelevator.controller;

import com.techelevator.dao.ActivityDao;
import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ActivityController {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ActivityDao activityDao;

    public ActivityController(ActivityDao activityDao, BookDao bookDao, UserDao userDao){
        this.bookDao = bookDao;
        this.userDao = userDao;
        this.activityDao = activityDao;
    }

    @RequestMapping(value="/addactivity", method = RequestMethod.POST)
    public void logActivity(@Valid @RequestBody Activity newActivity){

        //String username = "Nate"; //getCurrentUsername(principal);
        activityDao.logNewActivity(newActivity);

    }


    @RequestMapping(value="/getactivities", method = RequestMethod.GET)
    public List<Activity> getUserActivities(Principal principal){
        List<Activity> activities = new ArrayList<>();
        String username = "Nate"; //getCurrentUsername(principal);
        String userRole = userDao.getUserRole(username);
         activities = activityDao.getActivities(username, userRole);
        return activities;
    }

    private String getCurrentUsername(Principal principal){
        return principal.getName();
    }

}