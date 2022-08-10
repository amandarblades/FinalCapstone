package com.techelevator.model;

public class Family {
    private User [] members;
    private int familyID;
    private String familyName;

    public User[] getMembers() {
        return members;
    }

    public void setMembers(User[] members) {
        this.members = members;
    }

    public int getFamilyID() {
        return familyID;
    }

    public void setFamilyID(int familyID) {
        this.familyID = familyID;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Family(){}

    public Family(User[] members, int familyID, String familyName) {
        this.members = members;
        this.familyID = familyID;
        this.familyName = familyName;
    }
}
