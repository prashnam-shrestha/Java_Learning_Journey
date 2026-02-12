/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagementsystem;

import static com.mycompany.librarymanagementsystem.LibraryBlock.Stacks;
import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class LibraryManagementSystem {

    public static void main(String[] args) {

        LibraryBlock block1 = new LibraryBlock();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        do {
            
            // Print menu
            printMainMenu();
            int choiceMenu;
            choiceMenu = sc.nextInt();
            sc.nextLine();
            
            switch (choiceMenu) {
                // Add item
                case 1:
                    addItem(block1);
                    break;
                    
                // Checkout
                case 2:
                    checkOut(block1);
                    break;
                    
                // Return
                case 3:
                    submitBack(block1);
                    break;
                    
                    
                // View stack
                case 5:
                    block1.checkStack();
                    break;
                    
                case 6:
                    System.out.println("\nExiting System... Thank you!\n");
                    exit = true;
                    break;
                            
                default:
                    System.out.println("\n[!] Error: Option menu not found. Please try again.\n");
   
            }
            
        }
        while (!exit);
  
        
    }
    // Main menu options pringing
    public static void printMainMenu() {
        
        System.out.println("========================================");
        System.out.println("      LIBRARY MANAGEMENT SYSTEM         ");
        System.out.println("========================================");
        System.out.println("  1. Add Item");
        System.out.println("  2. Checkout Item");
        System.out.println("  3. Return Item");
        System.out.println("  4. Delete Item");
        System.out.println("  5. View Stack");
        System.out.println("  6. Exit");
        System.out.println("----------------------------------------");
        System.out.print("  Enter your choice: ");

    } 
    
    // Type menu printing
    public static void printTypeMenu() {
        Type[] options = Type.values();
        
        int length = options.length;
        
        System.out.println("\n  --- Select Item Type --- ");
        for (int i = 0; i < length; i++) {
            System.out.printf("  %d. %s\n", i + 1, options[i]);
        }
        System.out.println("  ------------------------");
        System.out.print("  Enter your choice: ");
    }
    
    public static void addItem(LibraryBlock block1) {
        Scanner sc = new Scanner(System.in);
        printTypeMenu();
        int choiceTypeMenu;
        choiceTypeMenu = sc.nextInt();
        sc.nextLine();
        
        System.out.print("  Title: ");
        String title = sc.nextLine();
        
        switch(choiceTypeMenu) {
            // Book
            case 1: 
                
                System.out.print("  Author: ");
                String authorBook = sc.nextLine();
                
                System.out.print("  How many copies: ");
                int howManyBook = sc.nextInt();
                sc.nextLine();
                
                Book book1 = new Book(title , authorBook);
                block1.addLibraryItem(book1, howManyBook);
                break;
                
            // Dvd
            case 2:
                
                System.out.print("  Creator: ");
                String creatorDvd = sc.nextLine();
                
                System.out.print("  Duration (mins): ");
                int DurationDvd = sc.nextInt();
                sc.nextLine();

                System.out.print("  How many copies: ");
                int howManyDvd = sc.nextInt();
                sc.nextLine();
                
                Dvd Dvd1 = new Dvd(title, creatorDvd, DurationDvd);
                block1.addLibraryItem(Dvd1, howManyDvd);
                break;
                
            default:
                System.out.println("\n  [!] Error: Option type not found!");
            
        }
        
        System.out.println("\n  >> Success: Item added to library!\n");
    }
    
    public static void checkOut(LibraryBlock block1) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n  Enter item ID to Checkout: ");
        int searchId = sc.nextInt();

        for (LibraryItem l: Stacks) {
            if (searchId == l.getID()) {
                l.checkedOut();
                return;
            }
        }
        System.out.printf("\n  [!] Error: Search ID %s not found!\n\n", searchId);
    }
    
    public static void submitBack(LibraryBlock block1) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n  Enter item ID to Return: ");
        int searchId = sc.nextInt();

        for (LibraryItem l: Stacks) {
            if (searchId == l.getID()) {
                l.submitBack();
                return;
            }
        }
        System.out.printf("\n  [!] Error: Search ID %s not found!\n\n", searchId);
    }
    
    
}