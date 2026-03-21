package com.mycompany.darksteplegends;

public class Hero extends Character {
    
    private int mana;
    private int level;
    private boolean shieldOn;
    
    public Hero(String name, int hp, int passiveDmg, int ultimateEffect) {
        super(name, hp, passiveDmg, ultimateEffect);
        setLevel(1);
    }
    
    public void showDetails() {
        System.out.printf("%-15s | ❤️  HP: %-4s | 🗡️  DMG: %-4s \n", getName(), getHp(), getPassiveDmg());
    }
    
    @Override
    public void dealtDamage(int dmg) {
        if (shieldOn) {
            System.out.println("🛡️  [DEFLECTED] " + this.getName() + "'s shield absorbed the attack!");
            setShieldOn(false);
            return;
        }
        
        if (isIsAlive()) {
            setHp(getHp() - dmg);
            System.out.println("💥 [HIT] " + this.getName() + " took damage!");
        }
        
        if (this.getHp() <= 0) {
            this.setHp(0);
            this.setIsAlive(false);
            System.out.println("☠️  [FATAL] " + this.getName() + " died!");
        }
    }
    
    public void passiveAttack(Character target)  {
        if (!this.isIsAlive()) return;
        target.dealtDamage(this.getPassiveDmg());
        System.out.printf("⚔️  [COMBAT] %s attacked %s for %s damage!\n", this.getName(), target.getName(), this.getPassiveDmg());
    }
    
    public void useUltimate(Character target) {
        System.out.println("✨ [ULTIMATE] " + this.getName() + " unleashes their ultimate power! (Logic TODO)");
    }
    
    public void healHp(int amount) {
        this.setHp(getHp() + amount);
        System.out.println("💚 [HEAL] " + this.getName() + " recovered " + amount + " HP!");
    }
    
    public boolean showInventory() {
        if (getInventory().isEmpty()) {
            return false;
        }
        
        System.out.println("\n🎒 --- INVENTORY --- 🎒");
        int i = 1;
        for (Item item: getInventory()) {
            System.out.print("  " + i + ". ");
            System.out.println(item.getName());
            i++;
        }
        return true;
    }
    
    public void useItem(int index, Enemy target) {
        Item item = getInventory().get(index);
        item.useItem(target, this);
        System.out.printf("🧪 [ITEM] %s used %s!\n", this.getName(), item.getName());
        removeItem(item);
    }
    
    public void earnGold(int amount) {
        this.setGold(getGold() + amount);
    }
    
    public void rewardWinner(Character from) {
        System.out.println("\n🎁 --- BATTLE REWARDS --- 🎁");
        for (Item i: from.getInventory()) {
            this.addItemInventory(i);
            System.out.println("📦 [LOOT] Obtained: " + i.getName());
        }
        
        this.earnGold(from.getGold());
        System.out.println("💰 [LOOT] +" + from.getGold() + " Gold");
        
        this.setExp(getExp() + from.getExp());
        System.out.println("🌟 [EXP]  +" + from.getExp() + " Experience");
        
        from.getInventory().clear();
        checkLevelUp();
    }
    
    public void checkLevelUp() {
        if (this.getExp() >= 200) {
            setLevel(getLevel() + 1);
            this.setExp(getExp() - 200);
            levelUp();
        }
    }
    
    public void levelUp() {
        this.setHp(getHp() + 10);
        this.setPassiveDmg(getPassiveDmg() + 10);
        System.out.println("\n🌟🌟🌟 LEVEL UP! 🌟🌟🌟");
        System.out.println("🦸 " + this.getName() + " is now Level " + this.getLevel() + "!");
        System.out.println("🔼 HP & Damage permanently increased!");
    }
    
    // Getters and Setters
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public boolean isShieldOn() { return shieldOn; }
    public void setShieldOn(boolean shieldOn) { this.shieldOn = shieldOn; }
    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
}