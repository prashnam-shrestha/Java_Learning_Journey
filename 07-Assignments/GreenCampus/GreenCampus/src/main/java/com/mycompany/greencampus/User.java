/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencampus;

import static com.mycompany.greencampus.CampusData.uniqueId;
import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public abstract class User {
    
    private String Id;
    private String name;
    private String email;
    private String password;
    
    public User(String name, String email,  String password) {
        
        setName(name);
        setEmail(email);
        setPassword(password);
        setUniqueId(String.valueOf(uniqueId));
        uniqueId++;
        
    }
    public abstract void displayRole();
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniqueId() {
        return Id;
    }

    public void setUniqueId(String uniqueId) {
        this.Id = uniqueId;
    }
    
    
    
}
