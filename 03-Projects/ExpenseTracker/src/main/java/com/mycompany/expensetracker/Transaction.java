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
    
    public CashFlow incomeOrExpense;
    public double currentBalance;
    
    public Transaction(CashFlow incomeOrExpense) {
        setIncomeOrExpense(incomeOrExpense);
        
        currentBalance = incomeOrExpense.getWallet().getBalance();
        
    }
    
    public String getDetail() {
        
        String detail = String.format(
                "Transaction: %s | Rs %.2f | Date: %s | Wallet: %s | Balance: Rs %.2f",
                incomeOrExpense.getCategory().getNameCategory(),
                incomeOrExpense.getAmount(),
                incomeOrExpense.getDate(),
                incomeOrExpense.getWallet().getNameWallet(),
                currentBalance
        );
        
        return detail;
    }
    
    // Getters and Setters

    public CashFlow getIncomeOrExpense() {
        return incomeOrExpense;
    }

    public void setIncomeOrExpense(CashFlow incomeOrExpense) {
        this.incomeOrExpense = incomeOrExpense;
    }

    
    
    
}
