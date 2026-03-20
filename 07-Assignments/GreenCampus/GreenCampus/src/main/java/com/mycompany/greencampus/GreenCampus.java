/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.greencampus;

import static com.mycompany.greencampus.MenuPrinter.*;
import static com.mycompany.greencampus.InputHelper.*;

/**
 *
 * @author prashnamshrestha
 */
public class GreenCampus {
    public static CampusData data = new CampusData();


    public static void main(String[] args) {
        
        // Defaut Admin and Normal User for testing
        NormalUser user = new NormalUser("student", "student@gmail.com", "password@123", 0);
        data.addNormalUser(user);
        
        Admin user2 = new Admin("admin", "admin@gmail.com", "password@123");
        data.addAdmins(user2);
        
        // Main running loop
        boolean run = true;
        while (run) {
            
            displayMainMenu();
            int choice = getValidInt("Enter choice: ");
            
            switch (choice) {
                
                // Login users
                case 1:
                    loginOperation();
                    break;
                  
                // Register new users
                case 2:
                    registerOperation();
                    break;
                    
                // Exit the program
                case 3:
                    run = false;
                    System.out.println("Thank you! Bye");
                    break;
                    
                default:
                    System.out.println("Option not found!");
                            
            }
        }
         
        sc.close();
    }
    
    // Login operation for either user or admin
    public static void loginOperation() {
        
        // Get details
        System.out.printf("Enter email: ");
        String email =  sc.nextLine();
        
         System.out.printf("Enter password: ");
        String password = sc.nextLine();
        
        for (User u: data.getUsers()) { // Loop through all normal users
            
            // Login if passowrd and email matches..
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                    
                u.displayRole();
                
                // Login as normal user
                if (u instanceof NormalUser) {
                    normalUserLogged((NormalUser) u);
                    return;
                } 
                // Login as admin
                else {
                    adminLogged((Admin) u);
                    return;
                }   

            }   
        }
        System.out.println("Email or Password Not matched!");
        
    }
    
    // Register operation for either user or admin
    public static void registerOperation() {
        
        // Ask for details
        System.out.print("Enter name: ");
        
        String name = sc.nextLine();
        if (name.length() == 0) {
            System.out.println("Name cannot be empty!");
            return;
        }
        
        String email = getValidEmail("Enter email: ");
        String password = getValidPassword("Create Password: ");
        
        // Loop until user selects a role
        while (true) {
            
            System.out.println("--- Select Role ---");
            System.out.println("1. Normal User");
            System.out.println("2. Admin");
            int choice = getValidInt("Enter your choice: ");

            if (choice == 1) {
                
                NormalUser newNormalUser = new NormalUser(name, email, password, 0);
                data.addNormalUser(newNormalUser);
                System.out.println("Successfully registered as student!");
                System.out.println("Your User ID: " + newNormalUser.getUniqueId());
                return;
            }
            else if (choice == 2) {
                
                Admin newAdmin= new Admin(name, email, password);
                data.addAdmins(newAdmin);
                System.out.println("Successfully registered as admin!");
                System.out.println("Your Admin ID: " + newAdmin.getUniqueId());
                return;
            }   
             System.out.println("Option not found!");  
        }     
        
                
    }
    
    
    public static void normalUserLogged(NormalUser u) {
        boolean run = true;
        while (run) {
            
            displayNormalUserMenu(u);
            
            int choice = getValidInt("Enter choice: ");
            
            switch(choice) {
                
                // Log activity
                case 1:
                        logGreenActivity(u);
                    break;
                
                // View my activities
                case 2:
                        u.viewMyActivity();
                    break;
                  
                // Back to main menu
                case 3:
                    run = false;
                    break;
                    
                default:
                    System.out.println("Option not found!");


            }
        }       
    }
    
    public static void adminLogged(Admin a) {
        boolean run = true;
        while (run) {
            
            displayAdminMenu(a);
            
            int choice = getValidInt("Enter choice: ");
            
            switch(choice) {
                
                // View all campus activities
                case 1:
                        a.viewAllActivity(data);
                    break;
                 
                // Generate campus report
                case 2:
                        a.generateReport(data);
                    break;
                    
                    
                // Exit to main menu
                case 3:
                    run = false;
                    break;
                    
                default:
                    System.out.println("Option not found!");


            }
        }       
    }
    
    public static void logGreenActivity(NormalUser u) {
        displayActivityMenu();
        
        int choice = getValidInt("Enter your choice (1-3): ");
        
        switch(choice) {
            
            // Walking case
            case 1:
                GreenActivity act = new GreenActivity("Walking or cycling", u, ActivityType.WalkingorCycling);
                u.logActivityUser(act);
                break;
              
            // Saving case
            case 2:
                GreenActivity act2 = new GreenActivity("Saving electricity", u, ActivityType.Savingelectricity);
                u.logActivityUser(act2);
                break;
            
                
            // Reuse case
            case 3:
                GreenActivity act3 = new GreenActivity("Using reusable materials", u, ActivityType.UsingReusableMaterials);
                u.logActivityUser(act3);
                break;
            
            default:
                System.out.println("Activity not found!");
                return;
            
        }
        System.out.println("Successfully log activity! Next time...");
    }
}
