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
    public static void printUseItem(Hero hero, ItemType type) {

        switch(type) {
            case MINOR_HP_POTION:
                System.out.printf("🧪 %s used HP Potion ❤️ +%d\n", 
                    hero.getName(), 50);
                break;

            case MANA_POTION:
                System.out.printf("🔮 %s used Mana Potion 💙 +%d\n", 
                    hero.getName(), 30);
                break;

            case SHIELD_SCROLL:
                System.out.printf("🛡️ %s used Shield! 🚫 Next hit blocked\n", 
                    hero.getName());
                break;

            case ELIXIR_OF_POWER:
                System.out.printf("⚡ %s used Power Elixir! 💥 ATK ↑\n", 
                    hero.getName());
                break;

            default:
                System.out.println("❓ Unknown item...");
        }
    }
    
    public static void printRewardHero(Hero hero, int gold, int exp) {
        System.out.printf("💰 +%d Gold | ✨ +%d EXP\n", gold, exp);
    }
    
    public static void printItemGained(Item item) {
        if (item == null) {
            System.out.println("GOT AN UNKNOWN ITEM (REPORT A BUG)");
        }
        System.out.printf("🎁 +1 %s\n", item.getItemName().toUpperCase());
    }
}