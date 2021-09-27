package com.company;


public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;




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
