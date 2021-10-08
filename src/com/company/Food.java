package com.company;

public class Food extends Item {

    private int healthPoints;

    public Food (String itemName, String itemDescription, int itemWeight, int healthPoints, FoodChecker foodChecker){
        super (itemName, itemDescription, itemWeight, foodChecker);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints(){
        return healthPoints;
    }
}
