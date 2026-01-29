/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab.section3;

/**
 *
 * @author prashnamshrestha
 */
public class LabSection3 {

    public static void main(String[] args) {
        
        // Question 1
        int age = 9;
        boolean voting = false;
        if (age >= 18) {
            voting = true;
        }

        System.out.println("It is " + voting + ", that age " + age + " can vote.");
        
        // Question 2
        int number = 910;
        boolean even = false;
        if (number % 2 == 0) {
            even = true;
        }
        
        System.out.println("It is " + even + ", that " + number + " is even.");
        
        // Question 3
        int grade = 90;
        boolean pass = false;
        if (grade >= 40) {
            pass = true;
        }

        System.out.println("It is " + pass + ", that grade " + grade + " is pass");
        
    }
}
