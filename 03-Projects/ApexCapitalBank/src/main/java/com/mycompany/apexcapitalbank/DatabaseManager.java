/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apexcapitalbank;

import java.io.*; // This imports Java's File Input/Output tools
import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */
public class DatabaseManager {
    
    private static final String FILE_NAME = "ApexBankData.txt";


    public static void saveGame() {
        try {
            FileOutputStream filePipe = new FileOutputStream(FILE_NAME);
            
            ObjectOutputStream squishMachine = new ObjectOutputStream(filePipe);

            squishMachine.writeObject(ApexCapitalBank.registeredCustomer);
            squishMachine.writeObject(ApexCapitalBank.registeredAdmin);
            squishMachine.writeObject(ApexCapitalBank.accountsMaster);
            
            // Close the machine
            squishMachine.close();
            filePipe.close();
            
            System.out.println("  [SYSTEM] Progress Saved to Hard Drive!");
            
        } catch (Exception e) {
            System.out.println("  [!] Error saving data: " + e.getMessage());
        }
    }

    public static void loadGame() {
        try {
            File f = new File(FILE_NAME);
            if (!f.exists()) {
                System.out.println("  [SYSTEM] No save file found. Starting fresh.");
                return;
            }

            FileInputStream filePipe = new FileInputStream(FILE_NAME);
            
            ObjectInputStream inflateMachine = new ObjectInputStream(filePipe);
            
            ApexCapitalBank.registeredCustomer = (ArrayList<Customer>) inflateMachine.readObject();
            ApexCapitalBank.registeredAdmin = (ArrayList<Admin>) inflateMachine.readObject();
            ApexCapitalBank.accountsMaster = (ArrayList<Account>) inflateMachine.readObject();
            
            // Close the machine
            inflateMachine.close();
            filePipe.close();
            
            System.out.println("  [SYSTEM] Previous Data Loaded Successfully!");

        } catch (Exception e) {
            System.out.println("  [!] Error loading data: " + e.getMessage());
        }
    }
}
