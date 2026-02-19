/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apexcapitalbank;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */
public class Customer extends appUser {
    
    // Accounts
    private ArrayList<Account> accountsCustomer = new ArrayList<>();
    
    // ------- Constructors --------
    public Customer(String name, String phone, LocalDate dateOfBirth, String password) {
        super(name, phone, dateOfBirth, password);
    }
    
    // ------- Methods --------------
    
    public void getInfoAccounts() {
        
        for (Account a: accountsCustomer) {
            System.out.println(a.getAccInfo());
        }
    }
    
    // Add account
    public void addAccountsCustomer(Account account) {
        this.accountsCustomer.add(account);
    }
    
    // ------- Getters and Setters -----------
    

    public ArrayList<Account> getAccountsCustomer() {
        return accountsCustomer;
    }

    public void setAccountsCustomer(ArrayList<Account> accountsCustomer) {
        this.accountsCustomer = accountsCustomer;
    }
    
    
    
}