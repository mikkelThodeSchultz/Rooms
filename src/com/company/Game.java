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
                "\n(Type 'help' for a list of available commands)");

        while (goAgain) {

            String userInput = sc.nextLine().toLowerCase().trim();
            String command = userInput;
            if (command.startsWith("pick up")){
                String item = command.substring(8);
                pickUp(item, player);
            }
            if (command.startsWith("drop")){
                String item = command.substring(5);
                drop(item, player);
            }
            command = parser(userInput);


            switch (command) {
                case "n":
                case "e":
                case "s":
                case "w":
                    move(command, player);
                    break;

                case "i" :
                    printInventory(player.getInventory());
                    break;
                case "q" :
                    goAgain = false;
                    break;

                case "h" : helpInfo();
                    break;
                case "d" : // er tom fordi ellers printer den default.
                    break;
                case "p" : // er tom fordi ellers printer den default.
                    break;
                case "l" : lookAround(player);
                    break;
                default:
                    System.out.println("Your input was not registered. Type 'help' for a list of possible commands.");


            }
        }
    }

    private void printInventory (ArrayList<Item> inventory){
        String result = "\nYou are carrying ";
        for (int i = 0; i < inventory.size(); i++) {

            if (i == inventory.size()-1) {
                result += inventory.get(i).getItemName() + ".";
            } else if (i == inventory.size()-2){
                result += inventory.get(i).getItemName()+" and ";
            } else {
                result += inventory.get(i).getItemName() + ", ";
            }

        }
        if (result.equals("\nYou are carrying ")){
            result += "nothing.";
        }
        System.out.println(result);
    }

    private void drop (String substring, Player player) {
        String currentItem = substring;
        ArrayList<Item> tempRoomItems = player.getCurrentRoom().getItems();
        ArrayList<Item> tempInventory = player.getInventory();
        for (int i = 0; i < tempInventory.size(); i++) {
            if (currentItem.equals(tempInventory.get(i).getItemName())) {
                tempRoomItems.add(new Item(tempInventory.get(i).getItemName()));
                System.out.println("You drop " + tempInventory.get(i).getItemName() + " well done.");
                tempInventory.remove(i);
            }
        }
    }

    private void pickUp(String substring, Player player) {
        String currentItem = substring;
        ArrayList<Item> tempInventory = player.getInventory();
        ArrayList<Item> tempItems = player.getCurrentRoom().getItems();
        for (int i = 0; i < tempItems.size(); i++) {
            if (currentItem.equals(tempItems.get(i).getItemName())) {
                tempInventory.add(new Item(tempItems.get(i).getItemName()));
                System.out.println("You pick up " + tempItems.get(i).getItemName() + " well done.");
                tempItems.remove(i);
            }
        }
    }


    private void lookAround(Player player) {
        System.out.println("You take a look at your surroundings...");
        System.out.println("You are in the" + player.getCurrentRoom().getName() + ". " + player.getCurrentRoom().getDescription());
        ArrayList<Item> tempItems = player.getCurrentRoom().getItems();
        printItems(tempItems);
    }

    private void helpInfo() {
        System.out.println("There is little help to be found here." +
                "\nType 'look' to get a description of your current room. " +
                "\nType '(n)orth', '(e)ast', '(s)outh', or '(w)est' to move in one of the cardinal directions." +
                "\nType 'take' + the item you want to pick up."+
                "\nType 'drop' + the item you want to drop."+
                "\nType 'inventory' to look at what you are carrying."+
                "\nType 'quit' to quit the game.");

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

    private void move(String command, Player player) {
        if (command.equals("n") || command.equals("e")  || command.equals("s") || command.equals("w")){
            if (player.move(command) == false){
                System.out.println("You can't go that way.");
            }else {System.out.println("You move to the " + player.getCurrentRoom().getName() + ". " + player.getCurrentRoom().getDescription());
                ArrayList<Item> temp = player.getCurrentRoom().getItems();
                    printItems(temp);}
    }
}

    private String parser (String input){

        String command = input + "zzzzzzzzzz"; // workaround, de 10 z'er

        if (command.startsWith("go ")){
            command = command.substring(3,4);
        }
        else if (command.startsWith("exit")){
            command = "q";

        }

        else
            command = command.substring(0, 1);


        return command;
    }

}