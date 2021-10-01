package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    Map map = new Map();

    public Player(String name) {
        this.name = name;
        currentRoom = map.room1;
        map.createMap();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
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
        }
        else if (command.equals("e")) {
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
        }
        else if (command.equals("s")) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                didIWalk = true;
            } else {
                didIWalk = false;
            }
        }
        return didIWalk;
    }


}




