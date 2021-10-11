package com.company;

public class ShootingWeapon extends Weapon{

    private int ammo;

    public ShootingWeapon(String itemName, String itemDescription, int itemWeight, FoodChecker foodChecker, int damageRating, int ammo) {
        super(itemName, itemDescription, itemWeight, foodChecker, damageRating);
        this.ammo = ammo;
    }
}
