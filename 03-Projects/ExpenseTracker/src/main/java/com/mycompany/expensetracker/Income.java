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
public class Income extends CashFlow{
    private String nameIncome;
    private double amount;
    private LocalDate date;
    private Category category;
    private Wallet wallet;
    
    public Income(String name, double amount, Category category, Wallet wallet) {
        super(name, amount, category, wallet);
    }
    // General INcome info
    public String getCashFlowInfo() {
        String info = getCategory().getNameCategory() + " INcome of Rs " + getAmount() + " for " + getName();
        return info;
    }
    
    
    
    
    
}
