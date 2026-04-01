/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.StudentResultManagement.getGradeGpa;
import static com.mycompany.studentresultmanagement.StudentResultManagement.getGradeLetter;

/**
 *
 * @author prashnamshrestha
 */
public class MenuPrinter {
    
    public static void printMainMenu() {
        System.out.println("=========================================");
        System.out.println("   STUDENT RESULT MANAGEMENT SYSTEM");
        System.out.println("=========================================");
        System.out.println("1. Login");
        System.out.println("2. Exit");
    }

    public static void printAdminMenu() {
        System.out.println("=========================================");
        System.out.println("             ADMIN MENU");
        System.out.println("=========================================");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Subjects");
        System.out.println("3. Manage Enrollments");
        System.out.println("4. Enter Grades");
        System.out.println("5. View Results");
        System.out.println("6. Generate Report Card");
        System.out.println("7. Manage Admins");
        System.out.println("8. Save & Logout");
    }

    public static void printStudentMenu() {
        System.out.println("=========================================");
        System.out.println("            STUDENT MENU");
        System.out.println("=========================================");
        System.out.println("1. View My Results");
        System.out.println("2. View My Report Card");
        System.out.println("3. Logout");
    }

    public static void printStudentManagementMenu() {
        System.out.println("=========================================");
        System.out.println("            STUDENT MANAGEMENT");
        System.out.println("=========================================");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. View All Students");
        System.out.println("4. Save & Back");
    }

    public static void printSubjectManagementMenu() {
        System.out.println("=========================================");
        System.out.println("            SUBJECT MANAGEMENT");
        System.out.println("=========================================");
        System.out.println("1. Add Subject");
        System.out.println("2. Remove Subject");
        System.out.println("3. View All Subjects");
        System.out.println("4. Save & Back");
    }

    public static void printEnrollmentMenu() {
        System.out.println("=========================================");
        System.out.println("            ENROLLMENT MANAGEMENT");
        System.out.println("=========================================");
        System.out.println("1. Enroll Student in Subject");
        System.out.println("2. View Enrollments");
        System.out.println("3. Save & Back");
    }

    public static void printAdminManagementMenu() {
        System.out.println("=========================================");
        System.out.println("            ADMIN MANAGEMENT");
        System.out.println("=========================================");
        System.out.println("1. Add Admin");
        System.out.println("2. Remove Admin");
        System.out.println("3. View All Admins");
        System.out.println("4. Save & Back");
    }
    
    public static void printFormatedResult(Student student) {
        
        if (student.getEnrolledSubjects().isEmpty()) {
            System.out.println("- Student has not enrolled in any subject!");
            return;
        }

        StringBuilder result = new StringBuilder(
            String.format(
                "=========================================\n" +
                "              VIEW RESULTS\n" +
                "=========================================\n" + 
                "\n-----------------------------------------\n" +
                "   Results for: %s (%s)\n" +
                "-----------------------------------------\n" + 
                "   Subject              Grade    Letter\n" +
                "-----------------------------------------\n",
                student.getName(), student.getStudentId()
            )
        );


        student.getEnrolledSubjects()
            .forEach(s -> result.append(
                String.format("%-20s %-8d %s\n",
                    s.getSubjectName(),
                    s.getObtainedMarks(),
                    getGradeLetter(s))
            ));

        result.append(String.format("-----------------------------------------\n" +
                                    "GPA : %s / 4.00\n" +
                                    "-----------------------------------------", getGradeGpa(student)));


        System.out.println(result);
    }

}
