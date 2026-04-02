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
import java.util.Optional;

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
        while (true) {
            printSubjectManagementMenu();
            
            int choice = getValidInt("Ente choice: ", 1, 4);

            switch(choice) {
                
                // Add subject;
                case 1:
                    addSubjectOperation(data);
                    break;
                
                // Remove subject;
                case 2:
                    removeSubjectOperation(data);
                    break;
                   
                // View all subject;
                case 3:
                    viewSubjectOperation(data);
                    break;
                
                // Exit back
                case 4:
                    saveAppState(data, filePath);
                    return;
                    
                default:

            }
        }
        
    }
    
    public void manageEnrollments(Data data) {
        while (true) {
            
            printEnrollmentMenu();
            
            int choice = getValidInt("Ente choice: ", 1, 3);

            switch(choice) {
                
                // Enroll student to subject
                case 1:
                    enrollStudent(data);
                    break;
                
                // View Enrollment;
                case 2:
                    viewEnrollment(data);
                    break;
                
                // Exit back
                case 3:
                    saveAppState(data, filePath);
                    return;
                    
                default:

            }
        }
    }
    
    public void manageGrades(Data data) {
        
        String studentId = getValidString("Enter Student ID: ");
        
        Optional<Student> student = data.getStudents().stream()
                .filter(std -> std.getStudentId().equals(studentId))
                .findFirst();
        
        if (student.isPresent()) {
            Student studentFound = student.get();
            
            if (studentFound.getEnrolledSubjects().isEmpty()) {
                System.out.printf("- Student [%s] not enrolled in any subject\n", studentId);
                return;
            }
            
            String subjectId = getValidString("Enter Subject ID: ");
            
            Optional<Subject> subject = studentFound.getEnrolledSubjects().stream()
                .filter(sub -> sub.getSubjectCode().equals(subjectId))
                .findFirst();
            
            if (subject.isPresent()) {
                int totalMarks = subject.get().getTotalMarks();
                int mark = getValidInt(String.format("Enter Mark(0-%s): ", totalMarks), 0, totalMarks);
                
                subject.get().setObtainedMarks(mark);
                System.out.printf("- Grade entered successfully for %s\n", subject.get().getSubjectName());
                
            }
            else {
                System.out.printf("Subject [%s] not in enrollments\n", subjectId);
            }
        }
        else {
            System.out.printf("- Student [%s] not found\n", studentId);
        }
    }
    
}
