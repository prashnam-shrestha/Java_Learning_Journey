/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apexcapitalbank;

import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public class SavingsAccount extends Account{
    private double interestRate;
    
    public SavingsAccount(double balance, double rate) {
        super(balance);
        setInterestRate(rate);
    }
    
    public void performEOM() {
        double balance = getBalance();
        double interestAmt = balance * (interestRate/100);
        setBalance(balance + interestAmt);
        
        Transaction tran = new Transaction(interestAmt, transactionType.INTEREST, this, LocalDate.now());
        addTransaction(tran);
    }
    
    public String getAccInfo() {
        return String.format("  > [SAV] Balance: Rs %s", getBalance());
    }
            

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
}