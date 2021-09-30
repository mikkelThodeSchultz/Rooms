package com.company;


import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private ArrayList<Item> roomItems = new ArrayList<>();
    private Room north;
    private Room east;
    private Room south;
    private Room west;


    public void addItem (Item item){
        roomItems.add(item);
    }

    public String getItems(){

        String result = "\nYou see ";
        for (int i = 0; i < roomItems.size(); i++) {

            if (i == roomItems.size()-1) {
                result += roomItems.get(i).getItemName() + ".";
            } else if (i == roomItems.size()-2){
                result += roomItems.get(i).getItemName()+" and ";
            } else {
                result += roomItems.get(i).getItemName() + ", ";
            }

        }
        if (result.equals("\nYou see ")){
            result += "nothing of interest.";
        }

        return result;
    }
    public ArrayList<Item> getItems2(){

        return roomItems;
    }

    public Room (String name, String description){
        this.name = name;
        this.description = description;
    }
    public void setNorth (Room north){
        if (this.north == north){
            return;
        }
        if (north != null){
            this.north = north;
            north.setSouth(this);
        }

    }
    public void setEast (Room east){
        if (this.east == east){
            return;
        }
        if (east != null){
            this.east = east;
            east.setWest(this);
        }
    }
    public void setSouth (Room south) {
        if (this.south == south) {
            return;
        }
        if (south != null) {
            this.south = south;
            south.setNorth(this);
        }
    }
    public void setWest (Room west) {
        if (this.west == west) {
            return;
        }
        if (west != null) {
            this.west = west;
            west.setEast(this);
        }
    }

    public String getDescription(){
        return description;
    }
    public Room getNorth(){
        return north;
    }
    public Room getEast(){
        return east;
    }
    public Room getSouth(){
        return south;
    }
    public Room getWest(){
        return west;
    }
    public String getName(){
        return name;
    }
}
