/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

/**
 *
 * @author prashnamshrestha
 */
public class GameLogger {
   
    public static void printAttack(Character who, Character target, AttackType type, boolean success) {
        
        if (!success) {
            Hero hero = (Hero) who;
            int mana = hero.getMana();
            
            if (type == AttackType.SKILL2) {
                System.out.printf("Need %s more mana to use SKILL 2.\n", 20 - mana);
                return;
            }
           System.out.printf("Need %s more mana to use ULTIMATE.\n", 30 - mana);
           return;
        }

        switch (type) {
            
            case PASSIVE:
                System.out.printf("%s slashes %s for %s!", who.getName(), target.getName(), who.getPassiveDmg());
                break;

            case SKILL2:
                System.out.printf("%s strikes %s! -%s HP", who.getName(), target.getName(), who.getSkill2Dmg());
                break;

            default:
                System.out.printf("%s lands a hit! %s takes %s", who.getName(), target.getName(), who.getUltimateDmg());
                break;
        }
        System.out.println();
    }
        
}