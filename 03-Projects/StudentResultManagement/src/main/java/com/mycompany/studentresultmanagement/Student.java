/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public class Student extends User implements Serializable{
   
    private String studentId;
    private double gpa;
    private List<Subject> enrolledSubjects;
    
    public Student(String name, String password, String studentId) {
        
        super(name, password);
        setGpa(0.0);
        setEnrolledSubjects(new ArrayList<>());
        setStudentId(studentId);
        
    
    }
    
    public boolean enrollSubject(Subject subject) {
        
        for (Subject s: this.enrolledSubjects) {
            if (s.getSubjectCode().equals(subject.getSubjectCode())) {
                
                // PRINT THAT SUBJECT ALREADY ENROLLED
                return false;
            }
        }
        enrolledSubjects.add(new Subject(subject));
        return true;
    }
    
    public String getResult() {
        return "";
    }
    
    public String getReportCard() {
        return "";
    }

    // GETTERS AND SETTERS

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<Subject> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void setEnrolledSubjects(List<Subject> enrolledSubjects) {
        this.enrolledSubjects = enrolledSubjects;
    }
    
    
}
