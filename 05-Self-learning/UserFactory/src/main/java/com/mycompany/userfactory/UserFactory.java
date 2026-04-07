/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.userfactory;

import static com.mycompany.userfactory.UserFactoryOperation.*;

/**
 *
 * @author prashnamshrestha
 */
public class UserFactory {

    public static void main(String[] args) {
       
        try {
            User user = createUser(UserType.TEACHER, "Prashnam", "pass", "STD0001");
            System.out.println(user.getName());
            
           
        }
        catch (InvalidUserTypeException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
