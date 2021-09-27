package com.company;

public class Player {
    String name;
    Room playerRoom;
    Map map = new Map();


    public Player (String name){
        this.name=name;
        playerRoom = map.room1;
        map.createMap();


    }
}
