package com.mycompany.darksteplegend;

public class GameLogger {
   
    public static void printAttack(Character who, Character target, AttackType type, boolean success) {
        
        if (!success) {
            Hero hero = (Hero) who;
            int mana = hero.getMana();
            
            if (type == AttackType.SKILL2) {
                System.out.printf("   ⚠️ Need %s more mana to use SKILL 2.\n", 20 - mana);
                return;
            }
           System.out.printf("   ⚠️ Need %s more mana to use ULTIMATE.\n", 30 - mana);
           return;
        }
        
        int damage;
        
        switch (type) {
            case PASSIVE:
                damage = who.getPassiveDmg();
                System.out.printf("   ➤ %s slashes %s! 💥 [-%s HP]\n", who.getName(), target.getName(), damage);
                break;

            case SKILL2:
                damage = who.getSkill2Dmg();
                System.out.printf("   ✨ %s uses Skill Two on %s! 💥 [-%s HP]\n", who.getName(), target.getName(), damage);
                break;

            default:
                damage = who.getUltimateDmg();
                System.out.printf("   ☄️ %s unleashes Ultimate! %s takes a massive hit! 💥 [-%s HP]\n", who.getName(), target.getName(), damage);
                break;
        }
    }
    
    public static void printDeath(Character died, Character killed) {
        if (died instanceof Hero) {
            System.out.println("\n💀 YOU HAVE BEEN DEFEATED... TRY AGAIN.");
        } else {
            System.out.printf("\n⚔️ %s HAS BEEN SLAIN!\n", died.getName().toUpperCase());
        }
    }
}