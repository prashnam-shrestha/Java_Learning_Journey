/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menudrivenassignment;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class inputHelper {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static int getValidInt(String text) {
        while (true) {
            try {
                System.out.print(text);
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            }
            catch (Exception e) {
                System.out.println("Please enter a number!");
                sc.nextLine();
            }
        }
    }
    
    public static LocalDate getValidDate(String text) {
        while (true) {
            try {
                System.out.print(text);
                
                String input = sc.nextLine();
                LocalDate date = LocalDate.parse(input);

                return date;
            }
            catch (Exception e) {
                System.out.println("Please enter a in (YYYY-MM-DD) format!");
            }
        }
    }
    
    public static boolean checkValidAge(LocalDate dob) {
        
        LocalDate today = LocalDate.now();
        int age = Period.between(dob, today).getYears();
        
        return age >= 21;
    }
    
    public static boolean checkValidContact(String numString) {
        int size = numString.length();
        // Check 0
        if (numString.charAt(0) != '0' ) {
            return false;
        }
        // Check Length
        if (size != 10) {
            return false;
        }
        // Check its only digits
        for (int i = 0; i < size; i++) {
            if (!Character.isDigit(numString.charAt(i))) {
                return false;
            }     
        }
            
        return true;
    }
    
    public static boolean checkValidPassword(String password) {
        int size = password.length();
        
        if (!Character.isAlphabetic(password.charAt(0))) {
            return false;
        }
        
        if (!Character.isDigit(password.charAt(size - 1))) {
            return false;
        }
        
        boolean finalCheck = false;
        for (int i = 0; i < size; i++) {
            
            if (password.charAt(i) == '@' || password.charAt(i) == '&') {
                finalCheck = true;
                break;
            }
        }
        
        return finalCheck;
    }
    
}
