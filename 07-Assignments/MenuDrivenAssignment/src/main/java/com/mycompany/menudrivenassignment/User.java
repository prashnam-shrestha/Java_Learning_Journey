/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menudrivenassignment;

import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public class User {
    
    private String name;
    private String contactNumber;
    private LocalDate dateOfBirth;
    private String password;
    
    public User(String name, String contact, LocalDate dateOfBirth, String password) {
        
        setName(name);
        setContactNumber(contact);
        setDateOfBirth(dateOfBirth);
        setPassword(password);
        
    }
    public String getUserInfo() {
        return String.format("%s | %s | %s ", getDateOfBirth(), getContactNumber(), getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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
    
    
    
}
