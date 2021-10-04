package com.company;


public class Map {

    Room room1 = new Room(" Chute room", "There is a chute from the ceiling. It is slick with what you fear is blood. In the floor is a drain, equally sticky.");
    Room room2 = new Room(" Hook room", "All along the ceiling are sharp meat hooks as you would find at a butcher. Some of them are still dripping with fresh gore.");
    Room room3 = new Room(" Operating room", "In the center of this room is an operating table, it seems to have seen heavy use not too long ago.");
    Room room4 = new Room(" Kennel room", "Along the western wall are dog cages. All of the cages are empty, although some of them seem to have been broken open from the inside.");
    Room room5 = new Room(" Stair room", "A stair case leads up, a dim light shines above.");
    Room room6 = new Room(" Tool room", "The walls are lined with shelves and racks, filled with all manner of tools surgical and industrial.");
    Room room7 = new Room(" Storage room", "The room is filled with old furniture; chairs, tables and beds from countless different places.");
    Room room8 = new Room(" TV room", "An old TV facing a couch occupies the center of the room. An old sit-com is running of off an old VHS player.");
    Room room9 = new Room(" Grinder room", "A worryingly large industrial-grade meat-grinder fills the room.");

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
        room1.addItem(new Item ("teeth", "a bag of bloody teeth"));
        room2.addItem(new Item ("meat", "a slab of human meat")); //TODO human meat
        room2.addItem(new Item ("hook", "a sharp meat hook"));
        room8.addItem(new Item ("loafers", "a pair of comfy but filthy loafers"));

    }
}
