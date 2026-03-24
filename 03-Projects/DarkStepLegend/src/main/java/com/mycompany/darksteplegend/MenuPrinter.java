/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

/**
 *
 * @author prashnamshrestha
 */
public class MenuPrinter {
    public static void printHeroBattleMenu() {
        System.out.println("------------------------------------------------------");
        System.out.println("  1. 🗡️ Attack            4. 💼 Use Item");
        System.out.println("  2. ✨ Skill Two         5. 🏃 Run Away");
        System.out.println("  3. 💥 Ultimate                        ");
        System.out.println("======================================================");
    }
    
    public static void printHeroMainMenu() {
        System.out.println("------------------------------------------------------");
        System.out.println("  1. Explore     ");
        System.out.println("  2. Inventory   ");
        System.out.println("  3. Save & Quit ");
        System.out.println("======================================================");
    }
    
    public static void printMainMenu(Player player) {
        
        System.out.println("------------------------------------------------------");
        System.out.printf("  TOTAL GOLD EARNED: 🌟%s\n", player.getPlayerGold());
        System.out.println("  1. Play World     ");
        System.out.println("  2. Create World   ");
        System.out.println("  3. Shop Heroes ");
        System.out.println("  4. Shop Maps ");
        System.out.println("  5. Save & Exit ");
        System.out.println("======================================================");
    }
    
    public static void printLoginRegister() {
        System.out.println("------------------------------------------------------");
        System.out.println("  1. Login New Player   ");
        System.out.println("  2. Register Player ");
        System.out.println("  5. Exit Game");
        System.out.println("======================================================");
    }
    
}
