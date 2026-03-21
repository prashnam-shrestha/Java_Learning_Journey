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
        Enemy Goblin = new Enemy("Goblin", 500, 20, 10, 20, 30, EnemyType.EASY);
        
        Hero mage = new Hero("Mage", 250, 0, 10, 20, 30);
        
        mage.attack(Goblin);
        printAttack(mage, Goblin, AttackType.PASSIVE);
        
        mage.attack(Goblin, AttackType.SKILL2);
        printAttack(mage, Goblin, AttackType.SKILL2);
        
        mage.attack(Goblin, AttackType.ULTIMATE);
        printAttack(mage, Goblin, AttackType.ULTIMATE);
        
        AttackType type;
        
        type = Goblin.attack(mage);
        printAttack(Goblin, mage, type);
        
        type = Goblin.attack(mage);
        printAttack(Goblin, mage, type);
        
        type = Goblin.attack(mage);
        printAttack(Goblin, mage, type);
        
        type = Goblin.attack(mage);
        printAttack(Goblin, mage, type);
        
    }
}
