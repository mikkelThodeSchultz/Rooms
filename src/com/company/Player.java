package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int playerCarryCapacity = 10;//Work in progress, currently not working as intended (read: at all).
    private int health = 100;

    Map map = new Map();

    public Player(String name) {
        this.name = name;
        currentRoom = map.room1;
        map.createMap();

        inventory.add(new Item ("pants", "your pants, worn and dirty", 0, FoodChecker.INEDIBLE));
        inventory.add(new Item ("shirt", "your shirt, blood sticking to the back and shoulders", 0, FoodChecker.INEDIBLE));
    }

    public FoodChecker eat (Item item) { //TODO FIX FOOD ITEM EAT
            return FoodChecker.INEDIBLE;
    }

    public FoodChecker eat (Food food) {
        if (food.getFoodChecker().equals(FoodChecker.EDIBLE)) {

            if (health + food.getHealthPoints() >= 100){
                health = 100;
            }else
            health = health + food.getHealthPoints();

            return FoodChecker.EDIBLE;

        } else if (food.getFoodChecker().equals(FoodChecker.INEDIBLE)) {
            return FoodChecker.INEDIBLE;

        } else
            health = health + food.getHealthPoints();
            return FoodChecker.POISONOUS;

    }

    public int getHealth() {
        return health;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean canCarry(Item item) {
        int resultingWeight = getCumulatedWeight() + item.getItemWeight();

        if( resultingWeight > playerCarryCapacity ) {
            return false;
        } else {
            return true;
        }
    }

    public int getCumulatedWeight() {
        int cumulatedWeight = 0;
        for (int i = 0; i < inventory.size(); i++) {
            cumulatedWeight += inventory.get(i).getItemWeight();
        }
        return cumulatedWeight;
    }

    public boolean move (String command) {
        boolean didIWalk = true;
        if (command.equals("n")) {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                didIWalk = true;
            } else {
                didIWalk = false;
            }
        } else if (command.equals("e")) {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                didIWalk = true;
            } else {
                didIWalk = false;
            }
        }
        else if (command.equals("w")) {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                didIWalk = true;
            } else {
                didIWalk = false;
            }
        } else if (command.equals("s")) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                didIWalk = true;
            } else {
                didIWalk = false;
            }
        } return didIWalk;
    }
}




