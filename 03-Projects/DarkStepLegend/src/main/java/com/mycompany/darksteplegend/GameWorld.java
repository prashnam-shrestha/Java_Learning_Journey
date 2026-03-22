/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

import static com.mycompany.darksteplegend.GameLogger.printAttack;

/**
 *
 * @author prashnamshrestha
 */
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
        
       Enemy enemy = map.getEnemyFromPhase();
       
        System.out.println(enemy.getStatus());
      
       
       while (true) {
           
        if (!enemy.isIsAlive()) {
           break;
        }
        else if (!hero.isIsAlive()) {
            hero.resetStatus();
           break;
        }
           
          simulateFight(enemy); 
       }
    }
    
    public void simulateFight(Enemy enemy) {
        

        // DEMO
        AttackType type;
        System.out.println("=========== FIGHT =============");
        type = enemy.attack(hero);
        printAttack(enemy, hero, type, true);

        // HERO passive attack
        boolean success;
        success = hero.attack(enemy);
        printAttack(hero, enemy, AttackType.PASSIVE, success);

        success = hero.attack(enemy, AttackType.SKILL2);
        printAttack(hero, enemy, AttackType.SKILL2, success);

        success = hero.attack(enemy, AttackType.ULTIMATE);
        printAttack(hero, enemy, AttackType.ULTIMATE, success); 

        System.out.println("");
        System.out.println(hero.getStatus());
        System.out.println(enemy.getStatus());
        System.out.println("");

        System.out.println("=========== END ===============\n");
        
  
    }
    

    // GETTERS AND SETTERS
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public GameWorldType getGameWorldType() {
        return gameWorldType;
    }

    public void setGameWorldType(GameWorldType gameWorldType) {
        this.gameWorldType = gameWorldType;
    }
    
    
}
