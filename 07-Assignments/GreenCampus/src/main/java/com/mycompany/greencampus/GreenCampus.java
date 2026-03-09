/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.greencampus;

import static com.mycompany.greencampus.MenuPrinter.*;
import static com.mycompany.greencampus.inputHelper.*;
import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public class GreenCampus {
    public static CampusData data = new CampusData();

    public static void main(String[] args) {
       

        
        boolean run = true;
        while (run) {
            displayMainMenu();
            int choice = getValidInt("Enter choice: ");
            
            switch (choice) {
                
                case 1:
                    loginOperation();
                    break;
                    
                case 2:
                    registerOperation();
                    break;
                    
                case 3:
                    run = false;
                    System.out.println("Thank you! Bye");
                    break;
                    
                default:
                    System.out.println("Option not found!");
                            
            }
        }
         
    }
    
    public static void loginOperation() {
        System.out.printf("Enter email: ");
        String email =  sc.nextLine();
        
         System.out.printf("Enter password: ");
        String password = sc.nextLine();
        
        for (NormalUser u: data.getNormalUsers()) {
            
            if (u.getEmail().equals(email) & u.getPassword().equals(password)) {
                    
                u.displayRole();
                normalUserLogged(u);

            }    
        }
        for (Admin u: data.getAdmins()) {
            
            if (u.getEmail().equals(email) & u.getPassword().equals(password)) {
                
                u.displayRole();
                adminLogged(u);
            }    
        }
        
        System.out.println("Email or Password Not matched!");
    }
    
    public static void registerOperation() {
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        if (name.length() == 0) {
            System.out.println("Name cannot be empty!");
            return;
        }
        
        String email = getValidEmail("Enter email: ");
        if (checkEmailExists(email, data)) {
            System.out.println("Email already registerd!");
            return;
        }
        
        LocalDate dateOfBirth = getValidDate("Enter date: ");
        String password = getValidPassword("Create Password: ");
        
        while (true) {
            System.out.println("--- Select Role ---");
            System.out.println("1. Normal User");
            System.out.println("2. Admin");
            int choice = getValidInt("Enter your choice: ");

            if (choice == 1) {
                NormalUser newNormalUser = new NormalUser(name, email, dateOfBirth, password, 0);
                data.addNormalUser(newNormalUser);
                return;
            }
            else if (choice == 2) {
                Admin newAdmin= new Admin(name, email, dateOfBirth, password);
                data.addAdmins(newAdmin);
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
                    
                case 2:
                        u.viewMyActivity();
                    break;
                    
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
                
                // view all activity
                case 1:
                        a.viewAllActivity(data);
                        
                    break;
                    
                case 2:
                        a.generateReport(data);
                    break;
                    
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
            case 1:
                GreenActivity act = new GreenActivity("Walking or cycling", u, ActivityType.WalkingorCycling);
                u.logActivityUser(act);
                break;
                
            case 2:
                GreenActivity act2 = new GreenActivity("Saving electricity", u, ActivityType.Savingelectricity);
                u.logActivityUser(act2);
                break;
                
            case 3:
                GreenActivity act3 = new GreenActivity("Using reusable materials", u, ActivityType.UsingReusableMaterials);
                u.logActivityUser(act3);
                break;
                
            default:
                System.out.println("Activity not found!");
                return;
            
        }
        System.out.println("Sucessflly log activity! Next time");
    }
}
