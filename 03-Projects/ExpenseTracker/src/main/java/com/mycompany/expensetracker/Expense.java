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
public class Expense extends CashFlow{
    
    private String nameExpense;
    private double amount;
    private LocalDate date;
    private Category category;
    private Wallet wallet;
    
    public Expense(String name, double amount, Category category, Wallet wallet) {
        super(name, amount, category, wallet);
    }
    // General expense info
    public String getCashFlowInfo() {
        String info = String.format("%s  %s  %s  %s  %s", getDate(), getCategory().getNameCategory(), getAmount(), getWallet().getNameWallet(), getName());
        return info;
    }
    
}
