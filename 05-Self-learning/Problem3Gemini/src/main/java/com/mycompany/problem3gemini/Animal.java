/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem3gemini;

/**
 *
 * @author prashnamshrestha
 */
public class Animal {
    private String name;
    
    public Animal(String name) {
        setName(name);
    }
    
    public void makeSound() {
        System.out.println("Some sound");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
