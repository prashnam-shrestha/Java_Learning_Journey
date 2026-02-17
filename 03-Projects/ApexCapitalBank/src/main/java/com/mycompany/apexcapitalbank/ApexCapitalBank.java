/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.apexcapitalbank;
import java.time.LocalDate;
import java.time.Month;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class ApexCapitalBank {
    
        public static String passwordApex = "demoPassword123";
    
        // Customers
        public static ArrayList<Customer> registeredCustomer = new ArrayList<>();
        
        // Admins
        public static ArrayList<Admin> registeredAdmin = new ArrayList<>();
        
        // ALL Accounts
        public static ArrayList<Account> accountsMaster = new ArrayList<>();

    public static void main(String[] args) {
        
        boolean run = true;
        while (run) {
            displayMainMenu();
            int choice = getValidInt("  >> Select Option: ");
            
            switch (choice) {
                 case 1 :
                     boolean run1 = true;
                     while (run1) {
                        displayCustomerMenu();
                        run1 = customerLoginOrCreateOperation(); 
                     }

                     break;
                     
                 case 2 :
                     boolean run2 = true;
                     while (run2) {
                        displayAdminMenu();
                        run2 = adminLoginOrCreateOperation(); 
                     }
                     break;
                     
                 case 3 :
                     run = false;
                     System.out.println("\n  Exiting Application. Thank you for banking with Apex Capital!");
                     break;
                     
                 default:
                     System.out.println("  [!] Invalid choice. Please try again.");
                     
            }
             
             

        }
        
        
        
        
        
//        // Playground for building
//        
//        Customer customer1 = new Customer("Amrit Shrestha", "+977 9816086590", LocalDate.of(2009, Month.MARCH, 10), "amrit123");
//        Customer customer2 = new Customer("Saman Shrestha", "+977 9816086590", LocalDate.of(2009, Month.MARCH, 10), "Saman123");
//        Admin admin = new Admin("Prashnam Shrestha", "+977 9810929090", getValidDate("Enter date of birth( YYYY-MM-DD ): "), "admin123");
//        
////        System.out.println(admin.getInfoGeneral());
////        System.out.println(customer.getInfoGeneral());
//        
//        SavingsAccount a1 = new SavingsAccount(0, 10);
//        SavingsAccount a2 = new SavingsAccount(2500, 10);
//        FixedDepositAccount fd1 = new FixedDepositAccount(1000, 10, getValidDate("Enter maturity period: "));
//        LoanAccount l1 = new LoanAccount(1000, 10);
//        
//        customer1.addAccountsCustomer(a1);
//        customer1.addAccountsCustomer(fd1);
//        customer2.addAccountsCustomer(a2);
//        customer2.addAccountsCustomer(l1);
//        
//        
//        registeredCustomer.add(customer2);
//        registeredCustomer.add(customer1);
//        registeredAdmin.add(admin);
//        
//        a1.deposit(1000);
//        a1.withdraw(1000);
//        a2.transferBal(1000, a1);
//        a2.withdraw(500);
//        l1.withdraw(1000);
//        l1.deposit(1000);
//        fd1.deposit(1000);
//        fd1.withdraw(500);
//        accountsMaster.add(a1);
//        accountsMaster.add(a2);
//        accountsMaster.add(fd1);
//        accountsMaster.add(l1);
//        
//        
//        for(Account a: accountsMaster) {
//            a.performEOM();
//        }
//        
//        
//        // Transaction history
//        a1.getAccountTransactions();
//        a2.getAccountTransactions();
//        l1.getAccountTransactions();
//        
//        for (Customer c: registeredCustomer) {
//            System.out.printf("------ %s has following accounts -----\n", c.getName());
//            c.getInfoAccounts();
//        }
//        
         //Real engine
         
        
        
    }
    public static Scanner sc = new Scanner(System.in);
    

    
    
    // Get valid date 
    public static LocalDate getValidDate(String text) {
        while (true) {
            try {
                System.out.print(text);
                String date = sc.nextLine();
                LocalDate dateParse =  LocalDate.parse(date);
                return dateParse;
            }
            catch (Exception e) {
                System.out.println("  [!] Invalid date format! Please use (YYYY-MM-DD)");   
            }
            
        }
    }
    
    public static void displayMainMenu() {
        System.out.println("\n========================================");
        System.out.println("      APEX CAPITAL BANK - MAIN MENU     ");
        System.out.println("========================================");
        System.out.println("  1. Customer Portal");
        System.out.println("  2. Administrator Portal");
        System.out.println("  3. Exit Application");
        System.out.println("----------------------------------------");
    }
    
    public static void displayCustomerMenu() {
        System.out.println("\n------- CUSTOMER PORTAL -------");
        System.out.println("  1. Login");
        System.out.println("  2. Create New Profile");
        System.out.println("  3. Return to Main Menu");
        System.out.println("-------------------------------");
    }
    
    public static boolean customerLoginOrCreateOperation() {
        int choice = getValidInt("  >> Select Option: ");
        switch (choice) {
            case 1: 
                System.out.print("  >> Enter Full Name: ");
                String name = sc.nextLine();
                System.out.print("  >> Enter Password: ");
                String password = sc.nextLine();
                boolean match = false;
                
                for (Customer c: registeredCustomer) {
                    if (name.equals(c.getName()) && password.equals(c.getPassword())) {
                        System.out.println("\n  [✓] Login Successful.");
                        match = true;
                        boolean run = true;
                        while (run) {
                            displayCLoggedmenu(c);
                            run = customerLoggedOperation(c);
                        }
                        
                        break;
                    }
                }
                if (!match) {
                    System.out.println("  [!] Authentication Failed: Incorrect Name or Password.");
                }
                
                break;
                
            // Create new customer account;
            case 2: 
                System.out.println("\n--- NEW CUSTOMER REGISTRATION ---");
                System.out.print("  >> Enter Full Name: ");
                String nameNew = sc.nextLine();
                System.out.print("  >> Enter Phone Number: ");
                String phoneNew = sc.nextLine();
                LocalDate dateOfBirthNew = getValidDate("  >> Enter Date of Birth (YYYY-MM-DD): ");
                System.out.print("  >> Create Password: ");
                String passwordNew = sc.nextLine();
                
                Customer customer1 = new Customer(nameNew, phoneNew, dateOfBirthNew, passwordNew);
                System.out.println("\n  [✓] Customer Profile Created Successfully!");
                System.out.println(customer1.getInfoGeneral());
                
                registeredCustomer.add(customer1);
                
                break;
            // EXIT
            case 3: 
                System.out.println("  Returning to Main Menu...");
                return false;
                
            default:
                System.out.println("  [!] Choice not found!");  
        }
        return true;
    }
    
    
    
    public static void displayAdminMenu(){
        System.out.println("\n-------- ADMIN PORTAL --------");
        System.out.println("  1. Login");
        System.out.println("  2. Create New Admin Profile");
        System.out.println("  3. Return to Main Menu");
        System.out.println("------------------------------");
    }
    
    public static boolean adminLoginOrCreateOperation() {
        int choice = getValidInt("  >> Select Option: ");
        switch (choice) {
            case 1: 
                System.out.print("  >> Enter Admin Name: ");
                String name = sc.nextLine();
                System.out.print("  >> Enter Password: ");
                String password = sc.nextLine();
                boolean match = false;
                
                for (Admin a: registeredAdmin) {
                    if (name.equals(a.getName()) && password.equals(a.getPassword())) {
                        System.out.println("\n  [✓] Administrator Access Granted.");
                        match = true;
                        boolean run = true;
                        while (run) {
                            displayALoggedmenu(a);
                            run = adminLoggedOperation(a);
                        }
                        break;
                    }
                }
                
                if (!match) {
                    System.out.println("  [!] Access Denied: Incorrect Name or Password.");
                }
                
                break;
                
            // Create new admin account;
            case 2: 
                System.out.println("\n--- NEW ADMIN REGISTRATION ---");
                System.out.print("  >> Enter Master Authorization Password: ");
                String passwordInputApex = sc.nextLine();
                if (!(passwordApex.equals(passwordInputApex))) {
                    System.out.println("  [!] Authorization Failed: Incorrect Master Password.");
                    break;
                }
                
                System.out.print("  >> Enter Full Name: ");
                String nameNew = sc.nextLine();
                System.out.print("  >> Enter Phone Number: ");
                String phoneNew = sc.nextLine();
                LocalDate dateOfBirthNew = getValidDate("  >> Enter Date of Birth (YYYY-MM-DD): ");
                System.out.print("  >> Create Password: ");
                String passwordNew = sc.nextLine();

                
                
                Admin admin1 = new Admin(nameNew, phoneNew, dateOfBirthNew, passwordNew);
                System.out.println("\n  [✓] Admin Account Created Successfully!");
                System.out.println(admin1.getInfoGeneral());
                
                registeredAdmin.add(admin1);
                
                break;
                
            case 3:
                System.out.println("  Returning to Main Menu...");
                return false;
                
            default:
                System.out.println("  [!] Choice not found!");
                
                
        }
        return true;
    }
    
    public static void displayCLoggedmenu(Customer c) {
        System.out.println("\n=========================================");
        System.out.printf("  Logged In As: %s\n", c.getName());
        System.out.println("=========================================");
        System.out.println("  1. Access Existing Account");
        System.out.println("  2. Open New Bank Account");
        System.out.println("  3. View My Profile");
        System.out.println("  4. Logout");
        System.out.println("-----------------------------------------");
    }
    
    public static boolean customerLoggedOperation(Customer c) {
        int choice = getValidInt("  >> Select Option: ");
        switch (choice) {
            case 1: 
                int accNo = getValidInt("  >> Enter Account Number: ");
                int accPin = getValidInt("  >> Enter Account PIN: ");
                boolean match = false;
                
                for (Account acc: accountsMaster) {
                    if (accNo == acc.getAccountNo() && accPin == acc.getAccountPin()) {
                        System.out.println("  [✓] Access Verified.");
                        match = true;
                        boolean run = true;
                        while (run) {
                            run = customerSpecificLoggedOperation(c, acc);
                        }
                        break;
                    }
                }
                
                if (!match) {
                    System.out.println("  [!] Error: Incorrect Account Number or PIN.");
                }
                
                break;
                
            // Create new bank account;
            case 2: 

                System.out.println("\n--- OPEN NEW ACCOUNT ---");
                System.out.println("  1. Savings Account");
                System.out.println("  2. Fixed Deposit (FD) Account");
                System.out.println("  3. Loan Account");
                int choiceType = getValidInt("  >> Select Account Type: ");
                switch (choiceType) {
                    case 1:
                        SavingsAccount acc1 = new SavingsAccount(0, 10);
                        accountsMaster.add(acc1);
                        System.out.println("\n  [✓] Savings Account Opened!");
                        System.out.printf("  | Account No: %s | PIN: %s |\n", acc1.getAccountNo(), acc1.getAccountPin());
                        c.addAccountsCustomer(acc1);
                        break;
                        
                    case 2:
                        LoanAccount acc2 = new LoanAccount(0, 15);
                        accountsMaster.add(acc2);
                        System.out.println("\n  [✓] Loan Account Opened!");
                        System.out.printf("  | Account No: %s | PIN: %s |\n", acc2.getAccountNo(), acc2.getAccountPin());
                        c.addAccountsCustomer(acc2);
                        break;
                                
                        
                    case 3:
                        LocalDate maturity = getValidDate("  >> Enter Maturity Date (YYYY-MM-DD): ");
                        int amount = getValidInt("  >> Enter Initial Deposit Amount: ");
                        FixedDepositAccount acc3 = new FixedDepositAccount(amount, 15, maturity);
                        accountsMaster.add(acc3);
                        System.out.println("\n  [✓] Fixed Deposit Account Opened!");
                        System.out.printf("  | Account No: %s | PIN: %s |\n", acc3.getAccountNo(), acc3.getAccountPin());
                        c.addAccountsCustomer(acc3);
                        break;
                        
                    default:
                        System.out.println("  [!] Invalid Option.");
                }
                
                break;
                
            // Show info
            case 3:
                System.out.println("\n--- MY ACCOUNTS ---");
                c.getInfoAccounts();
                break;
                
            case 4:
                System.out.println("  Logging out...");
                return false;
                
            default:
                System.out.println("  [!] Choice not found!");
                
                
        }
        return true;
    }
    
    public static boolean adminLoggedOperation(Admin a) {
        int choice = getValidInt("  >> Select Option: ");
        switch (choice) {
            
            //Show assets and liability
            case 1:
                int assets = 0;
                int liability = 0;
                for (Account acc: accountsMaster) {
                    if (!(acc instanceof LoanAccount)) {
                        liability += acc.getBalance();
                    }
                    else {
                        assets += acc.getBalance();
                    }
                }
                System.out.println("\n--- BANK FINANCIAL REPORT ---");
                System.out.printf("  Total Assets (Loans Given):     Rs %s\n", assets);
                System.out.printf("  Total Liabilities (Deposits):   Rs %s\n", liability);
                System.out.println("-----------------------------");
                break;
                
            // End of month operation  
            case 2: 
                for (Account acc: accountsMaster) {
                    acc.performEOM();
                }
                System.out.println("  [✓] End of month operation done successfully!");
                break;

            // Show info
            case 3:
                System.out.println("\n--- MASTER ACCOUNT LIST ---");
                for (Account acc: accountsMaster) {
                    System.out.println(acc.getAccInfo());
                }
                break;
                
            // Freeze account;
            case 4:
                
                int accNo = getValidInt("  >> Enter Account Number to Freeze: ");
                for (Account acc: accountsMaster) {
                    if (accNo == acc.getAccountNo()) {
                        acc.setFreeze(true);
                        System.out.println("  [✓] Account Frozen Successfully.");
                        break;
                    }
                }
                System.out.println("  [!] Account Not Found."); // Only prints if loop finishes without break, techincally logic flow allows this.
                break;
                
            // Exit
            case 5:
                return false;
                
            default:
                System.out.println("  [!] Option not found");
                     
        }
        
        return true;
    }
    
    
    public static void displayALoggedmenu(Admin a) {
        System.out.println("\n=========================================");
        System.out.printf("  Admin Dashboard: %s\n", a.getName());
        System.out.println("=========================================");
        System.out.println("  1. Show Bank Assets & Liabilities");
        System.out.println("  2. Run End-Of-Month (EOM) Operations");
        System.out.println("  3. View All Accounts");
        System.out.println("  4. Freeze an Account");
        System.out.println("  5. Logout");
        System.out.println("-----------------------------------------");
    }
    
    public static void displayCSavingsMenu(Customer c, Account sa) {
        System.out.println("\n  --- SAVINGS ACCOUNT DASHBOARD ---");
        System.out.printf("  Welcome %s,\n", c.getName());
        System.out.printf("  Available Balance: Rs %s\n", sa.getBalance());
        System.out.println("  ---------------------------------");
        System.out.println("  1. Deposit Funds");
        System.out.println("  2. Withdraw Funds");
        System.out.println("  3. Transfer Balance");
        System.out.println("  4. View Transaction History");
        System.out.println("  5. Back to Customer Menu");
        System.out.println("  ---------------------------------");
    }
    
    public static void displayCLoanMenu(Customer c, Account la) {
        System.out.println("\n  --- LOAN ACCOUNT DASHBOARD ---");
        System.out.printf("  Welcome %s,\n", c.getName());
        System.out.printf("  Outstanding Loan: Rs %s\n", la.getBalance());
        System.out.println("  ---------------------------------");
        System.out.println("  1. Deposit (Repay Loan)");
        System.out.println("  2. Withdraw (Request More Loan)");
        System.out.println("  3. View Transaction History");
        System.out.println("  4. Back to Customer Menu");
        System.out.println("  ---------------------------------");
    }
    
    
    public static void displayCFixedDepositMenu(Customer c, Account fa) {
        System.out.println("\n  --- FIXED DEPOSIT DASHBOARD ---");
        System.out.printf("  Welcome %s,\n", c.getName());
        System.out.printf("  Fixed Deposit Balance: Rs %s\n", fa.getBalance());
        System.out.println("  ---------------------------------");
        System.out.println("  1. Deposit (Restricted)");
        System.out.println("  2. Withdraw (Premature/Maturity)");
        System.out.println("  3. View Transaction History");
        System.out.println("  4. Back to Customer Menu");
        System.out.println("  ---------------------------------");
    }
    
    public static int getValidInt(String text) {
        while (true) {
            try {
                System.out.print(text);
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            }
            catch (Exception e) {
                System.out.println("  [!] Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }
    
    public static boolean customerSpecificLoggedOperation(Customer customer, Account acc) {
        
        if (acc instanceof SavingsAccount) {
            displayCSavingsMenu(customer, acc);
            int choice = getValidInt("  >> Select Option: ");
            switch (choice) {
                
                // Deposit
                case 1:
                    int amountD = getValidInt("  >> Enter Amount to Deposit: ");
                    acc.deposit(amountD);
                    break;
                
                // Withdraw
                case 2:
                    int amountW = getValidInt("  >> Enter Amount to Withdraw: ");
                    acc.withdraw(amountW);
                    break;
                    
                // Transfer
                case 3:
                    int amountT = getValidInt("  >> Enter Amount to Transfer: ");
                    int receiverAccNo = getValidInt("  >> Enter Receiver Account No: ");
                    boolean match = false;
                    for (Account accT: accountsMaster) {
                        if (accT.getAccountNo() == receiverAccNo) {
                            acc.transferBal(amountT, accT);
                            match = true;
                            break;
                        }
                    }
                    if (!match) {
                        System.out.printf("  [!] Error: No account found with number %s\n", receiverAccNo);
                    }

                    
                    break;
                
                case 4:
                    acc.getAccountTransactions();
                    break;
                    
                case 5:
                    return false;
                    
                default:
                    System.out.println("  [!] Option not found");
              
            }
        }
        
        else if (acc instanceof LoanAccount) {
            displayCLoanMenu(customer, acc);
            int choice = getValidInt("  >> Select Option: ");
            switch (choice) {
                
                // Deposit
                case 1:
                    int amountD = getValidInt("  >> Enter Amount to Deposit: ");
                    acc.deposit(amountD);
                    break;
                
                // Withdraw
                case 2:
                    int amountW = getValidInt("  >> Enter Amount to Withdraw: ");
                    acc.withdraw(amountW);
                    break;
                    
                case 3:
                    acc.getAccountTransactions();
                    break;
                    
                case 4:
                    return false;
                    
                default:
                    System.out.println("  [!] Option not found");
              
            }
        }
        else if (acc instanceof FixedDepositAccount) {
            displayCFixedDepositMenu(customer, acc);
            int choice = getValidInt("  >> Select Option: ");
            switch (choice) {
                
                // Deposit
                case 1:
                    int amountD = getValidInt("  >> Enter Amount to Deposit: ");
                    acc.deposit(amountD);
                    break;
                
                // Withdraw
                case 2:
                    int amountW = getValidInt("  >> Enter Amount to Withdraw: ");
                    acc.withdraw(amountW);
                    break;
                    
                case 3:
                    acc.getAccountTransactions();
                    break;
                    
                case 4:
                    return false;
                    
                default:
                    System.out.println("  [!] Option not found");
              
            }
        }
        return true;
        
    }
    
    
    
}