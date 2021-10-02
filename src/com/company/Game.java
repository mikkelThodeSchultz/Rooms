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
            String userInput = sc.nextLine().toLowerCase().replaceAll("//s","");

            String command = parser(userInput);
            //String command = userInput.substring(0,1);//TODO piletasterne får programmet til at crashe her.

            switch (command) {
                case "n":
                case "e":
                case "s":
                case "w":
                    move(command, player);
                    break;

                case "i" :
                    player.getInventory();
                    break;

                case "q" :
                    goAgain = false;
                    break;

                case "h" : helpInfo();
                    break;
                case "d" : //TODO PUT ITEM - drop
                    break;
                case "t" : //TODO TAKE ITEM
                    break;
                case "l" : lookAround(player);
                    break;
                default:
                    System.out.println("Your input was not registered. Type 'help' for a list of possible commands.");


            }
        }
    }

    private void lookAround(Player player) {
        System.out.println("You take a look at your surroundings...");
        System.out.println("You are in the" + player.getCurrentRoom().getName() + ". " + player.getCurrentRoom().getDescription());
        ArrayList<Item> temp = player.getCurrentRoom().getItems2();
        printItems(temp);
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
            }else {System.out.println("You move to " + player.getCurrentRoom().getName() + " " + player.getCurrentRoom().getDescription());
                ArrayList<Item> temp = player.getCurrentRoom().getItems2();
                    printItems(temp);}
    }
}

    private String parser(String input){

        String command = input+"zzzzzzzzzz";

        if (command.substring(0,3).equals("go ")){
            command = command.substring(3,4);
        }
        else if (command.substring(0,4).equals("exit")){
            command = "q";
        }
        else if (command.substring(0,7).equals("pick up")){
            command = command.substring(8);
            //TODO metode til at håndtere identificering af ting man samler op.
        }
        else if (command.substring(0,4).equals("drop")){
            command = command.substring(5);
            //TODO metode til at identificere ting man vil smide.
        }
        else if (command.substring(0,1).equals(null)){
            command = null;
        } else
            command = command.substring(0,1);

        return command;
    }

}