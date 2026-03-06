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
    
    // Manage wallet operation
    public static boolean manageWalletOperation(User u) {
        
        // Display Wallet and Options
        displayWalletMenu(u);
        
        int choice = getValidInt("  ➤ Enter choice: ");
        switch (choice) {
            
            // Add Wallet
            case 1:
                
                handleAddWallet(u);
                break;
             
            // Delete Wallet
            case 2:
                
                handleDelete(u);
                break;
            
            // Deposit
            case 3:
                
                handleDeposit(u);
                break;
            
            // Withdraw cash
            case 4:
                handleWithdraw(u);
                break; 
                
            // Show transaction
            case 5:
                showTransaction(u);
                break;
            
            // Exit
            case 6:
                return false;
                
            default:
                System.out.println("\n  [x] Option not found! Please try again.");
                
        } 
        return true;
    }
    
    // Delete expense Operation
    public static void deleteExpenseOperation(User u, int expenseCount) {
        
        displayExpenses(u);
        
        int expenseIndex = getValidInt(String.format("\n  ➤ Enter expense ID (1 - %s): ", expenseCount)) - 1;
        
        try {
            
            Expense expenseDelete = u.getAppState().getExpenses().get(expenseIndex);
            
            double amount = expenseDelete.getAmount();
            Wallet wallet = expenseDelete.getWallet();
            
            // Remove transaction
            for (Transaction t: u.getAppState().getTransaction()){
                
                if (t.getIncomeOrExpense().getCashFlowInfo().equals(expenseDelete.getCashFlowInfo())) {
                    
                    u.deleteTransaction(t);
                    System.out.println("  [i] Temp: Removed transaction");
                    break;
                }
            }
            // Deposit the amount back
            wallet.setBalance(wallet.getBalance() + amount);
            
            // Remove expense
            u.deleteExpense(expenseDelete);
            System.out.println("  [✓] Expense deleted successfully.");
            
        }
        catch (IndexOutOfBoundsException i) {
            System.out.printf("\n  [x] Expense ID %s not found!\n", expenseIndex + 1);
        }
        
    }
    
    // Add Expense Operation
    public static void addExpenseOperation(User u, int categoryCount) {
        
        Category category = getCategorySpecific(u);
        if (category == null) {
            return;
        }
        
        // Get expense details from user
        
        System.out.print("  ✎ Description of expense: ");
        String name = sc.nextLine();
            
        double amount = getValidInt("  💲 Enter amount (Rs): ");
        
        // Display available wallets
        int walletCount = displayAvailabeWallet(u);
        
        // Catch no wallet case
        if (walletCount > 0) {
            
            Wallet wallet = getWalletSpecific(u);
            
            if (wallet == null) {
                return;
            }
             
            Expense exp = new Expense(name, amount, category, wallet);
            
            // Adding expense
            if (u.addExpense(exp)) {
                
                System.out.printf("\n  [✓] Successfully added expense: %s!\n", exp.getName());
            }
            else {
                // Exit if not enough balance
                System.out.printf("\n  [x] Not enough balance in the wallet: %s!\n", wallet.getNameWallet());
            }
        }
       
        else {
            System.out.println("\n  [!] Not enough Wallets! Please create them to add Expenses.");
        }
                
    }
    // Display Expenses ALL 
    public static void displayExpenses(User u) {
        
        int num = 1;
        System.out.println("\n──────────────────────────────────────── EXPENSES ────────────────────────────────────────");
        System.out.printf(" %-4s | %-12s | %-12s | %-11s | %-12s | %s\n", "ID", "Date", "Category", "Amount", "Wallet", "Description");
        System.out.println("──────┼──────────────┼──────────────┼─────────────┼──────────────┼──────────────");
        
        for (Expense e: u.getAppState().getExpenses()) {
            System.out.printf(" %-4s | %s\n", num + ".", e.getCashFlowInfo());
            num++;
        }
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────");
       
    }
            
    
    // Display main menu
    public static void displayMainMenu(User u) {
        System.out.println("\n=======================================================");
        System.out.println("                 💳 EXPENSE TRACKER                      ");
        System.out.println("=======================================================");
        System.out.println(" Welcome back, " + u.getName() + "!");
        System.out.println("-------------------------------------------------------");
        System.out.println("  1. ➕ Add Expense");
        System.out.println("  2. ❌ Delete Expense");
        System.out.println("  3. 💼 Manage Wallet"); //
        System.out.println("  4. 📂 Manage Category"); //
        System.out.println("  5. 📊 Report Cashflow");
        System.out.println("  6. 🚪 Exit Program");
        System.out.println("=======================================================");
    }
    
    // Display Manage Wallet
    public static void displayWalletMenu(User u) {
        
        displayAvailabeWallet(u);
        
        System.out.println("\n--- 💼 Manage Wallets ---");
        System.out.println("  1. Add Wallet");
        System.out.println("  2. Delete Wallet");
        System.out.println("  3. Deposit Balance"); // Add income
        System.out.println("  4. Withdraw Cash"); 
        System.out.println("  5. Show Transactions");
        System.out.println("  6. Exit To Main Menu");
        System.out.println("-------------------------");
    }
    
    // Display Available Wallets
    public static int displayAvailabeWallet(User u) {
        
        int size = u.getAppState().getWallet().size();
        
        if (size == 0) {
            return 0;
        }
        
        int num = 1;
        
        System.out.println("\n================ AVAILABLE WALLETS ================");
        System.out.printf(" %-4s | %-15s | %s\n", "ID", "Wallet", "Balance");
        System.out.println("──────┼─────────────────┼────────────────────────");
        for (Wallet w: u.getAppState().getWallet()) {
            System.out.printf(" %-4s | %-15s | Rs %.2f\n", num + ".", w.getNameWallet(), w.getBalance());
            num++;
        }
        System.out.println("===================================================");
        
        return size;
    }
    
    
    // Display Manage Category
    public static void displayCategoryMenu(User u) {
        
        displayAvailabeCategory(u);
        
        System.out.println("\n--- 📂 Manage Categories ---");
        System.out.println("  1. Add Category");
        System.out.println("  2. Delete Category");
        System.out.println("  3. Show my Categories");
        System.out.println("  4. Exit To Main Menu");
        System.out.println("----------------------------");
    }
    
    // Display Available Categories
    public static int displayAvailabeCategory(User u) {
   
        int size = u.getAppState().getCategory().size();
        
        if (size == 0) {
            
            return 0;
        }
        
        int num = 1;
        System.out.println("\n============== AVAILABLE CATEGORIES ==============");
        System.out.printf(" %-4s | %s\n", "ID", "Category Name");
        System.out.println("──────┼───────────────────────────────────────────");
        
        for (Category c: u.getAppState().getCategory()) {
            
                System.out.printf(" %-4s | %s\n", num + ".", c.getNameCategory());
                num++;
        }
        
        System.out.println("==================================================");
        
        return size;
    }
          
    
    // Show Expenses 
    public static void displayCashFlow(User u) {
        
        System.out.println("\n==================== 📊 CASHFLOW REPORT ====================");
        System.out.println("▼ EXPENSES (Count: " + u.getAppState().getExpenses().size() + ")");
        System.out.println("------------------------------------------------------------");
        double totalExpenses = 0;
        
        for (Expense e : u.getAppState().getExpenses()) {
             System.out.println("  - " + e.getCashFlowInfo());
             totalExpenses += e.getAmount();
        }
        
        System.out.println("\n▲ INCOMES (Count: " + u.getAppState().getExpenses().size() + ")");
        System.out.println("------------------------------------------------------------");
        double totalIncome = 0;
        
        for (Income i : u.getAppState().getIncomes()) {
             System.out.println("  - " + i.getCashFlowInfo());
             totalIncome += i.getAmount();
        }
        
        System.out.println("\n---------------------- SUMMARY -----------------------------");
        System.out.printf("  Total Expenses Amount : Rs %.2f\n", totalExpenses);
        System.out.printf("  Total Income Amount   : Rs %.2f\n", totalIncome);
        System.out.printf("  Remaining amount      : Rs %.2f\n", totalIncome - totalExpenses);
        System.out.println("============================================================");
        
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
                System.out.println("\n  [x] Invalid input. Please enter a number.\n");
                sc.nextLine();
            }
        }
    }
    
    public static Category getCategorySpecific(User u) {
        
        int categoryIndex = getValidInt(String.format("  ➤ Pick a Category (1 - %s): ", u.getAppState().getCategory().size())) - 1;

        Category category;

         // Catch invalid category option to pre return
        try {

            category = u.getAppState().getCategory().get(categoryIndex);
            return category;

        }  catch (IndexOutOfBoundsException i) {

                System.out.println("\n  [x] Category option not found!");
                return null;
        }
    }
    
    public static Wallet getWalletSpecific(User u) {
            // Pick wallet
            int walletIndex = getValidInt(String.format("  ➤ Pick a Wallet (1 - %s): ", u.getAppState().getWallet().size())) - 1;
            
            Wallet wallet;
            // Catch invalid wallet number to pre return
            try {
                
                wallet = u.getAppState().getWallet().get(walletIndex);
                return wallet;
                
            } catch (IndexOutOfBoundsException i) {
                
                System.out.println("\n  [x] Wallet not found!");
                return null;
            }
    }
    
    public static void handleDeposit(User u) {

        // Declear parameters to be passed
        Category category;
        Wallet wallet;
        String description;
        double amount;

        int walletCount = u.getAppState().getWallet().size();

        // Check no wallet case
        if (walletCount == 0) {
            System.out.println("\n  [!] Not enough Wallets! Please create them to add Income.");
            return;
        }

        wallet = getWalletSpecific(u);

        if (wallet == null) { // Return if no wallet selected
                return;
        }
        // Display Available Categories
        int count = displayAvailabeCategory(u);

        // Check no category case
        if (count == 0) {
            System.out.println("\n  [!] Not enough Categories! Please create them to add Income.");
            return;
        }

        category = getCategorySpecific(u);

        if (category == null) { // Return if no category selected
            return;
        }

        //Get name and amount
        System.out.print("  ✎ Enter Income Description: ");
        description = sc.nextLine();
        amount = getValidInt("  💲 Enter amount (Rs): ");
        Income incomeNew = new Income(description, amount, category, wallet);
        u.addIncome(incomeNew);

        System.out.println("\n  [✓] Successfully added income!");

        return;
    }
    
    public static void handleDelete(User u) {
        int walletIndex = getValidInt("  ➤ Enter Wallet ID: ") - 1;
        String name;
        // Catch if wallet exists
                
        try {
            // Delete
            Wallet walletDelete =  u.getAppState().getWallet().get(walletIndex);
            name = walletDelete.getNameWallet();
                    
            u.getAppState().getWallet().remove(walletDelete);
            System.out.printf("\n  [✓] Successfully deleted wallet: %s\n", name);
            return;
                    
        } catch (IndexOutOfBoundsException i) {
                    
           System.out.printf("\n  [x] Wallet ID %s not found!\n", walletIndex + 1);
           return;
        }
    }
    
    public static void handleWithdraw(User u) {
        
        int amountWithdraw = getValidInt("  💲 Enter amount to withdraw (Rs): ");
        Wallet wallet2;
        int walletCount2 = u.getAppState().getWallet().size();

        // Catch no wallet case
        if (walletCount2 == 0) {
            System.out.println("\n  [!] Not enough Wallets! Please create them to add Income.");
            return;
        }

        wallet2 = getWalletSpecific(u);

        if (wallet2 == null) { // If user doesnt select any wallet

                return;
        }


        boolean success = wallet2.withdraw(amountWithdraw);
        if (!success) {

            System.out.printf("\n  [x] Not enough balance in wallet: %s\n", wallet2.getNameWallet());
            return;
        }

        System.out.printf("\n  [✓] Successfully withdrawn Rs %s from wallet: %s\n", amountWithdraw, wallet2.getNameWallet());

        // Not keeping transaction for now.. (Gets complicated)

    }
    
    public static void handleAddWallet(User u) {
                String walletName;
                boolean run;
                
                do {
                    System.out.print("  ✎ Enter Wallet Name: ");
                    walletName = sc.nextLine();
                    run = false;
                    
                    // Checking if the name already exists
                    for (Wallet w: u.getAppState().getWallet()) {

                        if (w.getNameWallet().toLowerCase().equals(walletName.toLowerCase())) {

                            System.out.println("\n  [x] Wallet name already exists! Please try again!");
                            run = true;
                            break;
                        }
                    }
                }
                while (run);
                
                // If doesnt exists
                double balance = getValidInt("  💲 Enter Starting Balance (Rs): ");
                Wallet walletNew = new Wallet(walletName, balance);
                
                u.addWallet(walletNew);
                System.out.printf("\n  [✓] Successfully added wallet: %s\n", walletName);
    }
    
    public static void showTransaction(User u) {
        System.out.println("\n────────────────────────────────────── TRANSACTIONS ──────────────────────────────────────");
        for (Transaction t: u.getAppState().getTransaction()) {

            System.out.println(t.getDetail());

        }
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────");
    }
}
        
