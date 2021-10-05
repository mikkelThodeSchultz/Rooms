package com.company;


public class Map {

    Room room1 = new Room("Chute room", "There is a chute from the ceiling. It is slick with what you fear is blood. In the floor is a drain, equally sticky.");
    Room room2 = new Room("Hook room", "All along the ceiling are sharp meat hooks as you would find at a butcher. Some of them are still dripping with fresh gore.");
    Room room3 = new Room("Operating room", "In the center of this room is an operating table, it seems to have seen heavy use not too long ago.");
    Room room4 = new Room("Kennel room", "Along the western wall are dog cages. All of the cages are empty, although some of them seem to have been broken open from the inside.");
    Room room5 = new Room("Stair room", "A stair case leads up, a dim light shines above.");
    Room room6 = new Room("Tool room", "The walls are lined with shelves and racks, filled with all manner of tools surgical and industrial.");
    Room room7 = new Room("Storage room", "The room is filled with old furniture; chairs, tables and beds from countless different places.");
    Room room8 = new Room("TV room", "An old TV facing a couch occupies the center of the room. An old sit-com is running of off an old VHS player.");
    Room room9 = new Room("Grinder room", "The walls and floor are spattered with gore.");

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
        room1.addItem(new Item ("teeth", "a small bag of bloody teeth", 0));
        room2.addItem(new Item ("meat", "a slab of human meat", 2));
        room2.addItem(new Item ("hook", "a sharp meat hook", 3));
        room3.addItem(new Item ("play toy", "a funny looking horse", 1));
        room3.addItem(new Item ("saw", "a surgical bone-saw, still sharp", 2));
        room3.addItem(new Item ("scalpel", "a scalpel made of sharp surgical steel", 1));
        room4.addItem(new Item ("limbs", "a pile of human limbs", 6));
        room4.addItem(new Item ("femur", "a gnawed human femur", 1));
        room5.addItem(new Item ("cellphone", "a cellphone with its battery half charged, only one bar though", 1));
        room5.addItem(new Item ("shards", "shards of glass scattered across the floor", 99));
        room6.addItem(new Item ("mallet", "a heavy mallet with some dried blood and hair on its head", 2));
        room7.addItem(new Item ("key", "a rusty key", 1));
        room8.addItem(new Item ("loafers", "a pair of comfy but filthy loafers", 0));
        room8.addItem(new Item ("tape", "a VHS tape with the first season of 'Saved by the bell'", 1));
        room9.addItem(new Item ("grinder","A worryingly large industrial-grade meat-grinder fills the room.",99));

    }
}
