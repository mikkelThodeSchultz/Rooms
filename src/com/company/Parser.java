package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Parser {

        Scanner sc = new Scanner(System.in);
        boolean goAgain = true;

        Player player = new Player("pede");


    public void runGame() {

        player.addItem(new Item("bukser"));
        player.addItem(new Item("trøje"));
        player.addItem(new Item("sko"));

        System.out.println("You come to your senses... " +
                "\nYour head feels as if you have been hit with a mallet. " +
                "\nAs your eyes adjust to the surroundings, you realize that may just be the case. " +
                "\nYour bare feet stick to the tiled floor and whatever half-dried liquid covers it, the scent of decay is cloying. " +
                "\nYou think that it might be good idea to find an exit. " +
                "\nFast." +
                "\n(Type 'help' for a list of available commands)");

        while (goAgain) {
            String userInput = sc.nextLine();
            if (Objects.equals(userInput, "go north") || Objects.equals(userInput, "n") || Objects.equals(userInput, "north")) {
                if (player.playerRoom.getNorth() != null) {
                    player.playerRoom = player.playerRoom.getNorth();
                    System.out.println("You move north. You are now in the " + player.playerRoom.getName() + ". " + player.playerRoom.getDescription() + "" +
                              player.playerRoom.getItems());
                } else System.out.println("there is no door");
            } else if (Objects.equals(userInput, "go east") || Objects.equals(userInput, "e") || Objects.equals(userInput, "east")) {
                if (player.playerRoom.getEast() != null) {
                    player.playerRoom = player.playerRoom.getEast();
                    System.out.println("You move east. You are now in the " + player.playerRoom.getName() + ". " + player.playerRoom.getDescription() + "" +
                            player.playerRoom.getItems());
                } else System.out.println("there is no door");
            } else if (Objects.equals(userInput, "go south") || Objects.equals(userInput, "s") || Objects.equals(userInput, "south")) {
                if (player.playerRoom.getSouth() != null) {
                    player.playerRoom = player.playerRoom.getSouth();
                    System.out.println("You move south. You are now in the " + player.playerRoom.getName() + ". " + player.playerRoom.getDescription() + "" +
                            player.playerRoom.getItems());
                } else System.out.println("there is no door");
            } else if (Objects.equals(userInput, "go west") || Objects.equals(userInput, "w") || Objects.equals(userInput, "west")) {
                if (player.playerRoom.getWest() != null) {
                    player.playerRoom = player.playerRoom.getWest();
                    System.out.println("You move west. You are now in the " + player.playerRoom.getName() + ". " + player.playerRoom.getDescription() + "" +
                            player.playerRoom.getItems());
                } else System.out.println("there is no door");
            } else if (Objects.equals(userInput, "look")) {
                System.out.println("You take a look at your surroundings.");
                System.out.println("You are in the" + player.playerRoom.getName() + ". " + player.playerRoom.getDescription());

                        ArrayList<Item> temp = player.playerRoom.getItems2();
                printItems(temp);

            }else if (Objects.equals(userInput, "inventory")) {
                player.getInventory();


            } else if (Objects.equals(userInput, "exit")) {
                System.out.println("Thank you for playing");
                goAgain = false;
            } else if (Objects.equals(userInput, "help")) {
                System.out.println("There is little help to be found here." +
                        "\nType 'look' to get a description of your current room. " +
                        "\nType '(n)orth', '(e)ast', '(s)outh', or '(w)est' to move in one of the cardinal directions." +
                        "\nType 'exit' to quit the game.");

            } else System.out.println("your choice was not registered please try a valid input.");
        }
    }

    private void printItems(ArrayList<Item> roomItems) {

        String result = "\nYou see ";
        for (int i = 0; i < roomItems.size(); i++) {

            if (i == roomItems.size()-1) {
                result += roomItems.get(i).getItemName() + ".";
            } else if (i == roomItems.size()-2){
                result += roomItems.get(i).getItemName()+" and ";
            } else {
                result += roomItems.get(i).getItemName() + ", ";
            }

        }
        if (result.equals("\nYou see ")){
            result += "nothing of interest.";
        }
        System.out.println(result);
    }
}
