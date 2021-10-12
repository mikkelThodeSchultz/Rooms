package com.company;

public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon enemyWeapon;

    public Enemy(String name, String description, int health, Weapon enemyWeapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.enemyWeapon = enemyWeapon;
    }

    public int getHealth(){
        return health;
    }

    public Weapon getEnemyWeapon(){
        return enemyWeapon;
    }

    public String getName() {
        return name;
    }
    public String getEnemyDescription(){
        return description;
    }


    public int attack (Player player, Enemy enemy){
        return player.hit(enemyWeapon, enemy);
    }

    public int hit (Weapon weapon, Player player){
        health -= player.getCurrentWeapon().getDamageRating();
        return health;
    }
}
