/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.menudrivenassignment;

import static com.mycompany.menudrivenassignment.inputHelper.*;
import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public class MenuDrivenAssignment {

    public static void main(String[] args) {
        
        DataUser users = new DataUser();
        
        boolean run = true;
        
        while (run) {
            
            displayMenu(); 
            int choice = getValidInt("\nEnter choice:");
                    
            switch(choice) {
                
                case 1: 
                    User userNew = signUpOperation();
                    
                    if (userNew != null) {
                        users.addUser(userNew);
                        System.out.println("You have successfully signed up.");
                        System.out.println(userNew.getUserInfo());
                    }
                    break;
                    
                case 2:
                    
                    run = false;
                    System.out.println("Thank you for using the Application.");
                    break;
                    
                default:
                    System.out.println("Invalid choice! ");
                            
            }
                    
        }
            


    }
    
    public static User signUpOperation() {
        
        // Get name
        System.out.print("\nEnter full name: ");
        String fullName = sc.nextLine();
        
        if (fullName.length() <= 4) {
            System.out.println("Your name must contain atleast 5 letters.\n"
                        + "Please try again.");
            return null;
        }
        
        // Get contact
        System.out.print("\nEnter Contact Number: ");
        String contactNumber = sc.nextLine();

        if (!checkValidContact(contactNumber)) {
            System.out.println("Your contact no. must contain 10 digits starting with 0.\n"
                    + "Please try again.");
            return null;
        }

        // Get password
        System.out.print("\nEnter Password: ");
        String password = sc.nextLine();

        if (!checkValidPassword(password)) {
            
            System.out.println("Your password must contain @ or &. \n"
                    + "Your password must contain atleast 4 letters. \n "
                    + "Your password must start with letter and end with digit. \n"
                    + "Please try again.");
            return null;
        }
        
        // Get confirmation
        System.out.print("\nConfirm your password: ");
        String password2 = sc.nextLine();
                    
        if (!(password.equals(password2))) {
            
            System.out.println("Your passwords do not match.\n" +
                                "Please start again");
            return null;
        }
        

        LocalDate dob = getValidDate("\nEnter date (YYYY-MM-DD): ");


        if (!checkValidAge(dob)) {
            System.out.println("User must be atleast 18 years old..\n" +
                                "Please start again");
            return null;
        }
        
        User u = new User(fullName, contactNumber, dob, password);
        return u;
    }
    
    public static void displayMenu() {
        System.out.println("\n1. Sign up");
        System.out.println("2. Quit Application");
                
    }
}
