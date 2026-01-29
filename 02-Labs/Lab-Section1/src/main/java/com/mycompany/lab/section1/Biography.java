/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab.section1;

/**
 *
 * @author prashnamshrestha
 */
public class Biography {
    String name;
    int age;
    double height;
    boolean student;
    
    public Biography(String name, int age, double height, boolean student) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.student = student;
             
    }
    
    public void info() {
        System.out.println("My name is " + name + ", I am " + age + " years old. I am " + height + "m tall and it is " + student + " that im a student");
    }
    
}
