package com.company;


public class Map {

    Room room1 = new Room("room1", "description1");
    Room room2 = new Room("room2", "description2");
    Room room3 = new Room("room3", "description3");
    Room room4 = new Room("room4", "description4");
    Room room5 = new Room("room5", "description5");
    Room room6 = new Room("room6", "description6");
    Room room7 = new Room("room7", "description7");
    Room room8 = new Room("room8", "description8");
    Room room9 = new Room("room9", "description9");

    public void createMap(){
        room1.setEast(room2);
        room2.setEast(room3);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room8.setNorth(room5);
        room6.setSouth(room9);
        room7.setEast(room8);
        room8.setEast(room9);

    }

}
