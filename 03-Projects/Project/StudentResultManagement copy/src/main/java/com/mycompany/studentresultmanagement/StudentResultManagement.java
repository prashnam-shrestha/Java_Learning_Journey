/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.AdminOperation.*;
import static com.mycompany.studentresultmanagement.DataManager.*;
import static com.mycompany.studentresultmanagement.InputHelper.*;
import static com.mycompany.studentresultmanagement.MenuPrinter.*;
import static com.mycompany.studentresultmanagement.StudentOperation.loggedStudentOperation;
import java.util.Optional;

/**
 *
 * @author prashnamshrestha
 */
public class StudentResultManagement {

    public static void main(String[] args) {
        
        Data data = loadAppState(filePath);
        
        while (true) {
            printMainMenu();

            int mainMenuChoice = getValidInt("Enter choice: ", 1, 2);

            switch(mainMenuChoice) {
                
                // LOGIN
                case 1:
                    loginOperation(data);
                    break;
                    
                // EXIT PROGRAM
                case 2:
                    saveAppState(data, filePath);
                    return;

                default:

            }
        }
        
        
    }
    
    public static void loginOperation(Data data) {
        
        String nameOrId = getValidString("Admin name / Student ID: ");
        
        String password = getValidString("Enter password: ");
        
        Optional<User> matched = data.getUsers().stream()
            .filter(u ->  matchesCredentials(u,nameOrId,password))
            .findFirst(); 
                
        User user;
        if (matched.isPresent()) {
            
            user = matched.get();
            
            if (user instanceof Admin) {
                loggedAdminOperation((Admin) user, data);
            }
            else {
                loggedStudentOperation((Student) user);
            }
            
        }
        else {
            System.out.println("- Invalid credentials!");
        } 
    }
    
    
    public static String filePath = "InstitutionData";
    
    private static boolean matchesCredentials(User u, String nameOrId, String password) {
        if (u instanceof Admin) {
            return u.getName().equals(nameOrId) && u.getPassword().equals(password);
        }
        if (u instanceof Student s) {
            return s.getStudentId().equals(nameOrId) && s.getPassword().equals(password);
        }
        return false;
    }
   
    

}
