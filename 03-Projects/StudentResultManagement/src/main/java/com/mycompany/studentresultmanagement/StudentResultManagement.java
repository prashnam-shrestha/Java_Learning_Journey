/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.AdminOperation.*;
import static com.mycompany.studentresultmanagement.DataManager.*;
import static com.mycompany.studentresultmanagement.InputHelper.*;
import static com.mycompany.studentresultmanagement.MenuPrinter.*;
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
    
    public static void loggedStudentOperation(Student student) {
        
        boolean run = true;
        
        while (run) {
            printStudentMenu();
            
            int stdChoice = getValidInt("Enter Choice: ", 1, 3);
            
            switch(stdChoice) {
                
                case 1:
                    
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    run = false;
                    break;
                    
                default:
                    
            }
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
    
    public static String getGradeLetter(Subject s) {
        int m = s.getObtainedMarks();
        return (m >= 90) ? "A+" :
               (m >= 80) ? "A"  :
               (m >= 70) ? "B+" :
               (m >= 60) ? "B"  :
               (m >= 50) ? "C+" :
               (m >= 40) ? "C"  : "F";
    }
    
    public static double getGradeGpa(Student student) {
        int totalMarks = 0;
        int obtainedMarks = 0;

        if (student.getEnrolledSubjects().size() == 0) {
            return 0.0;
        }

        for (Subject s : student.getEnrolledSubjects()) {
            totalMarks += s.getTotalMarks();
            obtainedMarks += s.getObtainedMarks();
        }

        double percentage = (obtainedMarks * 100.0) / totalMarks;

        if (percentage >= 90) return 4.0;
        else if (percentage >= 80) return 3.7;
        else if (percentage >= 70) return 3.3;
        else if (percentage >= 60) return 3.0;
        else if (percentage >= 50) return 2.7;
        else if (percentage >= 40) return 2.0;
        else return 0.0;
    }
}
