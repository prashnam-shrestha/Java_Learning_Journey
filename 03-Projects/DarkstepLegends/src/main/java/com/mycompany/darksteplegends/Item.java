package com.mycompany.darksteplegends;

public class Item {
    
    private String name;
    private ItemType type;
    private int effect;
    
    public Item(String name, ItemType type, int effect) {
        setName(name);
        setType(type);
        setEffect(effect);
    }
    
    public void useItem(Enemy target, Hero self) {
        if (getType() == ItemType.HEALER) {
            self.healHp(effect);
        }
        else if (getType() == ItemType.POISON) {
            target.dealtDamage(effect);
            System.out.printf("☠️  [POISON] %s takes %s poison damage!\n", target.getName(), effect);
        }
        else if (getType() == ItemType.SHIELD) {
            self.setShieldOn(true);
            System.out.printf("🛡️  [SHIELD] %s activated a mystical shield!\n", self.getName());
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public ItemType getType() { return type; }
    public void setType(ItemType type) { this.type = type; }
    public int getEffect() { return effect; }
    public void setEffect(int effect) { this.effect = effect; }
}