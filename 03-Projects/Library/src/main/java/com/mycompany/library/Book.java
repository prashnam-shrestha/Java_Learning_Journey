/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

/**
 *
 * @author prashnamshrestha
 */
public class Book {
    private String title;
    private String author;
    private Genre genre;
    private boolean isBorrowed = false;
    
    // Constructors 
    public Book(String title, String author, Genre genre) {
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        
    }
        
    // Enum for dropdown list
    public enum Genre {
    FRICTION, HISTORY, SCIFI, SELFHELP;
    }
   

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
    
    // Method to borrow book
    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("You successfully borrowed " + getTitle());
            return;
        }
        System.out.println("Sorry, " + getTitle() + " is already borrowed.");
    }
    // Method overloading
    public void borrowBook(String name) {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.printf("%s successfully borrowed %s.\n", name, getTitle());
            return;
        }
        System.out.printf("Sorry %s, %s is already borrowed.\n", name, getTitle());
    }
    // Method to return book
    public void returnBook() {
        if (isBorrowed) {
            System.out.println("You successfully returned " + getTitle());
            setIsBorrowed(false);
            return;
        }
        System.out.println("Sorry, " + getTitle() + " is already returned.");
    }

    /**
     *
     * @return
     */
    @Override
    
    public String toString() {
        String info =  String.format("Title: %s | Author: %s | Genre: %s "
                + "| Available: %s", getTitle(), getAuthor(), getGenre(), !isIsBorrowed());
        return info;
    }
    
    
    
}
