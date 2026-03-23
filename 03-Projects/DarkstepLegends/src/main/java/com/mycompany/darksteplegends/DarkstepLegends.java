package com.mycompany.darksteplegends;

import static com.mycompany.darksteplegend.InputHelper.*;
import static com.mycompany.darksteplegends.MenuPrinter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DarkstepLegends {

    public static void main(String[] args) {
        
        Player prashnam = new Player("Prashnam");
        boolean run = true;
        
        while (run) {
            World world;
            final Hero hero;
            
            displayMainMenu();
            int choice = getValidInt("Enter choice: ", 1, 5);
            
            switch (choice) {
                case 1:
                    int i = 1;
                    System.out.println("\n🌍 --- SELECT A WORLD --- 🌍");
                    for (World w: prashnam.getUnlockedWorlds()) {
                        System.out.print("  " + i + ". ");
                        System.out.println(w.getName());
                        i++;
                    }
                    i = 1;
                    
                    int indexWorld = getValidInt("Enter choice: ", 1, prashnam.getUnlockedWorlds().size()) - 1;
                    world = prashnam.getUnlockedWorlds().get(indexWorld);
                    
                    System.out.println("\n🦸 --- SELECT A HERO --- 🦸");
                    for (Hero h: prashnam.getUnlockedHeros()) {
                        System.out.print("  " + i + ". ");
                        h.showDetails();
                        i++;
                    }
                    int indexHero = getValidInt("Enter choice: ", 1, prashnam.getUnlockedHeros().size()) - 1;
                    hero = prashnam.getUnlockedHeros().get(indexHero);
                    
                    play(hero, world, prashnam);
                    break;
                    
                case 2:
                    System.out.println("\n🚧 [UNDER CONSTRUCTION] Hero Shop coming soon!");
                    break;
                case 3:
                    System.out.println("\n🚧 [UNDER CONSTRUCTION] World Unlocks coming soon!");
                    break;
                case 4:
                    System.out.println("\n🚧 [UNDER CONSTRUCTION] Guidebook coming soon!");
                    break;
                case 5:
                    System.out.println("\n👋 Exiting Darkstep Legends. Farewell, hero!");
                    run = false;
                    break;
            }
        }
    }
    
    public static void play(Hero hero, World world, Player player) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.printf("║ 🗺️  ENTERING: %-33s ║\n", world.getName().toUpperCase());
        System.out.println("╚════════════════════════════════════════════════╝");
        
        boolean isPlaying = true;
        while (isPlaying) {
            displayHeroMenu(player, world);
            int choice = getValidInt("Enter choice: ", 1, 4);
            
            switch (choice) {
                case 1:
                    System.out.println("\n🚶 Exploring deeper into the shadows...");
                    Enemy enemy = world.getEnemies().get(world.getPhase() - 1);
                    
                    System.out.printf("\n⚔️ --- PHASE %s --- ⚔️\n", world.getPhase());
                    int result = action(enemy, hero, player);
                    
                    if (result == 1) {
                        System.out.println("\n🎉 [VICTORY] You defeated " + enemy.getName() + "!");
                        hero.rewardWinner(enemy);
                        
                        if (!world.increasePhase()) {
                            isPlaying = false; 
                        }
                    } else if (result == 2) {
                        System.out.println("\n💀 [GAME OVER] " + hero.getName() + " has fallen in battle.");
                        world.resetWorld();
                        isPlaying = false;
                    } else if (result == 3) {
                        System.out.println("\n🏃 [RETREAT] You fled from the battle!");
                    }
                    break;
                case 2:
                    System.out.println("\n🏕️  You set up camp and rest. (Healing logic TODO)");
                    break;
                case 3:
                    if (!hero.showInventory()) {
                        System.out.println("\n🎒 [INVENTORY] Your bag is empty!");
                    }
                    break;
                case 4:
                    System.out.println("\n🚪 Retreating to Main Menu...");
                    isPlaying = false;
                    break;
            }
        }
    }
    
    public static int action(Enemy enemy, Hero hero, Player player) {
        System.out.printf("\n⚠️  [SPAWN] %s appeared! (HP: %s)\n", enemy.getName(), enemy.getHp());
        
        while (true) {
            if (!enemy.isIsAlive()) return 1; 
            
            enemy.passiveAttack(hero);
            if (!hero.isIsAlive()) return 2; 
            
            displayFightAct(hero, enemy);
            int choice = getValidInt("Enter choice: ", 1, 4);

            switch (choice) {
                case 1:
                    hero.passiveAttack(enemy);
                    break;
                case 2:
                    hero.useUltimate(enemy);
                    break;
                case 3:
                    if (!hero.showInventory()) {
                        System.out.println("\n🎒 [INVENTORY] Your bag is empty!");
                    } else {
                        int indexItem = getValidInt("Enter item number: ", 1, hero.getInventory().size()) - 1;
                        hero.useItem(indexItem, enemy);
                    }
                    break;
                case 4:
                    return 3; 
                default:
                    break;
            } 
        }
    }
    
    public static World createWorldDesert() {
        World world = new World("Desert of illusions", 100);
        
        Enemy miniGoblin = new Enemy("Mini Goblin", 50, 20, 0);
        Enemy boneWitch = new Enemy("Bone Witch", 70, 100, 15);
        Enemy shadowHound = new Enemy("Shadow Hound", 110, 35, 20);
        Enemy ironGoblin = new Enemy("Iron Goblin", 130, 30, 10);
        Enemy kingsSlayer = new Enemy("Kings Slayer", 180, 45, 30);
        Enemy xavier = new Enemy("Xavier", 120, 70, 50);
        Enemy goblinWarlord = new Enemy("Goblin Warlord", 350, 65, 40);
        Enemy shadowEmperor = new Enemy("Shadow Emperor", 900, 90, 100);
        
        world.addEnemy(miniGoblin);
        world.addEnemy(boneWitch);
        world.addEnemy(shadowHound);
        world.addEnemy(ironGoblin);
        world.addEnemy(kingsSlayer);
        world.addEnemy(xavier);
        world.addEnemy(goblinWarlord);
        world.addEnemy(shadowEmperor);
 
        Item healer = new Item("Health Potion", ItemType.HEALER, 70);
        Item poison = new Item("Poison Flask", ItemType.POISON, 40);
        Item shield = new Item("Iron Shield", ItemType.SHIELD, 0);
        
        miniGoblin.addItemInventory(healer);
        kingsSlayer.addItemInventory(poison);
        ironGoblin.addItemInventory(shield);
        
        return world;
    }
}