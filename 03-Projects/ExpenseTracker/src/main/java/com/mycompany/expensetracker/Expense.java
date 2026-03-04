/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public class Expense {
    
    private String nameExpense;
    private double amount;
    private LocalDate date;
    private Category category;
    
    public Expense(String name, double amount, Category category) {
        
        setNameExpense(name);
        setAmount(amount);
        setDate(LocalDate.now());
        setCategory(category);
    }
    
    // Getters and Setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNameExpense() {
        return nameExpense;
    }

    public void setNameExpense(String nameExpense) {
        this.nameExpense = nameExpense;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    
    
}
