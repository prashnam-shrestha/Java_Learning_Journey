/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencampus;

/**
 *
 * @author prashnamshrestha
 */
public class MenuPrinter {
    
    public static void displayMainMenu() {
        System.out.println("\nWelcome to Green Campus!");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }
    
    public static void displayNormalUserMenu(NormalUser u) {
        System.out.printf("\nWelcome! %s\n", u.getName());
        System.out.println("1. Log green activity");
        System.out.println("2. View my activity");
        System.out.println("3. Logout");
    }
    
    public static void displayAdminMenu(Admin a) {
        System.out.printf("\nWelcome! %s\n", a.getName());
        System.out.println("1. View all activities");
        System.out.println("2. Generate Report");
        System.out.println("3. Logout");
    }
    
    public static void displayActivityMenu() {
            // 1. Manually print the options
        System.out.println("\n--- Select a Green Activity ---");
        System.out.println("1. Walking or cycling instead of using vehicles");
        System.out.println("2. Saving electricity");
        System.out.println("3. Using reusable materials");
    }
    
}
