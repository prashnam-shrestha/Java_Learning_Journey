/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem3gemini;

/**
 *
 * @author prashnamshrestha
 */
public class Rectangle {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }
    
    public void getArea() {
        System.out.printf("Area of the rectangle: %s\n", length * width);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    
    
}
