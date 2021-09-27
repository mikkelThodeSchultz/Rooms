package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {

        Room room1 = new Room("room1", "description1");
        Room room2 = new Room("room2", "description2");
        Room room3 = new Room("room3", "description3");
        Room room4 = new Room("room4", "description4");
        Room room5 = new Room("room5", "description5");
        Room room6 = new Room("room6", "description6");
        Room room7 = new Room("room7", "description7");
        Room room8 = new Room("room8", "description8");
        Room room9 = new Room("room9", "description9");
        Room currentRoom = null;

        Scanner sc = new Scanner(System.in);
        boolean goAgain = true;

        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        room9.setNorth(room6);
        room9.setWest(room8);


        currentRoom = room1;




        while (goAgain) {
            String userInput = sc.nextLine();
            if (Objects.equals(userInput, "go north") || Objects.equals(userInput, "n")|| Objects.equals(userInput, "north")) {
                if (currentRoom.getNorth() != null) {
                    currentRoom = currentRoom.getNorth();
                    System.out.println("you are in " + currentRoom.getName() + currentRoom.getDescription());
                }
             else System.out.println("there is no door"); }

            else if (Objects.equals(userInput, "go east") || Objects.equals(userInput, "e")|| Objects.equals(userInput, "east")) {
                if (currentRoom.getEast() != null) {
                    currentRoom = currentRoom.getEast();
                    System.out.println("you are in " + currentRoom.getName() + currentRoom.getDescription());
                }
                else System.out.println("there is no door");
            }

            else if (Objects.equals(userInput, "go south") || Objects.equals(userInput, "s")|| Objects.equals(userInput, "south")) {
                if (currentRoom.getSouth() != null) {
                    currentRoom = currentRoom.getSouth();
                    System.out.println("you are in " + currentRoom.getName() + currentRoom.getDescription());
                }
                else System.out.println("there is no door");
            }

            else if (Objects.equals(userInput, "go west") || Objects.equals(userInput, "w")|| Objects.equals(userInput, "west")) {
                if (currentRoom.getWest() != null) {
                    currentRoom = currentRoom.getWest();
                    System.out.println("you are in " + currentRoom.getName() + currentRoom.getDescription());
                }
                else System.out.println("there is no door");
            }

            else if (Objects.equals(userInput, "look")){
                System.out.println("looking around");
                System.out.println("you are in " + currentRoom.getName() + currentRoom.getDescription());

            }

            else if (Objects.equals(userInput, "exit")){
                System.out.println("Thank you for playing");
                goAgain = false;
            }

            else if (Objects.equals(userInput, "help")) {
                System.out.println("Helping info");

            }
            else System.out.println("your choice was not registered please try again yo");
        }
    }
}
