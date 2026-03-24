/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.darksteplegend;

import static com.mycompany.darksteplegend.GameLogger.*;
import static com.mycompany.darksteplegend.InputHelper.getValidInt;
import static com.mycompany.darksteplegend.InputHelper.getValidString;

import static com.mycompany.darksteplegend.MenuPrinter.*;

/**
 *
 * @author prashnamshrestha
 */
public class DarkStepLegend {

    public static void main(String[] args) {
        //  name,  maxHp,  gold,  passiveDmg,  skill2Dmg,  ultimateDmg,  type
        
        GameData data = new GameData();
        while (true) {
            printLoginRegister();
            
            int choice = getValidInt("Enter choice: ", 1, 3);
            
            switch(choice) {
                case 1:
                    loginOperation(data);
                    break;
                case 2:
                    registerOperation(data);
                    break;
                case 3:
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
            System.out.println("NO WORLDS CREATED!\n Create one to play.");
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
                    gameWorld.getHero().showInventory();
                    break;
                  
                case 3:
                    player.depositGold(gameWorld.getHero().getGold());
                    gameWorld.getHero().setGold(0);
                    System.out.println("EXITING GAME WORLD....");
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
        
        System.out.println("Pick an unlocked Hero:");
        int i = 1;
        for (Hero hero: player.getPlayerHeroes()) {
            
            System.out.printf("%s. ", i);
            System.out.println(hero.getStatus());
            i++;
        }
        int heroIndex = getValidInt("Enter choice: ", 1, player.getPlayerHeroes().size()) - 1;
        
        System.out.println("Pick an unlocked Map:");
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
    
    public static void shopHeroOperation(GameData data, Player player) {
        
        System.out.println("======= SHOP HEROS =======");
        int i = 1;
        for (Hero hero: data.getGameAllHeroes()) {
            System.out.printf("%s. MAX HP: %s | PASSIVE: %s | SKILL 2: %s | ULTIMATE: %s |PRICE: 200 GOLD🌟 | NAME: %s |\n", i,
                                hero.getMaxHp(), hero.getPassiveDmg(), hero.getSkill2Dmg(), hero.getUltimateDmg(),  hero.getName());
            i++;

        }
        int heroIndex = getValidInt("Enter Hero No:", 1, data.getGameAllHeroes().size()) - 1;
        if (player.getPlayerGold() < 200) {
            System.out.println("NOT ENOUGH GOLD TO PURCHASE HERO\n Maybe collect some?");
            return;
        }
        player.addPlayerHero(data.getHeroFromData(heroIndex));
        
        player.withdrawGold(200);
        
        System.out.println("SUCCESSFULLY PURCHASED HERO | -200 GOLD🌟");
               
    }
    
    public static void shopMapOperation() {
        System.out.println("Feature incomming");
    }
    public static void registerOperation(GameData data) {
        String namePlayer = getValidString("Enter New Name:");
        String passwordPlayer = getValidString("Enter New Password:");
        
        for (Player p: data.getGameAllPlayers()) {
            if (p.getPlayerName().equals(namePlayer) && p.getPassword().equals(passwordPlayer)) {
                System.out.println("ID and PASSWORD linked with another account!");
            }
        }
        Player player = new Player(namePlayer, passwordPlayer, data);
        data.addPlayer(player);
        System.out.println("REGISTER SUCCESSFULL");
    }
    
    public static void loginOperation(GameData data) {
        String namePlayer = getValidString("Enter Name:");
        String passwordPlayer = getValidString("Enter Password:");
        
        for (Player p: data.getGameAllPlayers()) {
            if (p.getPlayerName().equals(namePlayer) && p.getPassword().equals(passwordPlayer)) {
                loggedInOperation(p, data);
            }
        }
        System.out.println("ID not found!");
        
    }
    
    public static void loggedInOperation(Player player, GameData data) {
        
        while (true) {
            printMainMenu(player);
            int choice = getValidInt("Enter choice: ", 1, 5);
            
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
