/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.InputHelper.getValidInt;
import static com.mycompany.studentresultmanagement.MenuPrinter.printStudentMenu;

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
}
