/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem3gemini;

/**
 *
 * @author prashnamshrestha
 */
public class Cat extends Animal {
    
    public Cat(String name) {
        super(name);
    }
    
    public void makeSound() {
        System.out.printf("%s: Meow!!\n", getName());
    }
}
