package com.company;

import java.util.ArrayList;

public class Player {
    private  String name;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    Map map = new Map();
    Player player = new Player("Thor");

    public Player (String name){
        this.name=name;
        currentRoom = map.room1;
        map.createMap();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public ArrayList<Item> getInventory(){
        return inventory;

    }

    public void move(String command){

        if (command.equals("n")){
            if (player.currentRoom.getNorth() != null) {
                player.currentRoom = player.currentRoom.getNorth();
            }
        if (command.equals("e")){
            if (player.currentRoom.getEast() != null) {
                player.currentRoom = player.currentRoom.getEast();
            }
        if (command.equals("w")){
            if (player.currentRoom.getWest() != null) {
                player.currentRoom = player.currentRoom.getWest();
            }
        if (command.equals("s")){
            if (player.currentRoom.getSouth() != null) {
                player.currentRoom = player.currentRoom.getSouth();
            }
        }

    }

    public void addItem (Item item){
        player.addItem(new Item("bukser"));
        player.addItem(new Item("trøje"));
        player.addItem(new Item("sko"));
        inventory.add(item);
    }


}
