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
public class Admin extends User implements Reportable {
    
    public Admin(String name, String email, LocalDate dateOfBirth, String password) {
        
        super(name, email, dateOfBirth, password);
        
    }
    // Methods
    public void displayRole() {
        System.out.println("Your role is an admin!");
    }
    
    public void viewAllActivity(CampusData data) {
        int num = 1;
        for (GreenActivity a: data.getActivities()) {
            System.out.printf("%s. |  %s | %s | %s |\n",num, a.getDate(), a.getNormalUser().getName() , a.getActivityName());
            num++;
        }
    }
    
    public void generateReport(CampusData data) {
        System.out.println("To do...");
    }
    
    
}
