/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegends;

/**
 *
 * @author prashnamshrestha
 */
public class Item {
    
    private String name;
    private ItemType type;
    private int effect;
    
    public Item(String name, ItemType type, int effect) {
        
        setName(name);
        setType(type);
        setEffect(effect);
    }
    
    // UseItem
    public void useItem(Enemy target, Hero self) {
        
        if (getType() == ItemType.HEALER) {
            self.healHp(effect);
        }
        else if (getType() == ItemType.POISON) {
            target.dealtDamage(effect);
        }
        else if (getType()== ItemType.SHIELD) {
            
            self.setShieldOn(true);
        }
        System.out.printf("Item used %s\n", getType());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }
    
    
    
}
