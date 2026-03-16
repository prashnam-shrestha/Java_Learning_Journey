/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencampus;

import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public class GreenActivity {
    
    private String activityName;
    private int points;
    private NormalUser normalUser;
    private LocalDate date;
    private ActivityType activityType;
    
    public GreenActivity(String actname, NormalUser u, ActivityType activityType) {
        
        setActivityName(actname);
        setNormalUser(u);
        setDate(LocalDate.now());
        setActivityType(activityType);
        calculatePoints();
    }
    
    // MEthods
    public void calculatePoints() {
        
        if (getActivityType() == ActivityType.WalkingorCycling ) {
            this.points = 20;
        } else if (getActivityType() == ActivityType.Savingelectricity) {
            this.points = 15;
        } else if (getActivityType() == ActivityType.UsingReusableMaterials) {
            this.points = 20;
        } else {
            this.points = 5; // default
        }
    }

    // Getters and Setters
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public NormalUser getNormalUser() {
        return normalUser;
    }

    public void setNormalUser(NormalUser normalUser) {
        this.normalUser = normalUser;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
    
    
    
}
