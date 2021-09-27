package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        boolean goAgain = true;
        Map map = new Map();
        map.createMap();


        while (goAgain) {
            String userInput = sc.nextLine();
            if (Objects.equals(userInput, "go north") || Objects.equals(userInput, "n")|| Objects.equals(userInput, "north")) {
                if (map.currentRoom.getNorth() != null) {
                    map.currentRoom = map.currentRoom.getNorth();
                    System.out.println("you are in " + map.currentRoom.getName() + map.currentRoom.getDescription());
                }
                else System.out.println("there is no door"); }

            else if (Objects.equals(userInput, "go east") || Objects.equals(userInput, "e")|| Objects.equals(userInput, "east")) {
                if (map.currentRoom.getEast() != null) {
                    map.currentRoom = map.currentRoom.getEast();
                    System.out.println("you are in " + map.currentRoom.getName() + map.currentRoom.getDescription());
                }
                else System.out.println("there is no door");
            }

            else if (Objects.equals(userInput, "go south") || Objects.equals(userInput, "s")|| Objects.equals(userInput, "south")) {
                if (map.currentRoom.getSouth() != null) {
                    map.currentRoom = map.currentRoom.getSouth();
                    System.out.println("you are in " + map.currentRoom.getName() + map.currentRoom.getDescription());
                }
                else System.out.println("there is no door");
            }

            else if (Objects.equals(userInput, "go west") || Objects.equals(userInput, "w")|| Objects.equals(userInput, "west")) {
                if (map.currentRoom.getWest() != null) {
                    map.currentRoom = map.currentRoom.getWest();
                    System.out.println("you are in " + map.currentRoom.getName() + map.currentRoom.getDescription());
                }
                else System.out.println("there is no door");
            }

            else if (Objects.equals(userInput, "look")){
                System.out.println("looking around");
                System.out.println("you are in " + map.currentRoom.getName() + map.currentRoom.getDescription());

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