/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencampus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public class CampusData {
    
    // Static variable for ID 
    public static int uniqueId = 100;
    
    // Place to store data
    private List<User> users;
    private List<NormalUser> normalUsers;
    private List<Admin> admins;
    private List<GreenActivity> activities;
    
    
    // Constructor
    public CampusData() {
        
        setUsers(new ArrayList<>());
        setNormalUsers(new ArrayList<>());
        setAdmins(new ArrayList<>());
        setActivities(new ArrayList<>());
        
    }
    // Methods
    public void addNormalUser(NormalUser normalUser) { // Add normal user
        
        getNormalUsers().add(normalUser);
        getUsers().add(normalUser);
    }
    public boolean removeNormalUser(NormalUser normalUser) { // Remove normal user
        
        getUsers().remove(normalUser);
        return getNormalUsers().remove(normalUser);
        
    }
     
    public void addAdmins(Admin admin) { // Add admins
        
        getAdmins().add(admin);
        getUsers().add(admin);
    }
    public boolean removeAdmin(Admin admin) { // Remove admins
        
        getUsers().remove(admin);
        return getAdmins().remove(admin);
    }
    
    public void addActivity(GreenActivity activity) { // Add activities
        
        getActivities().add(activity);
    }
    public boolean removeActivity(GreenActivity activity) { // Remove activities
        
        return getActivities().remove(activity);
    }
    

    // Gettes and Setters

    public List<NormalUser> getNormalUsers() {
        return normalUsers;
    }

    public void setNormalUsers(List<NormalUser> normalUsers) {
        this.normalUsers = normalUsers;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<GreenActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<GreenActivity> activities) {
        this.activities = activities;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    
    
}
