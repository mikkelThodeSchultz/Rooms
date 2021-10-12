package com.company;

public abstract class Weapon extends Item{

    protected int damageRating;
    protected boolean equipped;

    public Weapon(String itemName, String itemDescription, int itemWeight, int damageRating) {
        super(itemName, itemDescription, itemWeight);
        this.damageRating = damageRating;
        this.equipped = false;
    }

    public boolean isEquipped() {
        if (equipped) {
            equipped = false;
        } else {
            equipped = true;
        }

        return equipped;
    }
}
