/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.InputHelper.*;
import static com.mycompany.studentresultmanagement.MenuPrinter.*;
import static com.mycompany.studentresultmanagement.StudentOperation.generateReportCard;
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
                    admin.manageEnrollments(data); // MANAGE ENROLLMENTS
                    break;
                    
                case 4:
                    admin.manageGrades(data); // ENTER GRADES
                    break;
                    
                case 5:
                    String studentId = getValidString("Enter Student ID: ");
        
                    Optional<Student> student = data.getStudents().stream()
                            .filter(s -> s.getStudentId().equals(studentId))
                            .findFirst();

                    if (student.isPresent()) {
                        student.get().viewResult();
                        
                    }
                    else {
                        System.out.printf("- Student [%s] not found!\n", studentId);
                    }
                    break;
                    
                case 6:
                    String studentId2 = getValidString("Enter Student ID: ");
        
                    Optional<Student> student2 = data.getStudents().stream()
                            .filter(s -> s.getStudentId().equals(studentId2))
                            .findFirst();

                    if (student2.isPresent()) {
                        generateReportCard(student2.get());
                        
                    }
                    else {
                        System.out.printf("- Student [%s] not found!\n", studentId2);
                    }
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
    
    public static void addSubjectOperation(Data data) {
        
        String subName = getValidString("Enter Subject Name: ");
        String subCode = getValidString("Create Subject code: ");
        int subTotalMarks = getValidInt("Create Total Marks: ", 0, 100);
        
        boolean exists = data.getSubjects().stream()
                .anyMatch(s -> s.getSubjectName().equals(subName) || s.getSubjectCode().equals(subCode));
                
        if (exists) {
            System.out.println("- Subject name or code already exists");
            return;
        }
        
        Subject newSubject = new Subject(subName, subCode, subTotalMarks, 0);
        data.addSubject(newSubject);
        
        
    }
    
    public static void removeSubjectOperation(Data data) {
        
        if (data.getSubjects().isEmpty()) {
            System.out.println("- Insufficient subjects to delete!");
            return;
        }
        String subCode = getValidString("Enter Subject code: ");
        
        Optional<Subject> subject = data.getSubjects().stream()
                .filter(s -> s.getSubjectCode().equals(subCode))
                .findFirst();
        
        if (subject.isPresent()) {
            data.removeSubject(subject.get());
        }
        else {
            System.out.printf("- Subject [%s] not found\n", subCode);
        }   
    }
    
    public static void viewSubjectOperation(Data data) {
        
        if (data.getSubjects().isEmpty()) {
            System.out.println("- Insufficient subjects to display!");
            return;
        }
        
        System.out.println("==============================");
        System.out.println("  CODE     |   NAME ");
        System.out.println("==============================");
        data.getSubjects().stream()
                .forEach(s -> System.out.printf(" %s | %s\n", s.getSubjectCode(), s.getSubjectName()));
    }
    
    public static void enrollStudent(Data data) {
        
        if (data.getSubjects().isEmpty()) {
            System.out.println("- Insufficient subjects to enroll!");
            return;
        }
        else if (data.getStudents().isEmpty()) {
            System.out.println("- Insufficient students to enroll!");
            return;
        }
        
        String studentId = getValidString("Enter Student ID: ");
        String subCode = getValidString("Enter Subject CODE: ");
        
        Optional<Student> student = data.getStudents().stream()
                .filter(std -> std.getStudentId().equals(studentId))
                .findFirst();
        
        if (!student.isPresent()) {
             System.out.printf("- Student [%s] not found!\n", studentId );
             return;
        }
        
        Optional<Subject> subject = data.getSubjects().stream()
                .filter(sub -> sub.getSubjectCode().equals(subCode))
                .findFirst();
                
        if (!subject.isPresent() ) {
             System.out.printf("- Subject [%s] not found!\n", subCode );
             return;
        }
        
        if (!student.get().enrollSubject(subject.get())) {
            printStudentEnrolled();
        }
        
    }
    
    public static void viewEnrollment(Data data) {
        if (data.getSubjects().isEmpty()) {
            System.out.println("- Insufficient subjects to enroll!");
            return;
        }
        else if (data.getStudents().isEmpty()) {
            System.out.println("- Insufficient students to enroll!");
            return;
        }
        
        String studentId = getValidString("Enter Student ID: ");
        
        Optional<Student> student = data.getStudents().stream()
                .filter(std -> std.getStudentId().equals(studentId))
                .findFirst();
        

        if (student.isPresent()) {
            
            System.out.println("==============================");
            System.out.println("  CODE     |   NAME ");
            System.out.println("==============================");
            student.get().getEnrolledSubjects().stream()
                    .forEach(enrollSub -> System.out.printf("%s | %s\n", enrollSub.getSubjectCode(), enrollSub.getSubjectName()));
        }
        else {
            System.out.printf("- Student [%s] not found!\n", studentId);
        }
    }
}
