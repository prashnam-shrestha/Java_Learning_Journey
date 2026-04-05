/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.InputHelper.getValidInt;
import static com.mycompany.studentresultmanagement.MenuPrinter.printFormatedResult;
import static com.mycompany.studentresultmanagement.MenuPrinter.printStudentMenu;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author prashnamshrestha
 */
public class StudentOperation {
    
    public static void loggedStudentOperation(Student student) {

            boolean run = true;

            while (run) {
                printStudentMenu();

                int stdChoice = getValidInt("Enter Choice: ", 1, 3);

                switch(stdChoice) {

                    case 1:
                        
                        student.viewResult();
                        break;

                    case 2:
                        printFormatedResult(getFormatedResult(student, true));
                        break;

                    case 3:
                        run = false;
                        break;

                    default:

                }
            }

        }
    
    public static StringBuilder getEnrolledGrades(Student student) {
        StringBuilder result = new StringBuilder();
        
        student.getEnrolledSubjects()
            .forEach(s -> result.append(
                String.format("%-25s %-8d %-6s\n",
                    s.getSubjectName(),
                    s.getObtainedMarks(),
                    getGradeLetter(s))
            ));
        
        return result;
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
    
    public static void generateReportCard(Student student) {
        
         String filePath = String.format("%s_report", student.getStudentId());
         
         try {
            StringBuilder report = getFormatedResult(student, true);
            System.out.println(report);
            FileWriter writer = new FileWriter(filePath);
            writer.write(report.toString());
            writer.close();

            System.out.println(String.format("-----------------------------------------\n" +
                                "   Report saved to: %s\n" +
                                "=========================================", filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static StringBuilder getFormatedResult(Student student, boolean reportCase) {
        
        if (student.getEnrolledSubjects().isEmpty()) {

            return new StringBuilder("- Student has not enrolled in any subject!");
        }
        String resultCase;
        
        if (reportCase) {
            resultCase = "REPORT CARD";
        }
        else {
             resultCase = "VIEW RESULTS";
        }
        
        StringBuilder result = new StringBuilder(
            String.format(
                "=========================================\n" +
                "              %s\n" +
                "=========================================\n\n" +
                "-----------------------------------------\n" +
                "Results for: %s (%s)\n" +
                "-----------------------------------------\n" +
                "%-25s %-8s %-6s\n" +
                "-----------------------------------------\n" +
                "%s",
                resultCase,
                student.getName(),
                student.getStudentId(),
                "Subject", "Grade", "Letter",
                getEnrolledGrades(student)
            )
        );


        result.append(String.format("-----------------------------------------\n" +
                                    "GPA : %s / 4.00\n", student.getGpa()));
        if (reportCase) {
            result.append(getGradeStatus(student.getGpa()));
        }
        result.append("\n-----------------------------------------");
        return result;
    }
    
    public static String getGradeStatus( double gpa) {
        if (gpa >= 2.0) {
            return "Result Status: PASS" ;
        }
        
         return "Result Status: FAIL" ;
    }
    
}
