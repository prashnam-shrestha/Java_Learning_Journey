/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.darksteplegend;

import static com.mycompany.darksteplegend.InputHelper.getValidInt;
import static com.mycompany.darksteplegend.InputHelper.getValidString;

import static com.mycompany.darksteplegend.MenuPrinter.*;

/**
 *
 * @author prashnamshrestha
 */
public class DarkStepLegend {

    public static void main(String[] args) {
   
        String SAVE_FILE = "save.dat";
        GameData data = DataManager.loadAppState(SAVE_FILE);
        
        while (true) {
            printLoginRegister();
            
            int choice = getValidInt("  ➤ Select an option: ", 1, 3);
            
            switch(choice) {
                case 1:
                    loginOperation(data);
                    break;
                case 2:
                    registerOperation(data);
                    break;
                case 3:
                    DataManager.saveAppState(data, "save.dat");
                    return;
                default:
            }
        }
          
          
    }
    
    public static void playWorldOperation(Player player) {
        int i = 1;
        int choice;
        int worldCount = player.getPlayerWorlds().size();
        if (worldCount <= 0) {
            System.out.println("\n  [!] No worlds discovered yet.\n  ➤ Please create a new world to begin your journey.\n");
            return;
        }
        
        System.out.println("\n  🌍 =============== YOUR WORLDS =============== 🌍");
        for (GameWorld w: player.getPlayerWorlds()) {
            System.out.printf("  [%s] 📍 %-15s | ⚙️ Mode: %s\n", i, w.getGameWorldName(), w.getGameWorldType());
            i++;
        }
        System.out.println("  ─────────────────────────────────────────────────");
        
        choice = getValidInt("  ➤ Enter World Number: ", 1, worldCount) - 1;
        GameWorld gameWorld = player.getPlayerWorlds().get(choice);
        
        while (true) {
            
            printHeroMainMenu();
            choice = getValidInt("  ➤ Select an option: ", 1, 4);

            switch(choice) {
                case 1: 
                    gameWorld.exploreWorld();
                    break;
                case 2:
                    gameWorld.getHero().showInventory();
                    break;
                  
                case 3:
                    player.depositGold(gameWorld.getHero().getGold());
                    gameWorld.getHero().setGold(0);
                    System.out.println("\n  🚪 Safely exiting Game World. Returning to base...\n");
                    return;

                default:

            }
        }

    }
    
    public static void createWorldOperation(Player player) {
        System.out.println("\n  🏗️  ============= WORLD CREATION ============= 🏗️");
        String name = getValidString("  ➤ Enter a name for your new world: ");
        System.out.println("\n  ⚔️  SELECT DIFFICULTY ⚔️");
        System.out.println("  ────────────────────────");
        System.out.println("  [1] 🟢 EASY (Forgiving, low risk)");
        System.out.println("  [2] 🔴 HARD (Permadeath resets, high stakes)");
        int difficulty = getValidInt("  ➤ Choose difficulty (1-2): ", 1, 2);
        
        System.out.println("\n  🦸 SELECT YOUR HERO 🦸");
        System.out.println("  ──────────────────────");
        int i = 1;
        for (Hero hero: player.getPlayerHeroes()) {
            
            System.out.printf("  [%s] ", i);
            System.out.println(hero.getStatus());
            i++;
        }
        int heroIndex = getValidInt("  ➤ Choose a hero: ", 1, player.getPlayerHeroes().size()) - 1;
        
        System.out.println("\n  🗺️  SELECT YOUR MAP 🗺️");
        System.out.println("  ─────────────────────");
        i = 1;
        for (Map map: player.getPlayerMaps()) {
            
            System.out.printf("  [%s] ", i);
            System.out.println(map.getMapName());
            i++;
        }
        int mapIndex = getValidInt("  ➤ Choose a map: ", 1, player.getPlayerMaps().size()) - 1;
        Map mapCopy = new Map(player.getPlayerMaps().get(mapIndex));
        GameWorld newWorld;
        
        if (difficulty == 1) {
            newWorld = new GameWorld(mapCopy, player.getPlayerHeroes().get(heroIndex), 
                        GameWorldType.EASY, name);
        }
        else {
            newWorld = new GameWorld(mapCopy, player.getPlayerHeroes().get(heroIndex), 
                        GameWorldType.HARD, name);
        }
        
        player.addPlayerWorld(newWorld);
        System.out.println("\n  ✅ [SUCCESS] World '" + name + "' generated successfully!\n");
    }
    
    public static void shopHeroOperation(GameData data, Player player) {
        
        System.out.println("\n  🛒 =================== HERO TAVERN =================== 🛒");
        System.out.println("  Recruit powerful new allies to aid your journey.");
        System.out.println("  ───────────────────────────────────────────────────────");
        int i = 1;
        for (Hero hero: data.getGameAllHeroes()) {
            System.out.printf("  [%s] ❤️ HP: %-4s | ⚔️ ATK: %-3s | ✨ S2: %-3s | ☄️ ULT: %-3s | 💰 200 Gold | 🦸 %s\n", i,
                                hero.getMaxHp(), hero.getPassiveDmg(), hero.getSkill2Dmg(), hero.getUltimateDmg(),  hero.getName());
            i++;

        }
        System.out.println("  ───────────────────────────────────────────────────────");
        int heroIndex = getValidInt("  ➤ Enter Hero Number to recruit: ", 1, data.getGameAllHeroes().size()) - 1;
        if (player.getPlayerGold() < 200) {
            System.out.println("\n  ❌ [DECLINED] Not enough Gold to recruit this hero.\n  ➤ Return when your pockets are heavier!");
            return;
        }
        player.addPlayerHero(data.getHeroFromData(heroIndex));
        
        player.withdrawGold(200);
        
        System.out.println("\n  🎉 [RECRUITED] Hero has joined your ranks! (-200 💰 Gold)\n");
               
    }
    
    public static void shopMapOperation() {
        System.out.println("\n  🚧 [INFO] The Map Cartographer is currently out of town. Feature coming soon! 🚧\n");
    }
    
    
    public static void registerOperation(GameData data) {
        System.out.println("\n  📝 --- NEW COMMANDER REGISTRATION ---");
        String namePlayer = getValidString("  ➤ Enter desired Username: ");
        String passwordPlayer = getValidString("  ➤ Enter secure Password: ");
        
        for (Player p: data.getGameAllPlayers()) {
            if (p.getPlayerName().equals(namePlayer) && p.getPassword().equals(passwordPlayer)) {
                System.out.println("\n  ⚠️ [ERROR] These credentials are already linked to an existing commander!");
            }
        }
        Player player = new Player(namePlayer, passwordPlayer, data);
        data.addPlayer(player);
        System.out.println("\n  ✅ [SUCCESS] Account created successfully. Welcome to the shadows!\n");
    }
    
    public static void loginOperation(GameData data) {
        System.out.println("\n  🔑 --- SECURE LOGIN ---");
        String namePlayer = getValidString("  ➤ Enter Username: ");
        String passwordPlayer = getValidString("  ➤ Enter Password: ");
        boolean loggedIn = true;
        for (Player p: data.getGameAllPlayers()) {
            if (p.getPlayerName().equals(namePlayer) && p.getPassword().equals(passwordPlayer)) {
                loggedInOperation(p, data);
                loggedIn = false;
                
            }
        }
        if (loggedIn) {
            System.out.println("\n  ❌ [ERROR] Authentication failed. Invalid Username or Password.\n");
        }
        
        
    }
    
    public static void loggedInOperation(Player player, GameData data) {
        
        while (true) {
            printMainMenu(player);
            int choice = getValidInt("  ➤ Select an option: ", 1, 5);
            
            switch(choice) {
                case 1:
                    
                    playWorldOperation(player);
                    break;
                
                case 2:
                    createWorldOperation(player);
                    break;
                
                case 3:
                    shopHeroOperation(data, player);
                    break;
                    
                case 4:
                    shopMapOperation();
                    break;
                    
                case 5:
                    return;
                    
                default:            
            }

        }
    }
}