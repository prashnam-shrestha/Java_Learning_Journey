/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

/**
 *
 * @author prashnamshrestha
 */
public class Transaction {
    
    public Expense expense;
    
    public Transaction(Expense expense) {
        setExpense(expense);
    }
    
    public String getDetail() {
        String detail = "Transaction of " + expense.getCategory().getNameCategory() + " Rs " + expense.getAmount() + " on " + expense.getDate();
        return detail;
    }
    
    // Getters and Setters

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
    
    
}
