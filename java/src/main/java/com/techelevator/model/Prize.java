package com.techelevator.model;

import java.time.LocalDate;

public class Prize {
    private int prizeID;
    private String prizeName;
    private int milestone;
    private int maxPrize;
    private String description;
    private String userRole;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numOfPrizeWinners;
    private boolean isActive;

    public int getNumOfPrizeWinners() {
        return numOfPrizeWinners;
    }

    public void setNumOfPrizeWinners(int numOfPrizeWinners) {
        this.numOfPrizeWinners = numOfPrizeWinners;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getPrizeID() {
        return prizeID;
    }

    public void setPrizeID(int prizeID) {
        this.prizeID = prizeID;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public int getMilestone() {
        return milestone;
    }

    public void setMilestone(int milestone) {
        this.milestone = milestone;
    }

    public int getMaxPrize() {
        return maxPrize;
    }

    public void setMaxPrize(int maxPrize) {
        this.maxPrize = maxPrize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Prize(){};

    public Prize(int prizeID, String prizeName, int milestone, int maxPrize, String description, String userRole, LocalDate startDate, LocalDate endDate, int numOfPrizeWinners, boolean isActive) {
        this.prizeID = prizeID;
        this.prizeName = prizeName;
        this.milestone = milestone;
        this.maxPrize = maxPrize;
        this.description = description;
        this.userRole = userRole;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numOfPrizeWinners = numOfPrizeWinners;
        this.isActive = isActive;
    }
}
