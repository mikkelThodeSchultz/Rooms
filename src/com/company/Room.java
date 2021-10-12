package com.company;


import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private ArrayList<Item> roomItems = new ArrayList<>();
    private ArrayList<Enemy> roomEnemies = new ArrayList<>();
    private int roomCounter;
    private String roomHelp;
    private Room north;
    private Room east;
    private Room south;
    private Room west;



    public Room (String name, String description){
        this.name = name;
        this.description = description;
        this.roomCounter = 0;
    }
    public void setNorth (Room north){
        if (this.north == north){
            return;
        } if (north != null){
            this.north = north;
            north.setSouth(this);
        }
    }
    public void setEast (Room east){
        if (this.east == east){
            return;
        } if (east != null){
            this.east = east;
            east.setWest(this);
        }
    }
    public void setSouth (Room south) {
        if (this.south == south) {
            return;
        } if (south != null) {
            this.south = south;
            south.setNorth(this);
        }
    }
    public void setWest (Room west) {
        if (this.west == west) {
            return;
        } if (west != null) {
            this.west = west;
            west.setEast(this);
        }
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
    public String getDescription(){
        return description;
    }
    public void addItem (Item item){
        roomItems.add(item);
    }
    public void addEnemy (Enemy enemy){
        roomEnemies.add(enemy);
    }
    public void removeEnemy (Enemy enemy){
        roomEnemies.remove(enemy);
    }

    public ArrayList<Item> getItems(){
        return roomItems;
    }

    //TODO: evt. bruge metoderne senere
    public String getRoomHelp() {
        return roomHelp;
    }
    public void setRoomHelp(String roomHelp) {
        this.roomHelp = roomHelp;
    }

    public int getRoomCounter() {
        return roomCounter;
    }
    public void enteredRoom(){
        roomCounter ++;
    }
    public ArrayList<Enemy> getRoomEnemies() {
        return roomEnemies;
    }
}
