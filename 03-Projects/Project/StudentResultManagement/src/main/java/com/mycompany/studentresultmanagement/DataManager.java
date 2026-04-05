/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author prashnamshrestha
 */
public class DataManager {

    public static void saveAppState(Data data, String filePath) {

        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(data);
            System.out.println("\n  💾 [SUCCESS] Data safely encrypted and archived to " + filePath);

        } catch (IOException e) {
            System.out.println("\n  ❌ [CRITICAL] Failed to archive data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Data loadAppState(String filePath) {

        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // ✅ FIXED HERE
            Data state = (Data) ois.readObject();

            System.out.println("\n  📂 [SUCCESS] Data restored. Welcome back.");
            return state;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("\n  🌱 [INFO] No valid save file found. Initializing a fresh data...\n");
            return new Data();
        }
    }
}

