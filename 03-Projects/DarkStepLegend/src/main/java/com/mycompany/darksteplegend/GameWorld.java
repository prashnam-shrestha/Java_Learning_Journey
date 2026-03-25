package com.mycompany.darksteplegend;

import com.mycompany.darksteplegend.Enemy;
import com.mycompany.darksteplegend.FightResult;
import com.mycompany.darksteplegend.PhaseType;
import static com.mycompany.darksteplegend.GameLogger.*;
import static com.mycompany.darksteplegend.InputHelper.getValidInt;
import static com.mycompany.darksteplegend.MenuPrinter.printHeroBattleMenu;
import java.io.Serializable;

public class GameWorld implements Serializable{
    
    private String gameWorldName;
    private Map map;
    private Hero hero;
    PhaseType playingPhase; 
    private GameWorldType gameWorldType;

    public GameWorld(Map map, Hero hero, GameWorldType gameWorldType, String name) {
        setMap(map);
        setHero(hero);
        setGameWorldType(gameWorldType);
        setGameWorldName(name);
        playingPhase = map.getCurrentPhase();
    }

    // METHODS

    public void exploreWorld() {
        
        boolean showStatus = true;;
        System.out.println("\n  ⚔️  ================ EXPEDITION BEGINS ================ ⚔️\n");
        
        while (true) {
            
            if (map.checkMapProgression()) {

                // RESET
                map.resetAllEnemies();
                hero.setCurrentHp(hero.getMaxHp());

                System.out.println("\n  🌟 ================= AREA CLEARED ================= 🌟");
                System.out.println("  Congratulations! You have purged all threats in this sector.");
                System.out.println("  🔄 World state reset for next expedition.\n");
                return;
            }
            
            if (map.getCurrentPhase() != playingPhase) {
                
                System.out.printf("\n  ⏳ [TRANSITION] Approaching new environment tier: %s...\n", map.getCurrentPhase());
                playingPhase = map.getCurrentPhase();
                System.out.println("  🗺️  Generating terrain layout...");
                pause(3000);
            }

            System.out.printf("\n  📍 CURRENT SECTOR: %s\n", map.getCurrentPhase());


            
            Enemy enemy = map.getEnemyFromPhase();

            if (showStatus) {
                System.out.println("\n  ⚠️  A WILD ENEMY MATERIALIZES!");
                System.out.printf("  👾 TARGET DETECTED: %s\n", enemy.getStatus());
                printHeroBattleMenu();
                showStatus = false;
            }

            switch (this.simulateFight(enemy)) {

                case (FightResult.WIN):
                    
                    hero.setCurrentHp(hero.getMaxHp());
                    hero.setIsAlive(true);
                    hero.rewardHero(enemy, map);
                    hero.checkLevelUp();
                    System.out.println("\n  🏆 [VICTORY] Area secured. Health fully restored.\n");
                    return;

                case (FightResult.LOOSE):
                    
                    if (gameWorldType == GameWorldType.EASY) {
                        hero.setCurrentHp(hero.getMaxHp());
                        hero.setIsAlive(true);
                        System.out.println("\n  🩹 [RESCUED] You suffered a fatal blow, but Easy Mode engaged! Health fully restored.\n");
            
                        
                    } else if (gameWorldType == GameWorldType.HARD) {
                        
                        System.out.println("\n  💀 [DEFEAT] You have fallen. Hard Mode penalty: ALL PROGRESS PURGED.\n");
                        hero.resetStatus();
                        map.resetAllEnemies();
            
                    }
                    return;

                case (FightResult.RUNAWAY):
                    int gold = hero.getGold();
                    double goldLost = (double) gold * 0.2;
                    hero.setGold(gold - (int) goldLost);

                    System.out.println("\n  💨 [FLED] You barely managed to escape with your life...");
                    System.out.printf("  📉 PENALTY: %s Gold scattered during the retreat.\n", goldLost);
                    return;

                case (FightResult.CONTINUEFIGHT):
                    break;

                default:
            }
        }
    }

    public FightResult simulateFight(Enemy enemy) {

        AttackType type;
        type = enemy.attack(hero);
//        pause(500);
        
        // Clean, single-line turn separator
        System.out.println("\n  📊 ================= BATTLE STATS ================= 📊");
        System.out.printf("   👾 ENEMY : %s\n", enemy.getMiniStatus());
        System.out.printf("   🛡️ HERO  : %s\n", hero.getMiniStatus());
        System.out.println("  ──────────────────────────────────────────────────────");
        

        System.out.println("\n  🛑 --- ENEMY'S TURN ---");
//        pause(2000);
        printAttack(enemy, hero, type, true);
        
        if (!hero.isIsAlive()) {
            printDeath(hero, enemy);
            return FightResult.LOOSE;
            
        }

//        pause(1000); 
         // Print menu right before asking for input


        boolean success;
                System.out.println("\n  🟢 --- YOUR TURN ---");

                // ADD THIS DO-WHILE LOOP
                do {
                    int choice = getValidInt("  ➤ Select Combat Action: ", 1, 5);
                    success = true; // Assume success unless a skill fails

                    switch (choice) {
                        case 1:
                            success = hero.attack(enemy);
                            printAttack(hero, enemy, AttackType.PASSIVE, success);
                            break;
                        case 2:
                            success = hero.attack(enemy, AttackType.SKILL2);
                            printAttack(hero, enemy, AttackType.SKILL2, success);
                            break;
                        case 3:
                            success = hero.attack(enemy, AttackType.ULTIMATE);
                            printAttack(hero, enemy, AttackType.ULTIMATE, success);
                            break;
                        case 4:
                            int size = hero.getInventory().size();
                            if (size <= 0) {
                                System.out.println("\n  ⚠️ [EMPTY] Your backpack is completely bare. Choose another action!");
                                success = false; // Force them to pick again!
                                break;
                            }
                            hero.showInventory();
                            int itemIndex = getValidInt("  ➤ Select Item to consume: ", 1, size) - 1;
                            Item item = hero.getInventory().get(itemIndex);
                            hero.useItem(item);
                            printUseItem(hero, item.getItemType());
                            hero.removeItem(item);
                            break;
                        case 5:
                            System.out.println("\n  ➤ Attempting emergency retreat...\n");
                            return FightResult.RUNAWAY;
                        default:
                            break;
                    }

                    // If success is false (not enough mana, empty inventory), loop again!
                } while (!success);

//        pause(1000); 

        if (!enemy.isIsAlive()) {
            hero.setEnemiesKilled(hero.getEnemiesKilled() + 1);
            printDeath(enemy, hero);
            return FightResult.WIN;
            
        } else {
            return FightResult.CONTINUEFIGHT;
        }
    }

    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
    }

    // GETTERS AND SETTERS
    public Map getMap() { return map; }
    public void setMap(Map map) { this.map = map; }
    public Hero getHero() { return hero; }
    public void setHero(Hero hero) { this.hero = hero; }
    public GameWorldType getGameWorldType() { return gameWorldType; }
    public void setGameWorldType(GameWorldType gameWorldType) { this.gameWorldType = gameWorldType; }

    public String getGameWorldName() {
        return gameWorldName;
    }

    public void setGameWorldName(String gameWorldName) {
        this.gameWorldName = gameWorldName;
    }
    
}