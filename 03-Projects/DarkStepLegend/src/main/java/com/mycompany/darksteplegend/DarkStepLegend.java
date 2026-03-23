/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.darksteplegend;

import static com.mycompany.darksteplegend.GameLogger.*;

/**
 *
 * @author prashnamshrestha
 */
public class DarkStepLegend {

    public static void main(String[] args) {
        //  name,  maxHp,  gold,  passiveDmg,  skill2Dmg,  ultimateDmg,  type
//        Enemy Goblin = new Enemy("Goblin", 500, 20, 10, 20, 30, EnemyType.MEDIUM); // Enemy type can be EnemyType.EASY, EnemyType.MEDIUM, EnemyType.HARD
//        
        Hero mage = new Hero("Mage", 250, 0, 10, 20, 30);
        
        GameData data = new GameData();
        Map map = new Map("JUNGLE", data);
        
        GameWorld gameWorld = new GameWorld(map, mage, GameWorldType.EASY);
        gameWorld.playGame();
        
        
//        // HERO passive attack
//        boolean success;
//        success = mage.attack(Goblin);
//        printAttack(mage, Goblin, AttackType.PASSIVE, success);
//           
//        // HERO Skill 2 attack
//        success = mage.attack(Goblin, AttackType.SKILL2);
//        printAttack(mage, Goblin, AttackType.SKILL2, success);
//        
//        // HERO Ultimate attack
//        success = mage.attack(Goblin, AttackType.ULTIMATE);
//        printAttack(mage, Goblin, AttackType.ULTIMATE, success);
//        
//        AttackType type;
//        
//        type = Goblin.attack(mage);
//        printAttack(Goblin, mage, type, true);
//        
//        type = Goblin.attack(mage);
//        printAttack(Goblin, mage, type, true);
//        
//        type = Goblin.attack(mage);
//        printAttack(Goblin, mage, type, true);
//        
//        type = Goblin.attack(mage);
//        printAttack(Goblin, mage, type,true);
//        
//        System.out.println(mage.getStatus());
//        System.out.println(Goblin.getStatus());

             
          
          
    }
}
