/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.problem3gemini;

import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */
public class Problem3Gemini {

    public static void main(String[] args) {
        // Qn 7
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Some name"));
        animals.add(new Cat("Cisu"));
        animals.add(new Dog("Lucy"));
        animals.add(new Dog("Kayra"));
        
        for(Animal a: animals) {
            a.makeSound();
        }
        
        // Qn 7
        Circle ball = new Circle(9);
        Rectangle keyboard = new Rectangle(30, 10);
        
        ball.getArea();
        keyboard.getArea();
    }
}
