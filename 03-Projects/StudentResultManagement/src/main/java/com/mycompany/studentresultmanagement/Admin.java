/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.InputHelper.*;
import static com.mycompany.studentresultmanagement.MenuPrinter.*;
import static com.mycompany.studentresultmanagement.AdminOperation.*;
import static com.mycompany.studentresultmanagement.DataManager.saveAppState;
import static com.mycompany.studentresultmanagement.StudentResultManagement.filePath;
import java.io.Serializable;

/**
 *
 * @author prashnamshrestha
 */
public class Admin extends User implements Serializable {
    
    public Admin(String name, String password) {
        super(name, password);
    }
    
    // METHODS
    public void manageStudents(Data data){
        
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
                    removeStudentOperation(data);
                    break;
                   
                // View all student;
                case 3:
                    viewStudentOperation(data);
                    break;
                
                // Exit back
                case 4:
                    saveAppState(data, filePath);
                    return;
                    
                default:

            }
        }
    }
    
    public void manageSubjects(Data data) {
        
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
