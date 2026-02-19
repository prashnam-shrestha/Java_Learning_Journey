package com.mycompany.apexcapitalbank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class ApexCapitalBank {

    public static String passwordApex = "demoPassword123";

    // Data Lists
    public static ArrayList<Customer> registeredCustomer = new ArrayList<>();
    public static ArrayList<Admin> registeredAdmin = new ArrayList<>();
    public static ArrayList<Account> accountsMaster = new ArrayList<>();

public static void main(String[] args) {
        // 1. Make the UI look modern
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. Load Save Data
        DatabaseManager.loadGame();

        // 3. FORCE ADD Test Users (Removed the 'if' statement)
        registeredCustomer.add(new Customer("Prashnam", "9816086590", LocalDate.of(2008, Month.MARCH, 10), "Prashnam"));
        registeredAdmin.add(new Admin("Admin", "0000", LocalDate.of(1990, Month.JANUARY, 1), "admin123"));
        

        // 4. Start the Application UI
        openLoginScreen();
    }

    // ==========================================
    // 1. LOGIN SCREEN
    // ==========================================
    public static void openLoginScreen() {
        JFrame frame = new JFrame("Apex Capital Bank - Login");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Save data automatically when the user clicks the 'X' to close the app!
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DatabaseManager.saveGame();
            }
        });

        // Title Panel
        JLabel titleLabel = new JLabel("Welcome to Apex Capital Bank", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        JTextField nameField = new JTextField();
        JPasswordField passField = new JPasswordField();
        
        inputPanel.add(new JLabel("Username (Name):"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passField);
        frame.add(inputPanel, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton custLoginBtn = new JButton("Customer Login");
        JButton adminLoginBtn = new JButton("Admin Login");

        // Customer Login Logic
        custLoginBtn.addActionListener(e -> {
            String name = nameField.getText();
            String pass = new String(passField.getPassword());
            boolean found = false;

            for (Customer c : registeredCustomer) {
                if (c.getName().equals(name) && c.getPassword().equals(pass)) {
                    frame.dispose(); // Close login window
                    openCustomerDashboard(c); // Open Dashboard
                    found = true;
                    break;
                }
            }
            if (!found) JOptionPane.showMessageDialog(frame, "Invalid Customer Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
        });

        // Admin Login Logic
        adminLoginBtn.addActionListener(e -> {
            String name = nameField.getText();
            String pass = new String(passField.getPassword());
            boolean found = false;

            for (Admin a : registeredAdmin) {
                if (a.getName().equals(name) && a.getPassword().equals(pass)) {
                    frame.dispose();
                    openAdminDashboard(a);
                    found = true;
                    break;
                }
            }
            if (!found) JOptionPane.showMessageDialog(frame, "Invalid Admin Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
        });

        buttonPanel.add(custLoginBtn);
        buttonPanel.add(adminLoginBtn);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }

    // ==========================================
    // 2. CUSTOMER DASHBOARD
    // ==========================================
    public static void openCustomerDashboard(Customer c) {
        JFrame frame = new JFrame("Customer Portal - " + c.getName());
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { DatabaseManager.saveGame(); }
        });

        JLabel welcomeLabel = new JLabel("Hello, " + c.getName() + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(welcomeLabel, BorderLayout.NORTH);

        // Account List Display
        JTextArea accountDisplay = new JTextArea();
        accountDisplay.setEditable(false);
        updateAccountDisplay(c, accountDisplay);
        frame.add(new JScrollPane(accountDisplay), BorderLayout.CENTER);

        // Actions Panel
        JPanel actionPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JButton openAccBtn = new JButton("Open New Account");
        JButton manageAccBtn = new JButton("Manage Account (Deposit/Withdraw)");
        JButton refreshBtn = new JButton("Refresh");
        JButton logoutBtn = new JButton("Logout");

        // Open Account Logic
        openAccBtn.addActionListener(e -> {
            String[] options = {"Savings", "Loan", "Fixed Deposit"};
            int choice = JOptionPane.showOptionDialog(frame, "Select Account Type:", "Open Account",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            if (choice == 0) {
                SavingsAccount sa = new SavingsAccount(0, 10);
                accountsMaster.add(sa);
                c.addAccountsCustomer(sa);
                JOptionPane.showMessageDialog(frame, "Savings Account Opened!\nAccount No: " + sa.getAccountNo() + "\nPIN: " + sa.getAccountPin());
            } else if (choice == 1) {
                LoanAccount la = new LoanAccount(0, 15);
                accountsMaster.add(la);
                c.addAccountsCustomer(la);
                JOptionPane.showMessageDialog(frame, "Loan Account Opened!\nAccount No: " + la.getAccountNo() + "\nPIN: " + la.getAccountPin());
            } else if (choice == 2) {
                FixedDepositAccount fda = new FixedDepositAccount(0, 12, LocalDate.now().plusYears(1));
                accountsMaster.add(fda);
                c.addAccountsCustomer(fda);
                JOptionPane.showMessageDialog(frame, "Fixed Deposit Opened!\nAccount No: " + fda.getAccountNo() + "\nPIN: " + fda.getAccountPin());
            }
            updateAccountDisplay(c, accountDisplay);
            DatabaseManager.saveGame();
        });

        // Manage Account Logic (Using Quick Dialogs)
        manageAccBtn.addActionListener(e -> {
            try {
                int accNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Number:"));
                int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter PIN:"));
                
                Account targetAcc = null;
                for (Account acc : c.getAccountsCustomer()) {
                    if (acc.getAccountNo() == accNo && acc.getAccountPin() == pin) {
                        targetAcc = acc; break;
                    }
                }

                if (targetAcc != null) {
                    openAccountActionMenu(targetAcc, c, accountDisplay);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Account Number or PIN!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Input cancelled or invalid format.");
            }
        });

        refreshBtn.addActionListener(e -> updateAccountDisplay(c, accountDisplay));

        logoutBtn.addActionListener(e -> {
            DatabaseManager.saveGame();
            frame.dispose();
            openLoginScreen();
        });

        actionPanel.add(openAccBtn);
        actionPanel.add(manageAccBtn);
        actionPanel.add(refreshBtn);
        actionPanel.add(logoutBtn);
        frame.add(actionPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void updateAccountDisplay(Customer c, JTextArea area) {
        StringBuilder sb = new StringBuilder("\n  --- MY ACCOUNTS ---\n\n");
        if (c.getAccountsCustomer().isEmpty()) {
            sb.append("  No accounts found. Please open one!");
        } else {
            for (Account a : c.getAccountsCustomer()) {
                sb.append(a.getAccInfo()).append("\n  Account No: ").append(a.getAccountNo()).append("\n\n");
            }
        }
        area.setText(sb.toString());
    }

    // ==========================================
    // 3. ACCOUNT ACTIONS (Deposit/Withdraw)
    // ==========================================
    private static void openAccountActionMenu(Account acc, Customer c, JTextArea display) {
        String[] options = {"Deposit", "Withdraw", "View History"};
        int action = JOptionPane.showOptionDialog(null, "Manage Account: " + acc.getAccountNo() + "\nBalance: Rs " + acc.getBalance(),
                "Account Actions", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        try {
            if (action == 0) { // Deposit
                double amt = Double.parseDouble(JOptionPane.showInputDialog("Enter Deposit Amount:"));
                acc.deposit(amt);
                JOptionPane.showMessageDialog(null, "Deposit processed.");
            } else if (action == 1) { // Withdraw
                double amt = Double.parseDouble(JOptionPane.showInputDialog("Enter Withdrawal Amount:"));
                acc.withdraw(amt);
                JOptionPane.showMessageDialog(null, "Withdrawal processed (check history if frozen).");
            } else if (action == 2) { // History
                StringBuilder hist = new StringBuilder("Transactions:\n");
                for (Transaction t : acc.getTransactions()) {
                    hist.append(t.getInfoTransaction()).append("\n");
                }
                JOptionPane.showMessageDialog(null, hist.length() > 15 ? hist.toString() : "No transactions yet.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid amount.");
        }
        updateAccountDisplay(c, display);
        DatabaseManager.saveGame();
    }

    // ==========================================
    // 4. ADMIN DASHBOARD
    // ==========================================
    public static void openAdminDashboard(Admin a) {
        JFrame frame = new JFrame("Admin Portal");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { DatabaseManager.saveGame(); }
        });

        frame.add(new JLabel("Administrator Dashboard", SwingConstants.CENTER));

        JButton viewStatsBtn = new JButton("View Assets & Liabilities");
        JButton eomBtn = new JButton("Run End-Of-Month (EOM) Operations");
        JButton freezeBtn = new JButton("Freeze an Account");
        JButton logoutBtn = new JButton("Logout");

        viewStatsBtn.addActionListener(e -> {
            double assets = 0, liability = 0;
            for (Account acc : accountsMaster) {
                if (acc instanceof LoanAccount) assets += acc.getBalance();
                else liability += acc.getBalance();
            }
            JOptionPane.showMessageDialog(frame, "Total Assets (Loans): Rs " + assets + "\nTotal Liabilities (Deposits): Rs " + liability);
        });

        eomBtn.addActionListener(e -> {
            for (Account acc : accountsMaster) acc.performEOM();
            DatabaseManager.saveGame();
            JOptionPane.showMessageDialog(frame, "End of Month interests processed for all accounts!");
        });

        freezeBtn.addActionListener(e -> {
            try {
                int accNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Account No to Freeze/Unfreeze:"));
                for (Account acc : accountsMaster) {
                    if (acc.getAccountNo() == accNo) {
                        acc.setFreeze(!acc.isFreeze());
                        JOptionPane.showMessageDialog(frame, "Account " + accNo + " frozen state is now: " + acc.isFreeze());
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Account not found.");
            } catch (Exception ex) {}
        });

        logoutBtn.addActionListener(e -> {
            DatabaseManager.saveGame();
            frame.dispose();
            openLoginScreen();
        });

        frame.add(viewStatsBtn);
        frame.add(eomBtn);
        frame.add(freezeBtn);
        frame.add(logoutBtn);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}