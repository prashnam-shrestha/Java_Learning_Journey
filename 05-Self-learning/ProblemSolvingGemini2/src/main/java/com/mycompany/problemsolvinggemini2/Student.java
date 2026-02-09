/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problemsolvinggemini2;

/**
 *
 * @author prashnamshrestha
 */
public class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        setName(name);
        setGrade(grade);
    }
    
    public void getInfo() {
        System.out.printf("%s | %s \n", getName(), getGrade());
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    
}
