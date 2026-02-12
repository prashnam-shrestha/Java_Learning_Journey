/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem;

import static com.mycompany.librarymanagementsystem.LibraryBlock.getNewID;
import static com.mycompany.librarymanagementsystem.LibraryBlock.setNextID;

/**
 *
 * @author prashnamshrestha
 */
public abstract class LibraryItem {
    
    private String title;
    private int ID;
    private Type type;
    private Status status = Status.AVAILABLE;
    
    public LibraryItem(Type type, String title) {

        setTitle(title);
        setID(getNewID());
        setType(type);
                
    }
    
    public void checkedOut() {
        
        if (getStatus() == Status.AVAILABLE) {
            System.out.println("  ----------------------------------------");
            System.out.printf("  >> Item Checked Out Successfully!\n  >> ID: %s | Title: %s \n", getID(), getTitle());
            System.out.println("  ----------------------------------------\n");
            setStatus(Status.BORROWED);
        }
        else {
            System.out.println("\n  [!] Sorry, item is already checked out!\n");
        }
    }
     
    public void submitBack() {
        if (getStatus() == Status.BORROWED) {
            System.out.println("  ----------------------------------------");
            System.out.printf("  >> Item Returned Successfully!\n  >> ID: %s | Title: %s \n", getID(), getTitle());
            System.out.println("  ----------------------------------------\n");
            setStatus(Status.AVAILABLE);
        }
        else {
            System.out.println("\n  [!] Error: Item failed to return (It was not borrowed).\n");
        }
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
        setNextID(ID);
    }
    
}