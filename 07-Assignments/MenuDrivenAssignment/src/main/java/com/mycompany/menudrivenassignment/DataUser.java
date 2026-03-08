/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menudrivenassignment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public class DataUser {
    private static List<User> users = new ArrayList<>();
    
    public DataUser() {
        
    }
    
    public void addUser(User u) {
        users.add(u);
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        DataUser.users = users;
    }
    
    
    
}
