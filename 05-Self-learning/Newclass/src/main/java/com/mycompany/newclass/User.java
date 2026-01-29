/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newclass;

/**
 *
 * @author prashnamshrestha
 */
public class User {
    private String _name = "No name";
    private String _membership = "Bronze";
    
    public String toString() {
        return "tacos";
    }
    
    // Constructors
    public User(String name, Membership membership) {
        setName(name);
        setMembership(membership);
    }
    
    public boolean equals(User compare) {
        if((compare.getName() == getName()) 
                && (compare.getMembership() == getMembership())) {
            return true;
        } 
        return false;
    }
    // Default constructors
    public User() {
    }

    
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getMembership() {
        return _membership;
    }
    
    public void setMembership(Membership membership) {
        _membership = membership.name();
    }
    
    public enum Membership {
        Bronze, Silver, Gold;
    }

    public void setMembership(String membership) {
        this._membership = membership;
    }

    
    
}
