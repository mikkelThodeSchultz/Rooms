package com.company;

public abstract class Weapon extends Item{

    protected int damageRating;

    public Weapon(String itemName, String itemDescription, int itemWeight, FoodChecker foodChecker, int damageRating) {
        super(itemName, itemDescription, itemWeight, foodChecker);
        this.damageRating = damageRating;
    }
}
