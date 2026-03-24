/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.darksteplegend;

import static com.mycompany.darksteplegend.GameLogger.*;
import static com.mycompany.darksteplegend.InputHelper.getValidInt;
import static com.mycompany.darksteplegend.InputHelper.getValidString;
import static com.mycompany.darksteplegend.MenuPrinter.printHeroMainMenu;
import static com.mycompany.darksteplegend.MenuPrinter.printMainMenu;

/**
 *
 * @author prashnamshrestha
 */
public class DarkStepLegend {

    public static void main(String[] args) {
        //  name,  maxHp,  gold,  passiveDmg,  skill2Dmg,  ultimateDmg,  type
        
        GameData data = new GameData();
        Map map = new Map("JUNGLE", data);
        Hero mage = new Hero("Mage", 250, 0, 400, 20, 30);
        GameWorld world = new GameWorld(map, mage, GameWorldType.EASY,  "JUNGLE");
        
        Player player = new Player("Prashnam");
        player.addPlayerWorld(world);
        player.addPlayerHero(mage);
        player.addPlayerMap(map);
        
        
        
        
        while (true) {
            printMainMenu();
            int choice = getValidInt("Enter choice: ", 1, 5);
            
            switch(choice) {
                case 1:
                    
                    playWorldOperation(player);
                    break;
                
                case 2:
                    createWorldOperation(player);
                    break;
                
                case 3:
                    shopHeroOperation();
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
    
    public static void playWorldOperation(Player player) {
        int i = 1;
        int choice;
        int worldCount = player.getPlayerWorlds().size();
        if (worldCount <= 0) {
            return;
        }
        for (GameWorld w: player.getPlayerWorlds()) {
            System.out.printf("%s. Name: %s | Mode: %s\n", i, w.getGameWorldName(), w.getGameWorldType());
            i++;
        }
        
        choice = getValidInt("Enter World Number: ", 1, worldCount) - 1;
        GameWorld gameWorld = player.getPlayerWorlds().get(choice);
        
        while (true) {
            
            printHeroMainMenu();
            choice = getValidInt("Enter choice: ", 1, 4);

            switch(choice) {
                case 1: 
                    gameWorld.exploreWorld();
                    break;
                case 2:
                    System.out.println("Feature incomming");
                    break;
                case 3:
                    System.out.println("Feature incomming");
                    break;
                case 4:
                    return;

                default:

            }
        }

    }
    
    public static void createWorldOperation(Player player) {
        String name = getValidString("Enter world name: ");
        System.out.println("---- Select Difficulty -----");
        System.out.println("1. EASY");
        System.out.println("2. HARD");
        int difficulty = getValidInt("Enter choice: ", 1, 2);
        
        int i = 1;
        for (Hero hero: player.getPlayerHeroes()) {
            
            System.out.printf("%s. ", i);
            System.out.println(hero.getStatus());
            i++;
        }
        int heroIndex = getValidInt("Enter choice: ", 1, player.getPlayerHeroes().size()) - 1;
        
        i = 1;
        for (Map map: player.getPlayerMaps()) {
            
            System.out.printf("%s. ", i);
            System.out.println(map.getMapName());
            i++;
        }
        int mapIndex = getValidInt("Enter choice: ", 1, player.getPlayerMaps().size()) - 1;
        GameWorld newWorld;
        
        if (difficulty == 1) {
            newWorld = new GameWorld(player.getPlayerMaps().get(mapIndex), player.getPlayerHeroes().get(heroIndex), 
                        GameWorldType.EASY, name);
        }
        else {
            newWorld = new GameWorld(player.getPlayerMaps().get(mapIndex), player.getPlayerHeroes().get(heroIndex), 
                        GameWorldType.HARD, name);
        }
        
        player.addPlayerWorld(newWorld);
        
    }
    
    public static void shopHeroOperation() {
        System.out.println("Feature incomming");
    }
    
    public static void shopMapOperation() {
        System.out.println("Feature incomming");
    }
}
