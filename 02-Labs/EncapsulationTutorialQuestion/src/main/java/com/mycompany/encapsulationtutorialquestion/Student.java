/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.encapsulationtutorialquestion;

/**
 *
 * @author prashnamshrestha
 */
public class Student {
    
    private String studentId;
    private String studentName;
    private int marks;
    
    public Student(String id, String name, int marks) {
        
        setStudentId(id);
        setStudentName(name);
        setMarks(marks);
    }
    
    public String displayStudentDetails() {
        return String.format("Student ID: %s \nStudent Name: %s \nMarks: %s\n", getStudentId(), getStudentName(), getMarks());
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    
}
