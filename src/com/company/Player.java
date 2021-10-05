package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    public int playerCarryCapacity = 10;//Work in progress, currently not working as intended (read: at all).

    Map map = new Map();

    public Player(String name) {
        this.name = name;
        currentRoom = map.room1;
        map.createMap();

        inventory.add(new Item ("pants"));
        inventory.add(new Item ("shirt"));
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean getPlayerCarryCapacity () {//Work in progress, currently not working as intended (read: at all).
        boolean amICarryingTooMuch = true;
        int cumulatedWeight = 0;
        for (int i = 0; i < inventory.size(); i++) {
            cumulatedWeight += inventory.get(i).getItemWeight();
            if (cumulatedWeight > playerCarryCapacity) {
                amICarryingTooMuch = false;
            }
        }
        return amICarryingTooMuch;
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




