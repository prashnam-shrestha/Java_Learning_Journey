/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.expensetracker;

import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class ExpenseTracker {

    public static void main(String[] args) {
        
        User u = new User("Prashnam");
        Wallet wal = new Wallet("Esewa", 1000);
//        
        Category cSalary = new Category("Salary", CashFlowType.INCOME);
        Category cFood = new Category("Food", CashFlowType.EXPENSE);
//        Expense exp = new Expense("Momo", 1000, cFood, wal);
//        Income inc = new Income("Salary", 1000, cSalary, wal);
//        
        u.addCategory(cFood);
        u.addWallet(wal);
//        
//        // Add expense
//        boolean runCode = u.addExpense(exp);
//        
//        if (!runCode) {
//            System.out.println("NO enough balance to add expense");
//        }
//        else {
//            System.out.println("Expense added successfully");;
//        }
//        
//        // Add income
//        u.addIncome(inc);
//        
//        
//        
//        // General info
//        
//        
//        displayMainMenu(u);
//        displayWalletMenu(u);
//        displayCategoryMenu(u);
//        displayCashFlow(u);
        
        // Application 
        boolean run = true;
        while (run) {
            
            displayMainMenu(u);
            int choice = getValidInt("Enter choice: "); 
            switch (choice) {
                
                // Add expenses
                case 1:
                    
                    int categoryCount = displayAvailabeCategory(u);
                    
                    // Add Expenses Confirm
                    if (categoryCount > 0) {
                        
                        addExpenseOperation(u, categoryCount);
                                
                    }
                    else {
                        System.out.println("Not enought Category! Please create them to add Expenses");
                    }
                    break;
                
                // Delete expense 
                case 2:
                    
                    break;
                  
                // Manage Wallet
                case 3:
                    
                    break;
                
                 
                // Manage Category
                case 4:
                    
                    break;
                
                // Report Cashflow
                case 5:
                    
                    break;
                
                    
                case 6:
                    run = false;
                    System.out.println("Exiting the program!");
                    break;
                
                default:
                    System.out.println("Optin not found!");
                            
            }
        }
        
        // Temporary
        for (Expense e : u.getAppState().getExpenses()) {
             System.out.println(e.getCashFlowInfo());
        }
        for (Transaction t : u.getAppState().getTransaction()) {
             System.out.println(t.getDetail());
        }
        for (Wallet w : u.getAppState().getWallet()) {
             System.out.println(w.getDetail());
        }
        
    }
    // Add Expense Confirm
    public static void addExpenseOperation(User u, int categoryCount) {
        
        // Pick category number
        int categoryIndex = getValidInt("Pick a Category (number): ") - 1;
        
        Category category;
        
        // Catch invalid category option to pre return
        try {
            
           category = u.getAppState().getCategory().get(categoryIndex);
           
        }  catch (IndexOutOfBoundsException i) {
            
                System.out.println("Category Not Found");
                return;
        }
        
        // Display available wallets
        int walletCount = displayAvailabeWallet(u);
        
        // Catch no wallet case
        if (walletCount > 0) {
            
            // Pick wallet
            int walletIndex = getValidInt("Pick a Wallet (number): ") - 1;
            Wallet wallet;
            
            // Catch invalid wallet number to pre return
            try {
                
                wallet = u.getAppState().getWallet().get(walletIndex);
                
            } catch (IndexOutOfBoundsException i) {
                
                System.out.println("Wallet not found! ");
                return;
            }
            
            System.out.print("Description: ");
            String name = sc.nextLine();
            
            System.out.print("Expense amount:");
            double amount = getValidInt("Enter amount: ");
             
            Expense exp = new Expense(name, amount, category, wallet);
            // Left off here
            if (u.addExpense(exp)) {
                System.out.printf("Sucessfully added expense %s!\n", exp.getName());
            }
            else {
                System.out.printf("No enough balance in the wallet %s!\n", wallet.getNameWallet());
            }
            
        }
      
        else {
            System.out.println("Not enough Wallet! Please create them to add Expenses");
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
        
        System.out.println("You currently have " + size + " wallets!");
        
        if (size == 0) {
            
            return 0;
        }
        
        
        for (Wallet w: u.getAppState().getWallet()) {
            System.out.println(w.getNameWallet());
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
        
        System.out.println("You currently have " + size + " categories!");
        
        if (size == 0) {
            
            return 0;
        }
        
        
        for (Category c: u.getAppState().getCategory()) {
            System.out.println(c.getNameCategory());
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
