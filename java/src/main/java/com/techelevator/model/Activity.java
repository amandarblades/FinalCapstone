package com.techelevator.model;

import java.time.LocalDate;

public class Activity {

    private int activityID;
    private int bookID;
    private int userID;
    private int formatID;
    private int minutesRead;
    private String notes;
    private String title;
    private String description;
    private String username;
    private LocalDate dateLogged;

    public LocalDate getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(LocalDate dateLogged) {
        this.dateLogged = dateLogged;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Activity(){

    }

    public Activity(int activityID, int bookID, int userID, int formatID, int minutesRead) {
        this.activityID = activityID;
        this.bookID = bookID;
        this.userID = userID;
        this.formatID = formatID;
        this.minutesRead = minutesRead;
    }

    public Activity(int activityID, int bookID, int userID, int formatID, int minutesRead, String notes, String title, String description) {
        this.activityID = activityID;
        this.bookID = bookID;
        this.userID = userID;
        this.formatID = formatID;
        this.minutesRead = minutesRead;
        this.notes = notes;
        this.title = title;
        this.description = description;
    }

    public Activity(int activityID, int bookID, int userID, int formatID, int minutesRead, String notes, String title, String description, String username, LocalDate dateLogged) {
        this.activityID = activityID;
        this.bookID = bookID;
        this.userID = userID;
        this.formatID = formatID;
        this.minutesRead = minutesRead;
        this.notes = notes;
        this.title = title;
        this.description = description;
        this.username = username;
        this.dateLogged = dateLogged;
    }
}