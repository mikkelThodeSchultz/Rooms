package com.company;

import javax.swing.*;
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
        player.getCurrentRoom().enteredRoom();

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
                    System.out.println("Leave now, and newer, come back!");
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
                        pickUp(item, player);
                    }
                    else System.out.println("Your input was not registered. Type 'help' for a list of possible commands.");
                    break;
                case "l":
                    lookAround(player);
                    break;
                //TODO add til help info
                case "j":
                    // health
                    System.out.println(whatIsMyHealth(player));
                    System.out.println("You are at " + player.getHealth() + " health points.");
                    break;
                case "f":
                    if (userInput.startsWith("eat ")) {
                        String item = userInput.substring(4);
                        if ((findItem(player.getInventory(),item)==null)&&(findItem(player.getCurrentRoom().getItems(),item)==null)){
                            System.out.println("There is no " + item + " here.");
                        }
                        else if ((!(findItem(player.getInventory(), item) instanceof Food))&&(!(findItem(player.getCurrentRoom().getItems(), item) instanceof Food))) {
                            System.out.println("You can't eat " + item + ".");

                        } else {
                            if ((findItem(player.getInventory(),item)== null)){
                                Food testfood = (Food) findItem(player.getCurrentRoom().getItems(), item);
                                System.out.println(eatFromRoom(testfood,player,item));
                            }
                            else if ((findItem(player.getCurrentRoom().getItems(),item) == null)){
                                Food testfood = (Food) findItem(player.getInventory(), item);
                                System.out.println(eatFromInventory(testfood,player,item));
                            }
                        }
                    }

                    //FoodChecker testFood = player.eat(findItem(player.getInventory(), item));


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
        String itemName = substring;
        ArrayList<Item> itemsRoom = player.getCurrentRoom().getItems();
        ArrayList<Item> playerInventory = player.getInventory();

        Item item = findItem(playerInventory, itemName);

        if (item != null) {
            playerInventory.remove(item);
            System.out.println("You droppped " + item.getItemName() + " in the " + player.getCurrentRoom().getName() + ".");
            itemsRoom.add(item);
        } else {
            System.out.println("You are not carrying '" + itemName + "' in your inventory");
        }
    }

    private void pickUp(String substring, Player player) {
        String currentItem = substring;
        ArrayList<Item> playerInventory = player.getInventory();
        ArrayList<Item> itemsRoom = player.getCurrentRoom().getItems();

        Item item = findItem(itemsRoom, currentItem);
        if (item != null) {
            if (player.canCarry(item)) {
                playerInventory.add(item);
                System.out.println("You picked up " + item.getItemName());
                itemsRoom.remove(item);
            } else {
                System.out.println("You're carrying too many items. Drop some.");
            }
        } else {
            System.out.println("Can't see anything like " + currentItem + " around here!");
        }
    }

    private Item findItem(ArrayList<Item> liste, String itemName) {
        for (int i = 0; i < liste.size(); i++) {
            Item item = liste.get(i);
            if (itemName.equals(item.getItemName())) {
                return item;
            }
        }
        return null;
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
                player.getCurrentRoom().enteredRoom();
                System.out.println("You move to the " + player.getCurrentRoom().getName() + ". ");
                if (player.getCurrentRoom().getRoomCounter() <= 1) {
                    System.out.println(player.getCurrentRoom().getDescription() + ".");
                }
                ArrayList<Item> itemsRoom = player.getCurrentRoom().getItems();
                printItems(itemsRoom);
            }
        }
    }

    private String parser(String input) {

        String command = input + " "; //TODO Husk at tilføje mellemrum
        if (command.startsWith(" ")) {
            return command;

        } else if (command.equals("health ")) {
            command = "j";
        } else if (command.startsWith("eat ")) {
            command = "f";
        } else {
            command = input.substring(0, 1);
        }
        return command;
    }

    public String whatIsMyHealth(Player player) {
        int health = player.getHealth();
        String healthStatus = null;
        if (health > 75) {
            healthStatus = "You're doing fine... for now.";
        } else if (health > 50) {
            healthStatus = "You're looking a bit rough, maybe find some food.";
        } else if (health > 25) {
            healthStatus = "You're badly injured, avoid fighting and seriously, find some food...";
        } else if (health > 10) {
            healthStatus = "Apparently you have a death wish";
        } else {
            healthStatus = "You´re in massive pain, you can hardly walk. Good luck...";
        }
        return healthStatus;
    }

    public String eatFromInventory(Food food,Player player, String item){
        String resultat = "";
                Food testfood = food;
            player.getInventory().remove(testfood);
            if (player.eat(testfood).equals(FoodChecker.EDIBLE)) {
                resultat = "You eat " + item + " and feel better. You are now at " + player.getHealth() + "hp.";
            } else {
               resultat = "You eat " + item + " and feel worse. You are now at " + player.getHealth() + "hp.";
            }
        return resultat;
    }

    public String eatFromRoom(Food food,Player player, String item){
        String resultat = "";
        Food testfood = food;
        player.getCurrentRoom().getItems().remove(testfood);
        if (player.eat(testfood).equals(FoodChecker.EDIBLE)) {
            resultat = "You eat " + item + " and feel better. You are now at " + player.getHealth() + "hp.";
        } else {
            resultat = "You eat " + item + " and feel worse. You are now at " + player.getHealth() + "hp.";
        }
        return resultat;
    }
}