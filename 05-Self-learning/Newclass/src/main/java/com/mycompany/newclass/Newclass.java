/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.newclass;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */

// Classes
public class Newclass {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Prashnam",User.Membership.Gold));
        users.add(new User("Atrina",User.Membership.Silver));
        users.add(new User("Abnavita",User.Membership.Silver));
        
        for (User u: users) 
        {
            System.out.println(u.getName());
        }

    }   
}
