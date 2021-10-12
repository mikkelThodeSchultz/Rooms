package com.company;

public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String itemName, String itemDescription, int itemWeight, int damageRating) {
        super(itemName, itemDescription, itemWeight, damageRating);
    }

    @Override
    public int getDamageRating() {
        return damageRating;
    }
}
