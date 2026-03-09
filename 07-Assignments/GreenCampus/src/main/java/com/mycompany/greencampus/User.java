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
public abstract class User {
    
    private String uniqueId;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String password;
    
    public User(String name, String email, LocalDate dateOfBirth, String password) {
        
        setName(name);
        setEmail(email);
        setDateOfBirth(dateOfBirth);
        setPassword(password);
        setUniqueId(uniqueId);
        
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    
    
    
}
