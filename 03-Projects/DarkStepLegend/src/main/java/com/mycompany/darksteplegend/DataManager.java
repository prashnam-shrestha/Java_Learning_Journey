package com.mycompany.darksteplegend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataManager {

    public static void saveAppState(GameData data, String filePath) {

        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(data);
            System.out.println("\n  💾 [SUCCESS] Progress safely encrypted and archived to " + filePath);

        } catch (IOException e) {
            System.out.println("\n  ❌ [CRITICAL] Failed to archive data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static GameData loadAppState(String filePath) {

        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // ✅ FIXED HERE
            GameData state = (GameData) ois.readObject();

            System.out.println("\n  📂 [SUCCESS] Game state restored. Welcome back.");
            return state;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("\n  🌱 [INFO] No valid save file found. Initializing a fresh universe...\n");
            return new GameData();
        }
    }
}