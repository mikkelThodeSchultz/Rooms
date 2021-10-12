package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int playerCarryCapacity = 10;
    private int health = 100;

    Map map = new Map();

    public Player(String name) {
        this.name = name;
        currentRoom = map.room1;
        map.createMap();

        inventory.add(new Item("pants", "your pants, worn and dirty", 0));
        inventory.add(new Item("shirt", "your shirt, blood sticking to the back and shoulders", 0));
    }

    public Status eat(String item) {
        Status status;
        Food inventoryFood = (Food) findItem(getInventory(), item);
        Food roomFood = (Food) findItem(getCurrentRoom().getItems(), item);

        if ((findItem(getInventory(), item) == null) && (findItem(getCurrentRoom().getItems(), item) == null)) {
            status = Status.NOTFOUND;
        } else if ((!(findItem(getInventory(), item) instanceof Food)) && (!(findItem(getCurrentRoom().getItems(), item) instanceof Food))) {
            status = Status.CANT;
        } else {
            status = Status.OKAY;
            if (inventoryFood == null) {
                health = health + roomFood.getHealthPoints();
                getCurrentRoom().getItems().remove(roomFood);
            } else
                health = health + inventoryFood.getHealthPoints();
                getInventory().remove(inventoryFood);
            }
            if (health > 100){
                health = 100;
            }
            return status;
        }

    public Item findItem(ArrayList<Item> liste, String itemName) {
        for (int i = 0; i < liste.size(); i++) {
            Item item = liste.get(i);
            if (itemName.equals(item.getItemName())) {
                return item;
            }
        }
        return null;
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

        if (resultingWeight > playerCarryCapacity) {
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

    public boolean move(String command) {
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
        } else if (command.equals("w")) {
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
        }
        return didIWalk;
    }

    public String take(String substring) {
        String currentItem = substring;
        String resultat = "";

        Item item = findItem(getCurrentRoom().getItems(), currentItem);
        if (item != null) {
            if (canCarry(item)) {
                inventory.add(item);
                resultat = "You picked up " + item.getItemName();
                getCurrentRoom().getItems().remove(item);
            } else {
                resultat = "You're carrying too many items. Drop some.";
            }
        } else {
            resultat = "Can't see anything like " + currentItem + " around here!";
        }
        return resultat;
    }

    public boolean drop(String substring) {
        boolean status;
        String itemName = substring;

        Item item = findItem(inventory, itemName);

        if (item != null) {
            inventory.remove(item);
            getCurrentRoom().getItems().add(item);
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public Status equip(String item) {
        Status status = null;
        Weapon inventoryWeapon = (Weapon) findItem(getInventory(), item);

        if ((findItem(getInventory(), item) == null)) {
            status = Status.NOTFOUND;
        } else if ((!(findItem(getInventory(), item) instanceof Weapon))) {
            status = Status.CANT;
        } else {
            status = Status.OKAY;
            inventoryWeapon.isEquipped();
        }
        return status;
    }
}





