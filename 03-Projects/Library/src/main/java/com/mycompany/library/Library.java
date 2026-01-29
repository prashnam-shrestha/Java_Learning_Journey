/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library;

/**
 *
 * @author prashnamshrestha
 */
public class Library {

    public static void main(String[] args) {
        Book b1 = new Book("Harry Potter"
                , "JK Rowling",Book.Genre.FRICTION);
        
        System.out.println(b1);
        b1.borrowBook("Prashnam");
        b1.borrowBook();
        b1.returnBook();
        b1.borrowBook();
        
        
        
        
        
    }
}
