/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */
public class LibraryBlock {
    public LibraryBlock() {
        
    }
    
    // Id generated everytime new Library item is created.
    public static int idGenerated = 10000;

    public static int getNewID() {
        return idGenerated;
    }

    public static void setNextID(int id) {
        LibraryBlock.idGenerated = id + 1;
    }
    
    // Creating stacks to keep items
    static ArrayList<LibraryItem> Stacks = new ArrayList<>();
    
    public void addLibraryItem(LibraryItem item) {
        Stacks.add(item);
    }
    
    public void addLibraryItem(LibraryItem item, int howMany) {
        
        Stacks.add(item);
        // Creating and adding the copies;
        if (item instanceof Book)  {
            
            for (int i = 1; i < howMany; i++) {
               Book copy = new Book(((Book) item).getTitle(), ((Book) item).getAuthor());
               Stacks.add(copy);
            }
        }
        else if (item instanceof Dvd) {
            
            for (int i = 1; i < howMany; i++) {
               Dvd copy = new Dvd(((Dvd) item).getTitle(), ((Dvd) item).getCreator(), ((Dvd) item).getDurationMin());
               Stacks.add(copy);
            }
        }
        
    }
    
    // Check inventory of library block
    
    public void checkStack() {
        
        int itemsBorrowed = 0;
        int itemsAvailable = 0;
        int itemsCount = Stacks.size();
        
        if (itemsCount == 0) {
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("                   NO ITEMS IN LIBRARY                       ");
            System.out.println("-------------------------------------------------------------\n");
            return;
        }
        
        System.out.println("\n===============================================================================================");
        System.out.println("                                   LIBRARY INVENTORY                                           ");
        System.out.println("===============================================================================================");
        // Added a header row for clarity
        System.out.printf("| %-15s | %-8s | %-12s | %-40s |\n", "TYPE", "ID", "STATUS", "TITLE");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (LibraryItem l: Stacks) {
            
            Status status = l.getStatus();
            // Changed %s to %-15s etc to create fixed column widths
            System.out.printf("| %-15s | %-8s | %-12s | %-40s |\n", l.getType(), l.getID(), status, l.getTitle());
            
            switch (status) {
                case Status.AVAILABLE:
                    itemsAvailable++;
                    break;
                case Status.BORROWED:
                    itemsBorrowed++;
                    break;
                default: break;
            }

        }
        System.out.println("===============================================================================================");
        System.out.printf(" TOTAL ITEMS: %-5s | AVAILABLE: %-5s | BORROWED: %-5s \n", itemsCount, itemsAvailable, itemsBorrowed);
        System.out.println("===============================================================================================\n");
    }
    
}