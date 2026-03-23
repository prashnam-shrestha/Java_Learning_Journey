package com.mycompany.darksteplegend;

import static com.mycompany.darksteplegend.GameLogger.*;
import static com.mycompany.darksteplegend.InputHelper.getValidInt;
import static com.mycompany.darksteplegend.MenuPrinter.printHeroBattleMenu;

public class GameWorld {
    private Map map;
    private Hero hero;
    private GameWorldType gameWorldType;

    public GameWorld(Map map, Hero hero, GameWorldType gameWorldType) {
        setMap(map);
        setHero(hero);
        setGameWorldType(gameWorldType);
    }

    // METHODS

    public void playGame() {
        boolean showStatus = true;
        hero.setCurrentHp(40);
        System.out.println("\n⚔ === BATTLE COMMENCES === ⚔\n");

        while (true) {
            if (map.checkMapProgression()) {

                // RESET
                map.resetAllEnemies();
                hero.setCurrentHp(hero.getMaxHp());

                System.out.println("\n✨ === AREA CLEARED === ✨\n");
                return;
            }

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
                    System.out.println("\n✔ VICTORY — HP RESTORED\n");
                    break;

                case (FightResult.LOOSE):
                    if (gameWorldType == GameWorldType.EASY) {
                        hero.setCurrentHp(hero.getMaxHp());
                        System.out.println("\n↻ RECOVERED (EASY MODE)\n");
                        return;
                        
                    } else if (gameWorldType == GameWorldType.HARD) {
                        System.out.println("\n☠ RESETTING PROGRESS (HARD MODE)\n");
                        hero.resetStatus();
                        map.resetAllEnemies();
                        return;
                    }
                    break;

                case (FightResult.RUNAWAY):
                    int gold = hero.getGold();
                    hero.setGold(gold - (20 / 100 * gold));

                    System.out.println("\n🏃 ESCAPED...");
                    System.out.println("💸 GOLD LOST\n");
                    break;

                case (FightResult.CONTINUEFIGHT):
                    break;

                default:
            }
        }
    }

    public FightResult simulateFight(Enemy enemy) {

        AttackType type;
        type = enemy.attack(hero);
        pause(500);
        
        // Clean, single-line turn separator
        System.out.println("\n──────────────────────────────────────────────────────");
        System.out.printf("👾 ENEMY : %s\n", enemy.getMiniStatus());
        System.out.printf("🛡️ HERO  : %s\n", hero.getMiniStatus());
        System.out.println("──────────────────────────────────────────────────────");
        

        System.out.println("\n[ENEMY ATTACKING]");
        pause(1000);
        printAttack(enemy, hero, type, true);
        
        if (!hero.isIsAlive()) {
            printDeath(hero, enemy);
            return FightResult.LOOSE;
            
        }

        pause(1000); 
         // Print menu right before asking for input
        int choice = getValidInt("➤ Select Action: ", 1, 4);

        boolean success;

        System.out.println("\n[HERO ATTACKING]");
        pause(1000); 

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
                System.out.println("   ➤ RUN ATTEMPT...\n");
                return FightResult.RUNAWAY;

            default:
                break;
        }

        pause(1000); 

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
}