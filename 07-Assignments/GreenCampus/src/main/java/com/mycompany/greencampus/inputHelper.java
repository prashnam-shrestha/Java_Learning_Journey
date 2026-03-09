/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencampus;

import java.time.LocalDate;
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
    
    
    public static String getValidEmail(String text) {
        
        while (true) {
                        
            System.out.print(text);
            String email = sc.nextLine();

            if (email.matches("\\w+@\\w+\\.com")) {
                return email;
            }
            
            System.out.println("Please enter in '@xyz.com' format!");
        }
            
    }
    
    public static boolean checkEmailExists(String email, CampusData data) {
            
        for (User u: data.getUsers()) {
            
            if (u.getEmail().equals(email)) {
               return true;
            }
        }
        return false;
    }
    
    public static String getValidPassword(String text) {
        
        while (true) {
            System.out.print(text);
            String password = sc.nextLine();
            
            int size = password.length();

            for (int i = 0; i < size; i++) {

                if (password.charAt(i) == '@' || password.charAt(i) == '&') {
                    
                    return password;
                }
            }
            
            System.out.println("Please create a stronger password using @ or &"); 
        }
        
    }
    
}
