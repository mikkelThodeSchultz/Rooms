package com.company;

public class ShootingWeapon extends Weapon{

    private int ammo;

    public ShootingWeapon(String itemName, String itemDescription, int itemWeight, int damageRating, int ammo) {
        super(itemName, itemDescription, itemWeight, damageRating);
        this.ammo = ammo;
    }

    @Override
    public int getDamageRating() {
        return damageRating;
    }

    public int getAmmo(){
        return ammo;
    }

    public void decreasingAmmo(){
        ammo--;
    }
}
