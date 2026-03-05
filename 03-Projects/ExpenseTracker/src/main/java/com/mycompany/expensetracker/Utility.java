/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class Utility {
    
    // Delete expense Operation
    public static void deleteExpenseOperation(User u, int expenseCount) {
        displayExpenses(u);
        
        int expenseIndex = getValidInt(String.format("Enter expense ID (1 - %s): ", expenseCount)) - 1;
        
        try {
            
            Expense expenseDelete = u.getAppState().getExpenses().get(expenseIndex);
            
            double amount = expenseDelete.getAmount();
            Wallet wallet = expenseDelete.getWallet();
            
            // Remove transaction
            for (Transaction t: u.getAppState().getTransaction()){
                
                if (t.getIncomeOrExpense().getCashFlowInfo().equals(expenseDelete.getCashFlowInfo())) {
                    
                    u.deleteTransaction(t);
                    System.out.println("temp: Removed transaction");
                    break;
                }
            }
            // Deposit the amount back
            wallet.setBalance(wallet.getBalance() + amount);
            
            // Remove expense
            u.deleteExpense(expenseDelete);
            
        }
        catch (IndexOutOfBoundsException i) {
            System.out.printf("Expense ID %s not found!\n", expenseIndex + 1);
        }
        
    }
    
    // Add Expense Operation
    public static void addExpenseOperation(User u, int categoryCount) {
        
        // Pick category number
        int categoryIndex = getValidInt(String.format("Pick a Category (1 - %s): ", categoryCount)) - 1;
        
        Category category;
        
        // Catch invalid category option to pre return
        try {
            
           category = u.getAppState().getCategory().get(categoryIndex);
           
        }  catch (IndexOutOfBoundsException i) {
            
                System.out.println("Category option not found!");
                return;
        }
        
        // Get expense details from user
        
        System.out.print("Description expense: ");
        String name = sc.nextLine();
            
        double amount = getValidInt("Enter amount: ");
        
        // Display available wallets
        int walletCount = displayAvailabeWallet(u);
        
        // Catch no wallet case
        if (walletCount > 0) {
            
            // Pick wallet
            int walletIndex = getValidInt(String.format("Pick a Wallet (1 - %s): ", categoryCount)) - 1;
            Wallet wallet;
            
            // Catch invalid wallet number to pre return
            try {
                
                wallet = u.getAppState().getWallet().get(walletIndex);
                
            } catch (IndexOutOfBoundsException i) {
                
                System.out.println("Wallet not found! ");
                return;
            }
             
            Expense exp = new Expense(name, amount, category, wallet);
            
            // Adding expense
            if (u.addExpense(exp)) {
                
                System.out.printf("Sucessfully added expense %s!\n", exp.getName());
            }
            else {
                // Exit if not enough balance
                System.out.printf("No enough balance in the wallet %s!\n", wallet.getNameWallet());
            }
            
        }
      
        else {
            System.out.println("Not enough Wallet! Please create them to add Expenses");
        }
                
    }
    // Display Expenses ALL 
    public static void displayExpenses(User u) {
        
        int num = 1;
        System.out.println("ID    Date         Category         Amount       Wallet      Description");
        
        for (Expense e: u.getAppState().getExpenses()) {
            System.out.printf(" %s   %s\n", num, e.getCashFlowInfo());
            num++;
        }
       
    }
            
    
    // Display main menu
    public static void displayMainMenu(User u) {
        System.out.println("Welcome To Expense Tracker, " + u.getName());
        System.out.println("1. Add Expense");
        System.out.println("2. Delete Expense");
        System.out.println("3. Manage Wallet"); //
        System.out.println("4. Manage Category"); //
        System.out.println("5. Report Cashflow");
        System.out.println("6. Exit Program");
    }
    
    // Display Manage Wallet
    public static void displayWalletMenu(User u) {
        
        displayAvailabeWallet(u);
        
        System.out.println();
        System.out.println("1. Add Wallet");
        System.out.println("2. Delete Wallet");
        System.out.println("3. Deposit Balance"); // Add income
        System.out.println("4. Withdraw Balance"); 
        System.out.println("5. Show Transactions");
        System.out.println("6. Exit To Main Menu");
    }
    
    // Display Available Wallets
    public static int displayAvailabeWallet(User u) {
        
        int size = u.getAppState().getWallet().size();
        
        if (size == 0) {
            
            return 0;
        }
        
        int num = 1;
        
        System.out.println("ID      Wallet       Balance");
        for (Wallet w: u.getAppState().getWallet()) {
            System.out.printf("%s.      %s        Rs %s\n",num, w.getNameWallet(), w.getBalance());
            num++;
        }
        
        return size;
    }
    
    
    // Display Manage Category
    public static void displayCategoryMenu(User u) {
        
        displayAvailabeCategory(u);
        
        System.out.println();
        System.out.println("1. Add Category");
        System.out.println("2. Delete Category");
        System.out.println("3. Show my Categories");
        System.out.println("4. Exit To Main Menu");
    }
    
    // Display Available Categories
    public static int displayAvailabeCategory(User u) {
        int size = u.getAppState().getCategory().size();
        
        if (size == 0) {
            
            return 0;
        }
        
        int num = 1;
        System.out.println("ID     Category");
        
        for (Category c: u.getAppState().getCategory()) {
            
            System.out.printf("%s      %s\n", num, c.getNameCategory());
            num++;
            
        }
        
        return size;
    }
          
    
    // Show Expenses 
    public static void displayCashFlow(User u) {
        
        System.out.println("============== Expenses ============");
        System.out.println("Expense count: " + u.getAppState().getExpenses().size());
        double totalExpenses = 0;
        
        for (Expense e : u.getAppState().getExpenses()) {
             System.out.println(e.getCashFlowInfo());
             totalExpenses += e.getAmount();
        }
        
        System.out.println("============== Incomes ============");
        System.out.println("Incomes count: " + u.getAppState().getExpenses().size());
        double totalIncome = 0;
        
        for (Income i : u.getAppState().getIncomes()) {
             System.out.println(i.getCashFlowInfo());
             totalIncome += i.getAmount();
        }
        
        System.out.printf("Total Expenses Amount: %s\n", totalExpenses);
        System.out.printf("Total Income Amount: %s\n", totalIncome);
        System.out.printf("Remaining amount: %s\n", totalIncome - totalExpenses);
        
    }
    
    // Scanner
    public static Scanner sc = new Scanner(System.in);
    
    // Get valid input
    public static int getValidInt(String text) {
        while (true) {
            try {
                System.out.print(text);
                int input = sc.nextInt();
                
                sc.nextLine();
                return input;
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }
    
}
