/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.userfactory;

/**
 *
 * @author prashnamshrestha
 */
public class UserFactoryOperation {
    
    public static User createUser(UserType type, String name, String password, String id) throws InvalidUserTypeException {
        
        switch(type) {
            case UserType.STUDENT:
                return new Student(name, password, id);
                
            case UserType.ADMIN:
                return new Admin(name, password, id);
                
            default:
                throw new InvalidUserTypeException("User type is not defined");
        }
    }
}
