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
        System.out.println("\n  ⚔️  ================ COMMAND MATRIX ================ ⚔️");
        System.out.println("  ──────────────────────────────────────────────────────");
        System.out.println("    [1] ⚔️  Basic Strike      [4] 🎒 Access Backpack");
        System.out.println("    [2] ✨  Skill Two         [5] 💨 Tactical Retreat");
        System.out.println("    [3] ☄️  Ultimate                        ");
        System.out.println("  ======================================================");
    }
    
    public static void printHeroMainMenu() {
        System.out.println("\n  🏕️  ============= CAMP FIRE HEADQUARTERS ============= 🏕️");
        System.out.println("  ──────────────────────────────────────────────────────");
        System.out.println("    [1] ⚔️  Embark / Continue Exploring ");
        System.out.println("    [2] 🎒 Review Inventory Setup  ");
        System.out.println("    [3] 🚪 Save Progress & Return to Hub ");
        System.out.println("  ======================================================");
    }
    
    public static void printMainMenu(Player player) {
        System.out.println("\n  ======================================================");
        System.out.printf("   👤 COMMANDER: %-15s |  💰 VAULT: %s Gold\n", player.getPlayerName(), player.getPlayerGold());
        System.out.println("  ======================================================");
        System.out.println("    [1] 🌍 Enter a Created World     ");
        System.out.println("    [2] 🏗️  Forge a New World   ");
        System.out.println("    [3] 🦸 Enter Hero Tavern (Shop) ");
        System.out.println("    [4] 🗺️  Consult Cartographer (Maps) ");
        System.out.println("    [5] 💾 Save Protocol & Exit Game ");
        System.out.println("  ──────────────────────────────────────────────────────");
    }
    
    public static void printLoginRegister() {
        System.out.println("\n  🌌 ================================================== 🌌");
        System.out.println("                     DARK STEP LEGEND                     ");
        System.out.println("  🌌 ================================================== 🌌");
        System.out.println("    [1] 🔑 Login to Existing Profile   ");
        System.out.println("    [2] 📝 Register New Commander ");
        System.out.println("    [3] ❌ Terminate Session");
        System.out.println("  ──────────────────────────────────────────────────────");
    }
    
}