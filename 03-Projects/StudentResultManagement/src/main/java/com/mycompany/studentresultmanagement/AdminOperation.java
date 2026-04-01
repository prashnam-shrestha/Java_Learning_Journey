/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.InputHelper.*;
import static com.mycompany.studentresultmanagement.MenuPrinter.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author prashnamshrestha
 */
public class AdminOperation implements Serializable{
    
    public static void loggedAdminOperation(Admin admin, Data data) {
        
        boolean run = true;
        
        while (run) {
            
            printAdminMenu();
            int adminChoice = getValidInt("Enter choice: ", 1, 8);
            
            switch(adminChoice) {
                
                case 1:
                    admin.manageStudents(data); // MANAGE STUDENT
                    break;
                    
                case 2:
                    admin.manageSubjects(data); // MANAGE SUBJECTS
                    break;
                    
                case 3:
                    admin.manageEnrollments(); // MANAGE ENROLLMENTS
                    break;
                    
                case 4:
                    admin.manageGrades(); // ENTER GRADES
                    break;
                    
                case 5:
                    admin.getResult(); // VIEW RESULT
                    break;
                    
                case 6:
                    admin.getReportCard(); // GET REPORT CARD
                    break; 
                    
                case 7:
                    break; // MANAGE ADMINS
                    
                case 8:
                    run = false; // LOGOUT
                    break;
                
                default:
            }
  

        }
 
    }
    public static void removeStudentOperation(Data data) {
        String studentId = getValidString("Enter Student ID: ");
        
        Optional<Student> student = data.getStudents().stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst();
        
        if (student.isPresent()) {
            Student studentToRemove = student.get();
            data.removeStudent(studentToRemove);
        }
        else {
            System.out.printf("- Student [%s] not found!\n", studentId);
        }
    }
    
    public static void addStudentOperation(Data data) {
        
        String name = getValidString("Enter name: ");
        String password = getValidString("Create password: ");

        while (true) {
            try {
                String id = getValidString("Create ID: ");

                boolean stdExists = data.getStudents().stream()
                        .anyMatch(s -> s.getStudentId().equals(id));
                
                if (stdExists) {
                    throw new InputStudentIdExists("- Student ID already exists!");
                }
                        
                Student studentNew = new Student(name, password, id);
                data.addStudent(studentNew);
                return;
                
            }
            catch (InputStudentIdExists e) {
                System.out.println(e.getMessage());
            }
        }

    }
    
    public static void viewStudentOperation(Data data) {
        
        if (data.getStudents().size() == 0) {
            System.out.println("- Insufficient students to display!");
            return;
        }
        
        System.out.println("==============================");
        System.out.println("  ID     |   NAME ");
        System.out.println("==============================");
        data.getStudents().stream()
                .forEach(s -> System.out.printf(" %s | %s\n", s.getStudentId(), s.getName()));
    }
}
