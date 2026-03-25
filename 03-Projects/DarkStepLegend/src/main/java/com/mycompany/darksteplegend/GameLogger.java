package com.mycompany.darksteplegend;

import java.io.Serializable;

public class GameLogger implements Serializable{
   
    public static void printAttack(Character who, Character target, AttackType type, boolean success) {
        
        if (!success) {
            Hero hero = (Hero) who;
            int mana = hero.getMana();
            
            if (type == AttackType.SKILL2) {
                System.out.printf("    ⚠️ [FAILED] Insufficient energy! You need %s more MP to cast ✨ Skill 2.\n", 20 - mana);
                return;
            }
           System.out.printf("    ⚠️ [FAILED] Insufficient energy! You need %s more MP to channel ☄️ ULTIMATE.\n", 30 - mana);
           return;
        }
        
        int damage;
        
        switch (type) {
            case PASSIVE:
                damage = who.getPassiveDmg();
                System.out.printf("    ➤ ⚔️  %s executes a swift strike on %s! 💥 [-%s HP]\n", who.getName(), target.getName(), damage);
                break;

            case SKILL2:
                damage = who.getSkill2Dmg();
                System.out.printf("    ➤ ✨  %s casts Skill Two on %s! 💥 [-%s HP]\n", who.getName(), target.getName(), damage);
                break;

            default:
                damage = who.getUltimateDmg();
                System.out.printf("    ➤ ☄️  %s unleashes their devastating Ultimate! %s is decimated! 💥 [-%s HP]\n", who.getName(), target.getName(), damage);
                break;
        }
    }
    
    public static void printDeath(Character died, Character killed) {
        if (died instanceof Hero) {
            System.out.println("\n  💀 YOU HAVE BEEN SLAUGHTERED... The darkness claims another soul.");
        } else {
            System.out.printf("\n  ⚔️  [ELIMINATED] %s HAS BEEN REDUCED TO DUST!\n", died.getName().toUpperCase());
        }
    }
    public static void printUseItem(Hero hero, ItemType type) {

        switch(type) {
            case MINOR_HP_POTION:
                System.out.printf("    🧪 %s hastily drinks a Health Potion! ❤️ +%d HP Restored.\n", 
                    hero.getName(), 50);
                break;

            case MANA_POTION:
                System.out.printf("    🔮 %s channels a Mana Potion! 💧 +%d MP Restored.\n", 
                    hero.getName(), 30);
                break;

            case SHIELD_SCROLL:
                System.out.printf("    🛡️ %s reads an ancient Shield Scroll! 🚫 Next incoming attack will be completely negated.\n", 
                    hero.getName());
                break;

            case ELIXIR_OF_POWER:
                System.out.printf("    ⚡ %s consumes the forbidden Power Elixir! 💥 Base Attack permanently enhanced!\n", 
                    hero.getName());
                break;

            default:
                System.out.println("    ❓ A mysterious artifact was triggered...");
        }
    }
    
    public static void printRewardHero(Hero hero, int gold, int exp) {
        System.out.printf("  🎁 [SPOILS OF WAR] Acquired: 💰 +%d Gold | ✨ +%d EXP\n", gold, exp);
    }
    
    public static void printItemGained(Item item) {
        if (item == null) {
            System.out.println("  ⚠️ [GLITCH DETECTED] An unknown relic dropped into the void. (Report Bug)");
        }
        System.out.printf("  🎒 [LOOT FOUND] Picked up: %s\n", item.getItemName().toUpperCase());
    }
}