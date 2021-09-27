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
        this.north = north;

    }
    public void setEast (Room east){
        this.east = east;
    }
    public void setSouth (Room south){
        this.south = south;
    }
    public void setWest (Room west){
        this.west = west;
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

