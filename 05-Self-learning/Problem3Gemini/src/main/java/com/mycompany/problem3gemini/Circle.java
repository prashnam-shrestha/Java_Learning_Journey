/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem3gemini;

/**
 *
 * @author prashnamshrestha
 */
public class Circle {
    private double radius;
    
    public Circle(double radius) {
        setRadius(radius);
    }
    
    public void getArea() {
        System.out.printf("Area of the circle: %s\n", 3.14* radius * radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
    
}
