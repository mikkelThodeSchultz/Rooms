package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    Scanner sc = new Scanner(System.in);
    boolean goAgain = true;


    public void runGame() {
        Player player = new Player("Thor");
        System.out.println("You come to your senses... " +
                           "\nYour head feels as if you have been hit with a mallet. " +
                           "\nAs your eyes adjust to the surroundings, you realize that may just be the case. " +
                           "\nYour bare feet stick to the tiled floor and whatever half-dried liquid covers it, the scent of decay is cloying. " +
                           "\nYou think that it might be a good idea to find an exit. " +
                           "\nFast." +
                           "\n(Type 'help' for a list of available commands)" +
                           "\n\nYou are currently in the Chute room. " + player.getCurrentRoom().getDescription() + ".");

        while (goAgain) {

            String userInput = sc.nextLine().toLowerCase().trim();
            String command = parser(userInput);

            switch (command) {
                case "n", "e", "s", "w", "g":
                    if (userInput.startsWith("go ")) {
                        userInput = userInput.substring(3, 4);
                    }
                    move(userInput, player);
                    break;
                case "i":
                    printInventory(player.getInventory());
                    break;
                case "q":
                    System.out.println("Thx for playin' m8");
                    goAgain = false;
                    break;
                case "h":
                    helpInfo();
                    break;
                case "d":
                    if (userInput.startsWith("drop")) {
                        String item = userInput.substring(5);
                        drop(item, player);
                    }
                    break;
                case "p":
                    if (userInput.startsWith("pick up")) {
                        String item = userInput.substring(8);
                        pickUp (item, player, player.getPlayerCarryCapacity());
                    }
                    break;
                case "l":
                    lookAround(player);
                    break;
                default:
                    System.out.println("Your input was not registered. Type 'help' for a list of possible commands.");
            }
        }
    }

    private void printInventory(ArrayList<Item> inventory) {
        String result = "You are carrying ";
        for (int i = 0; i < inventory.size(); i++) {
            if (i == inventory.size() - 1) {
                result += inventory.get(i).getItemName() + ".";
            } else if (i == inventory.size() - 2) {
                result += inventory.get(i).getItemName() + " and ";
            } else {
                result += inventory.get(i).getItemName() + ", ";
            }
        }
        if (result.equals("You are carrying ")) {
            result += "nothing.";
        }
        System.out.println(result);
    }

    private void drop(String substring, Player player) {
        String currentItem = substring;
        ArrayList<Item> itemsRoom = player.getCurrentRoom().getItems();
        ArrayList<Item> playerInventory = player.getInventory();
        for (int i = 0; i < playerInventory.size(); i++) {
            if (currentItem.equals(playerInventory.get(i).getItemName())) {
                itemsRoom.add(new Item(playerInventory.get(i).getItemName()));
                System.out.println("You dropped " + playerInventory.get(i).getItemName() + " in the " + player.getCurrentRoom().getName());
                playerInventory.remove(i);
            }
        }
    }

    private void pickUp(String substring, Player player, boolean playerCarryCapacity) {//Work in progress, currently not working as intended.
        String currentItem = substring;
        ArrayList<Item> playerInventory = player.getInventory();
        ArrayList<Item> itemsRoom = player.getCurrentRoom().getItems();
        if (playerCarryCapacity == true) {
            for (int i = 0; i < itemsRoom.size(); i++) {
                if (currentItem.equals(itemsRoom.get(i).getItemName())) {
                    playerInventory.add(new Item(itemsRoom.get(i).getItemName()));
                    System.out.println("You picked up " + itemsRoom.get(i).getItemName());
                    itemsRoom.remove(i);
                    player.getPlayerCarryCapacity();
                }
            }
        }
        if (playerCarryCapacity == false){
            System.out.println("You're carrying too many items. Drop some.");
        }
    }

    private void lookAround(Player player) {
        System.out.println("You take a look at your surroundings...");
        System.out.println(player.getCurrentRoom().getDescription());
        ArrayList<Item> itemsRoom = player.getCurrentRoom().getItems();
        printItems(itemsRoom);
    }

    private void helpInfo() {
        System.out.println("There is little help to be found here." +
                           "\nType 'look' to get a description of your current room. " +
                           "\nType '(n)orth', '(e)ast', '(s)outh', or '(w)est' to move in one of the cardinal directions." +
                           "\nType 'pick up' + the item you want to pick up." +
                           "\nType 'drop' + the item you want to drop." +
                           "\nType '(i)nventory' to look at what you are carrying." +
                           "\nType '(q)uit' to quit the game.");
    }

    private void printItems(ArrayList<Item> roomItems) {

        String result = "You see ";
        for (int i = 0; i < roomItems.size(); i++) {

            if (i == roomItems.size() - 1) {
                result += roomItems.get(i).getItemDescription() + ".";
            } else if (i == roomItems.size() - 2) {
                result += roomItems.get(i).getItemDescription() + " and ";
            } else {
                result += roomItems.get(i).getItemDescription() + ", ";
            }
        }
        if (result.equals("You see ")) {
            result += "nothing of interest.";
        }
        System.out.println(result);
    }

    private void move(String command, Player player) {
        if (command.equals("n") || command.equals("e") || command.equals("s") || command.equals("w")) {
            if (!player.move(command)) {
                System.out.println("You can't go that way.");
            } else {
                System.out.println("You move to the " + player.getCurrentRoom().getName() + ". "
                                   + player.getCurrentRoom().getDescription() + ".");
                ArrayList<Item> itemsRoom = player.getCurrentRoom().getItems();
                printItems(itemsRoom);
            }
        }
    }

    private String parser(String input) {

        String command = input + " ";
        if (command.startsWith(" ")) {
            return command;
        } else {
            command = input.substring(0,1);
        }
        return command;
    }
}