package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.FamilyDao;
import com.techelevator.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class FamilyController {

    @Autowired
    private FamilyDao familyDao;
    @Autowired
    private UserDao userDao;

    public FamilyController(FamilyDao familyDao, UserDao userDao){
        this.familyDao = familyDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/addfamily/{familyName}", method = RequestMethod.POST)
    public void createFamily(@PathVariable String familyName, Principal principal){
        String username = getCurrentUsername(principal);
        familyDao.createFamily(username, familyName);
    }

    @RequestMapping(value = "/addfamilymember/{addedUsername}", method = RequestMethod.POST)
    public void addMemberToFamily(@PathVariable String addedUsername, Principal principal){
        String currentUser = getCurrentUsername(principal);
        familyDao.addFamilyMember(addedUsername, currentUser);
    }

    @RequestMapping(value = "/removefamilymember/{removedUsername}", method = RequestMethod.DELETE)
    public void removedMemberFromFamily(@PathVariable String removedUsername, Principal principal){
        String currentUser = getCurrentUsername(principal);
        familyDao.removeFamilyMember(removedUsername, currentUser);
    }

    private String getCurrentUsername(Principal principal){
        return principal.getName();}

}
