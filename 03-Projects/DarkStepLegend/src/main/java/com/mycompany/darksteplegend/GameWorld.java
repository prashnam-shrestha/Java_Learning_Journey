package com.mycompany.darksteplegend;

import com.mycompany.darksteplegend.Enemy;
import com.mycompany.darksteplegend.FightResult;
import com.mycompany.darksteplegend.PhaseType;
import static com.mycompany.darksteplegend.GameLogger.*;
import static com.mycompany.darksteplegend.InputHelper.getValidInt;
import static com.mycompany.darksteplegend.MenuPrinter.printHeroBattleMenu;

public class GameWorld {
    
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
        System.out.println("\n⚔ === BATTLE COMMENCES === ⚔\n");
        
        while (true) {
            
            if (map.checkMapProgression()) {

                // RESET
                map.resetAllEnemies();
                hero.setCurrentHp(hero.getMaxHp());

                System.out.println("\n✨ === AREA CLEARED === ✨\n");
                System.out.println("\n✨ === WORLD RESET === ✨\n");
                return;
            }
            
            if (map.getCurrentPhase() != playingPhase) {
                
                System.out.printf("NEW PHASE UPCOMMING: %s\n", map.getCurrentPhase());
                playingPhase = map.getCurrentPhase();
                System.out.println("MAP LOADING....");
                pause(3000);
            }

            System.out.printf("PHASE PLAYING : %s\n", map.getCurrentPhase());


            
            Enemy enemy = map.getEnemyFromPhase();

            if (showStatus) {
                System.out.println("⚠️ ENEMY APPROACHES!");
                System.out.printf("➤ SPAWNED: %s\n", enemy.getStatus());
                printHeroBattleMenu();
                showStatus = false;
            }

            switch (this.simulateFight(enemy)) {

                case (FightResult.WIN):
                    
                    hero.setCurrentHp(hero.getMaxHp());
                    hero.setIsAlive(true);
                    hero.rewardHero(enemy, map);
                    hero.checkLevelUp();
                    System.out.println("\n✔ VICTORY — HP RESTORED\n");
                    return;

                case (FightResult.LOOSE):
                    
                    if (gameWorldType == GameWorldType.EASY) {
                        hero.setCurrentHp(hero.getMaxHp());
                        hero.setIsAlive(true);
                        System.out.println("\n↻ RECOVERED (EASY MODE)\n");
            
                        
                    } else if (gameWorldType == GameWorldType.HARD) {
                        
                        System.out.println("\n☠ RESETTING PROGRESS (HARD MODE)\n");
                        hero.resetStatus();
                        map.resetAllEnemies();
            
                    }
                    return;

                case (FightResult.RUNAWAY):
                    int gold = hero.getGold();
                    double goldLost = (double) gold * 0.2;
                    hero.setGold(gold - (int) goldLost);

                    System.out.println("\n🏃 ESCAPED...");
                    System.out.printf("💸 GOLD LOST: %s\n", goldLost);
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
        System.out.println("\n──────────────────────────────────────────────────────");
        System.out.printf("👾 ENEMY : %s\n", enemy.getMiniStatus());
        System.out.printf("🛡️ HERO  : %s\n", hero.getMiniStatus());
        System.out.println("──────────────────────────────────────────────────────");
        

        System.out.println("\n[ENEMY ATTACKING]");
//        pause(2000);
        printAttack(enemy, hero, type, true);
        
        if (!hero.isIsAlive()) {
            printDeath(hero, enemy);
            return FightResult.LOOSE;
            
        }

//        pause(1000); 
         // Print menu right before asking for input
        int choice = getValidInt("➤ Select Action: ", 1, 5);

        boolean success;

        System.out.println("\n[HERO ATTACKING]");
//        pause(1000); 

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
                    System.out.println("INVENTORY IS EMPTY");
                    break;
                }
                hero.showInventory();
                int itemIndex = getValidInt("Ente Item no :", 1, size) - 1;
                
                Item item = hero.getInventory().get(itemIndex);
                hero.useItem(item);
                printUseItem(hero, item.getItemType());
                hero.removeItem(item);
                break;
                
                
            case 5:
                System.out.println("   ➤ RUN ATTEMPT...\n");
                return FightResult.RUNAWAY;     

            default:
                break;
        }

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