package com.mycompany.darksteplegends;

public class MenuPrinter {
    
    // --- HELPER METHOD FOR COOL HEALTH BARS ---
    public static String getProgressBar(int current, int max, int barLength) {
        if (max <= 0) return "[          ]"; 
        
        int filled = (int) Math.round(((double) current / max) * barLength);
        filled = Math.min(Math.max(filled, 0), barLength); 
        
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            if (i < filled) bar.append("█"); 
            else bar.append("░");            
        }
        bar.append("]");
        return bar.toString();
    }

    // --- MAIN MENU ---
    public static void displayMainMenu() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║              ⚔️ DARKSTEP LEGENDS ⚔️             ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║  1. 🌍 Enter World                             ║");
        System.out.println("║  2. 🏪 Shop Heroes                             ║");
        System.out.println("║  3. 🔓 Unlock Worlds                           ║");
        System.out.println("║  4. 📜 Guide Book                              ║");
        System.out.println("║  5. ❌ Exit Game                               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
    }
    
    // --- COMBAT SCREEN ---
    public static void displayFightAct(Hero hero, Enemy enemy) {
        // Fallback max HP for visual bars (can be updated later if you add getMaxHp to enemies)
        int heroMaxHp = hero.getLevel() * 250 + 150; // rough estimate based on your hero stats
        int enemyMaxHp = 500; 
        
        System.out.println("\n==================== ⚔️ BATTLE ⚔️ ====================");
        System.out.printf(" %-25s vs %-25s\n", "🦸 " + hero.getName(), "👹 " + enemy.getName());
        
        System.out.printf(" HP: %-21s    HP: %-21s\n", 
            getProgressBar(hero.getHp(), heroMaxHp, 10) + " " + hero.getHp(), 
            getProgressBar(enemy.getHp(), enemyMaxHp, 10) + " " + enemy.getHp()
        );
        
        System.out.printf(" MP: %-21s\n", 
            getProgressBar(hero.getMana(), 100, 10) + " " + hero.getMana()
        );
        
        System.out.println("------------------------------------------------------");
        System.out.println("  1. 🗡️ Attack             3. 🧪 Use Item");
        System.out.println("  2. ✨ Ultimate           4. 🏃 Run Away");
        System.out.println("======================================================");
    }
    
    // --- WORLD / EXPLORATION MENU ---
    public static void displayHeroMenu(Player p, World world) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.printf("║ 🗺️  WORLD: %-35s ║\n", world.getName().toUpperCase());
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.printf("║ 🚩 CURRENT PHASE: %-28s ║\n", world.getPhase() + " / 8"); 
        System.out.println("║ 🎯 GOAL: Survive until the end!                ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║  1. 🚶 Explore further (Encounter)             ║");
        System.out.println("║  2. 🏕️ Rest (Recover HP/MP)                    ║");
        System.out.println("║  3. 🎒 View Inventory / Stats                  ║");
        System.out.println("║  4. 🚪 Retreat to Main Menu                    ║");
        System.out.println("╚════════════════════════════════════════════════╝");
    }
}