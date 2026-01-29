/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab.section2;

/**
 *
 * @author prashnamshrestha
 */
public class LabSection2 {

    public static void main(String[] args) {
        
        // Question 1
        int temp_celsius = 20;
        int temp_Fahrenheit = (temp_celsius * 9/5) + 32;
        
        System.out.println("Celsius: " + temp_celsius);
        System.out.println("Temp_Fahrenheit: " + temp_Fahrenheit);
        
         // Question 2
        Bill momoday = new Bill(1000, 6);
        momoday.calculatebill();
        momoday.addtip(30);
        momoday.calculatebill();
          
        // Question 3
        int seconds = 1000;
        int minutes = seconds/60;
        int hours = minutes/60;
        int day = hours/24;
           
        int x = 10 % 3;
           
        System.out.println("Second: " + seconds + ", Minutes: " 
                   + minutes + " ,Hours: " + hours + " ,Day: " + day);
        
        // Question 4
        final double PI = 3.14159;
        double radius = 7.5;
        double areaCircle = PI*radius;
        System.out.println(areaCircle);
        
        
        
        
               
        
        
        
 
           
                  
          
    }
}
