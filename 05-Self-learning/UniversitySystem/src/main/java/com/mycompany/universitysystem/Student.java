/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universitysystem;

/**
 *
 * @author prashnamshrestha
 */
public class Student extends Person {
    private double gpa;
    
    public Student(String name, int age, double gpa) {
        super(name, age);
        this.gpa = gpa;
    }
    
    public void infoStudent() {

        System.out.printf("Hi I'm %s, and I am %s years old. I am a student\n",getName(), getAge());
    }

}
