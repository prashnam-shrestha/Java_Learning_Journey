/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencampushelper;

/**
 *
 * @author prashnamshrestha
 */
public class User {
    private String name;
    private String password;
    
    public User(String name, String password) {
        
        setName(name);
        setPassword(password);
    }

    public String getInfo() {
        return String.format("Name: %s | Password: %s ", getName(), getPassword());
    }
    
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
