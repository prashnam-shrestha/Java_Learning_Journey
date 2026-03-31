/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.InputHelper.*;
import static com.mycompany.studentresultmanagement.MenuPrinter.*;
import static com.mycompany.studentresultmanagement.AdminOperation.*;

/**
 *
 * @author prashnamshrestha
 */
public class Admin extends User {
    
    public Admin(String name, String password) {
        super(name, password);
    }
    
    // METHODS
    public void manageStudents(Data data) {
        
        while (true) {
            printStudentManagementMenu();
            
            int choice = getValidInt("Ente choice: ", 1, 4);

            switch(choice) {
                
                // Add student;
                case 1:
                    addStudentOperation(data);
                    break;
                
                // Remove student;
                case 2:
                    break;
                   
                // View all student;
                case 3:
                    break;
                
                // Exit back
                case 4:
                    return;
                    
                default:

            }
        }
    }
    
    public void manageSubjects() {
        
    }
    
    public void manageEnrollments() {
        
    }
    
    public void manageGrades() {
        
    }
    
    public String getResult() {
        return "";
    }
    
    public String getReportCard() {
        return "";
    }
}
