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
    
    public Income(String name, double amount, Category category, Wallet wallet) {
        super(name, amount, category, wallet);
    }
    // General INcome info
    public String getCashFlowInfo() {
        String info = String.format("[+] Income | %-12s | Rs %.2f | Source: %s", getCategory().getNameCategory(), getAmount(), getName());
        return info;
    }
    
    
    
    
    
}