/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apexcapitalbank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author prashnamshrestha
 */
public class appUser implements Serializable{
    private String name;
    private String phone;
    private String password;
    private LocalDate dateOfBirth;
    
    // ------- Constructors --------
    public appUser(String name, String phone, LocalDate dateOfBirth, String password) {
        setName(name);
        setPhone(phone);
        setDateOfBirth(dateOfBirth);
        setPassword(password);
    }
    
    // ------- Methods --------------
    
    // Get info
    public String getInfoGeneral() {
        String info = String.format("  > Name: %s\n  > Phone: %s\n  > DOB: %s\n  > Pass: %s", getName(), getPhone(), getDateOfBirth(), getPassword());
        return info;
    }
    
   
    
    // ------- Getters and Setters -----------
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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