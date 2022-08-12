package com.techelevator.controller;

import com.techelevator.dao.ActivityDao;
import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(value="/addActivity", method = RequestMethod.POST)
    public void logActivity(@Valid @RequestBody Activity newActivity, Principal principal){
        String username = getCurrentUsername(principal);
        activityDao.logNewActivity(username, newActivity);

    }

    private String getCurrentUsername(Principal principal){
        return principal.getName();
    }

}
