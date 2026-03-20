/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencampus;


/**
 *
 * @author prashnamshrestha
 */
public class Admin extends User implements Reportable {
    
    // Constructor for admins
    public Admin(String name, String email, String password) {
        
        super(name, email, password);
        
    }
    // Methods
    public void displayRole() {
        System.out.println("Your role is an admin!");
    }
    
    public void viewAllActivity(CampusData data) {
        
        System.out.println();
        if (data.getActivities().size() == 0) {
            
            System.out.println("No logged green activities yet.");
            return;
        }
        
        System.out.println("\n==== All Green Activities ====");
        int num = 1;
        for (GreenActivity a: data.getActivities()) {
            System.out.printf("%s. |  %s | %s | %s |\n",num, a.getDate(), a.getNormalUser().getName() , a.getActivityName());
            num++;
        }
    }
    
    public void generateReport(CampusData data) {
        
        System.out.println("\n========== Report ===========");
        
        System.out.printf("Total number of Students: %s\n", data.getNormalUsers().size());
        System.out.printf("Total activities logged: %s\n", data.getActivities().size());
        
        // Calculate total points using loop
        int totalPoints = 0;
        for (NormalUser u: data.getNormalUsers()) {
            totalPoints += u.getPoints();
        }
        
        System.out.printf("Total campus points: %s\n", totalPoints);
        
        // Get most common activity with simple math
        int electricityCount = 0;
        int reuseCount = 0;
        int walkingCount = 0;
        
        for (GreenActivity a: data.getActivities()) {
            if (a.getActivityType() == ActivityType.Savingelectricity) {
                electricityCount++;
            }
            else if (a.getActivityType() == ActivityType.UsingReusableMaterials) {
                reuseCount++;
            }
            else {
                walkingCount++;
            }
        }
        
        String popularAction = "Walking/Cycling";
        int highestCount = walkingCount;

        if (electricityCount > highestCount) {
            
            popularAction = "Saving Electricity";
            highestCount = electricityCount;
        }
        if (reuseCount > highestCount) {
            popularAction = "Using Reusable Materials";
            highestCount = reuseCount;
        }
        
       // Print most common activity
        System.out.println("Most Popular Eco-Action: " + popularAction + " (" + highestCount + " times)");
        
    }
    
    
}
