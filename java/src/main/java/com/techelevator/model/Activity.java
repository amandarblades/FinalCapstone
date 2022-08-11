package com.techelevator.model;

public class Activity {

    private int activityID;
    private int bookID;
    private int userID;
    private int formatID;
    private int minutesRead;
    private String notes;

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getFormatID() {
        return formatID;
    }

    public void setFormatID(int formatID) {
        this.formatID = formatID;
    }

    public int getMinutesRead() {
        return minutesRead;
    }

    public void setMinutesRead(int minutesRead) {
        this.minutesRead = minutesRead;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Activity(int activityID, int bookID, int userID, int formatID, int minutesRead) {
        this.activityID = activityID;
        this.bookID = bookID;
        this.userID = userID;
        this.formatID = formatID;
        this.minutesRead = minutesRead;
    }

    public Activity(){

    }

}
