/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencampus;

import static com.mycompany.greencampus.GreenCampus.data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public class NormalUser extends User {
    
    private int points;
    private List<GreenActivity> activityUser;
    
    public NormalUser(String name, String email, String password, int point) {
        
        super(name, email, password);
        setPoints(point);
        setActivityUser(new ArrayList<>());
        
    }
    // Methods
    public void displayRole() {
        System.out.println("Your role is a student!");
    }
    
    // Log activity
    public void logActivityUser(GreenActivity activity) {
        
        getActivityUser().add(activity);
        
        // If activity is added USER gets point
        setPoints(getPoints() + activity.getPoints());
        
        // Adding in master 
        data.addActivity(activity);
        
    }
    
    // View my activity
    public void viewMyActivity() {
        
        System.out.println();
        if (this.getActivityUser().size() == 0) {
            
            System.out.println("You haven't logged any green activities yet.");
            System.out.printf("Total Points Earned: %s\n", getPoints());
            return;
        }
        
        int num = 1;
        System.out.println("==== Green Activities Logged ====");
        for (GreenActivity a: getActivityUser()) {
            System.out.printf("%s.| %s | %s | Points earned: %s \n",num, a.getDate() ,a.getActivityName(), a.getPoints());
            num++;
        }
        System.out.printf("\nTotal Points Earned: %s\n", getPoints());
    }
    
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<GreenActivity> getActivityUser() {
        return activityUser;
    }

    public void setActivityUser(List<GreenActivity> activityUser) {
        this.activityUser = activityUser;
    }
    
    
}
