package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.User;

import java.util.List;

public interface FamilyDao {

    public void createFamily(String username, String familyName);

    public void addFamilyMember(String username, String currentUser);

    public List<User> returnAllFamilyMembers(String username);

    public void removeFamilyMember(String username, String currentUser);

    public boolean sysUser(String username);

    public String getFamilyName(String username);

}
