package com.company;

import java.util.ArrayList;

public class Player {
    private  String name;
    public Room playerRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    Map map = new Map();



    public String getInventory(){

        String result = "\nYou see ";
        for (int i = 0; i < inventory.size(); i++) {

            if (i == inventory.size()-1) {
                result += inventory.get(i).getItemName() + ".";
            } else if (i == inventory.size()-2){
                result += inventory.get(i).getItemName()+" and ";
            } else {
                result += inventory.get(i).getItemName() + ", ";
            }

        }
        if (result.equals("\nYou see ")){
            result += "nothing of interest.";
        }

        return result;
    }

    public void addItem (Item item){
        inventory.add(item);
    }

    public Player (String name){
        this.name=name;
        playerRoom = map.room1;
        map.createMap();


    }
}
