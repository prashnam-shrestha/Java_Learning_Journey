/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import java.io.Serializable;

/**
 *
 * @author prashnamshrestha
 */
public abstract class User implements Serializable{
    
    private String name;
    private String password;
    
    public User(String name, String password) {
        
        setName(name);
        setPassword(password);
    }
    // METHODS
    public abstract String getResult();
    
    public abstract String getReportCard();
    

    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
