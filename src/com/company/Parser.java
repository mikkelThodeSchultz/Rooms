package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Parser {

        Scanner sc = new Scanner(System.in);
        boolean goAgain = true;

        Player player = new Player("pede");

    public void runGame() {

        while (goAgain) {
            String userInput = sc.nextLine();
            if (Objects.equals(userInput, "go north") || Objects.equals(userInput, "n") || Objects.equals(userInput, "north")) {
                if (player.playerRoom.getNorth() != null) {
                    player.playerRoom = player.playerRoom.getNorth();
                    System.out.println("you are in " + player.playerRoom.getName() + player.playerRoom.getDescription());
                } else System.out.println("there is no door");
            } else if (Objects.equals(userInput, "go east") || Objects.equals(userInput, "e") || Objects.equals(userInput, "east")) {
                if (player.playerRoom.getEast() != null) {
                    player.playerRoom = player.playerRoom.getEast();
                    System.out.println("you are in " + player.playerRoom.getName() + player.playerRoom.getDescription());
                } else System.out.println("there is no door");
            } else if (Objects.equals(userInput, "go south") || Objects.equals(userInput, "s") || Objects.equals(userInput, "south")) {
                if (player.playerRoom.getSouth() != null) {
                    player.playerRoom = player.playerRoom.getSouth();
                    System.out.println("you are in " + player.playerRoom.getName() + player.playerRoom.getDescription());
                } else System.out.println("there is no door");
            } else if (Objects.equals(userInput, "go west") || Objects.equals(userInput, "w") || Objects.equals(userInput, "west")) {
                if (player.playerRoom.getWest() != null) {
                    player.playerRoom = player.playerRoom.getWest();
                    System.out.println("you are in " + player.playerRoom.getName() + player.playerRoom.getDescription());
                } else System.out.println("there is no door");
            } else if (Objects.equals(userInput, "look")) {
                System.out.println("looking around");
                System.out.println("you are in " + player.playerRoom.getName() + player.playerRoom.getDescription());

            } else if (Objects.equals(userInput, "exit")) {
                System.out.println("Thank you for playing");
                goAgain = false;
            } else if (Objects.equals(userInput, "help")) {
                System.out.println("Helping info");

            } else System.out.println("your choice was not registered please try again yo");
        }
    }
}
