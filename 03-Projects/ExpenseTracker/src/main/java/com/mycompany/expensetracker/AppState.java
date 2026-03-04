/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */
public class AppState {
    
    private ArrayList<Expense> expenses= new ArrayList<>();
    private ArrayList<Category> category= new ArrayList<>();
    private ArrayList<Wallet> wallet= new ArrayList<>();
    private ArrayList<Transaction> transaction= new ArrayList<>();
    
    public AppState() {
        
    }
   
    
    // Getters and Setters

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }

    public ArrayList<Category> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<Category> category) {
        this.category = category;
    }

    public ArrayList<Wallet> getWallet() {
        return wallet;
    }

    public void setWallet(ArrayList<Wallet> wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(ArrayList<Transaction> transaction) {
        this.transaction = transaction;
    }
    
    
    
}
