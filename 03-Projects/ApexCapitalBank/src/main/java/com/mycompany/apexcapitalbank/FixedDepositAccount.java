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
public class FixedDepositAccount extends Account {
    private double interestRate;
    private LocalDate maturity;
    
    public FixedDepositAccount(double balance, double rate, LocalDate maturity) {
        super(balance);
        setInterestRate(rate);
        setMaturity(maturity);
    }
    
    public void performEOM() {
        double balance = getBalance();
        double interestAmt = balance * (interestRate/100);
        setBalance(balance + interestAmt);
        
        Transaction tran = new Transaction(interestAmt, transactionType.INTEREST, this, LocalDate.now());
        addTransaction(tran);
    }
    
    public void deposit(double amount) {
        System.out.println("  [!] Restriction: Deposits are not allowed in Fixed Deposit accounts.");
    }
    
    public void withdraw(double amount) {
        if (isFreeze()) {
            System.out.println("  [!] Alert: Account is Frozen. Operation Failed.");
            return;
        }
        else if (amount < 0) {
            System.out.println("  [!] Error: Invalid amount entered.");
            return;
        }
        
        LocalDate now = LocalDate.now();
        
        if ( getBalance() >= amount &&  (maturity.isBefore(now) || maturity.isEqual(now)) ) {
            
            setBalance(getBalance() - amount);
            Transaction tran2 = new Transaction(amount, transactionType.WITHDRAW, this, LocalDate.now());
            addTransaction(tran2);
        }
        
        else if ((getBalance() >= amount) && ( maturity.isAfter(now) ) ) {

            setInterestRate(getInterestRate() - 1);
            System.out.printf("  [!] Penalty Applied: Interest rate reduced to %s percent due to premature withdrawal.\n", getInterestRate());
            setBalance(getBalance() - amount);
            Transaction tran2 = new Transaction(amount, transactionType.WITHDRAW, this, LocalDate.now());
            addTransaction(tran2);
      
        }
    }
    public String getAccInfo() {
        return String.format("  > [FD]  Balance: Rs %s", getBalance());
    }
    
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getMaturity() {
        return maturity;
    }

    public void setMaturity(LocalDate maturity) {
        this.maturity = maturity;
    }
    
    
    
}