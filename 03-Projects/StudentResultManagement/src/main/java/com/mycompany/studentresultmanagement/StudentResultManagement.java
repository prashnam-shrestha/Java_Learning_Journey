/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.DataManager.*;
import static com.mycompany.studentresultmanagement.InputHelper.*;
import static com.mycompany.studentresultmanagement.MenuPrinter.*;

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
        
        String name = getValidString("Enter name: ");
        
        String password = getValidString("Enter password: ");
        
        for (User user: data.getUsers()) {
   
        }
        
        // else back to main menu 
    }
    
    public static void loggedOperation(User user) {
        
    }
    
    public static String filePath = "InstitutionData";
}
