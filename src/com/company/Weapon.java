package com.company;

public abstract class Weapon extends Item {

    protected int damageRating;


    public Weapon(String itemName, String itemDescription, int itemWeight, int damageRating) {
        super(itemName, itemDescription, itemWeight);
        this.damageRating = damageRating;
    }

    public abstract int getDamageRating();

}


