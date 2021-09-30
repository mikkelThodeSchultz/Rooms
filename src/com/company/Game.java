package com.company;

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Game {

    Scanner sc = new Scanner(System.in);
    boolean goAgain = true;
    Player player = new Player("pede");


    public void runGame() {

        System.out.println("You come to your senses... " +
                "\nYour head feels as if you have been hit with a mallet. " +
                "\nAs your eyes adjust to the surroundings, you realize that may just be the case. " +
                "\nYour bare feet stick to the tiled floor and whatever half-dried liquid covers it, the scent of decay is cloying. " +
                "\nYou think that it might be good idea to find an exit. " +
                "\nFast." +
                "\n(Type 'help' for a list of available commands)");

        while (goAgain) {
            String userInput = sc.nextLine();
            userInput.toLowerCase().trim();
            String command = userInput.substring(0,1);

            if (command.equals("n") || command.equals("e")  || command.equals("s") || command.equals("w")){
                player.move(command);
                if (player.getCurrentRoom() == (null)){
                    System.out.println("there is no door");
                }else System.out.println("You move to " + player.getCurrentRoom() + " " + player.getCurrentRoom().getDescription() + " " +
                        player.getCurrentRoom().getItems2());
            }

            switch (command) {

                case "i" : //TODO INVENTORY
                    break;
                case "q" : //TODO QUIT GAME
                    break;
                case "h" : //TODO HELP
                    break;
                case "p" : //TODO PUT ITEM
                    break;
                case "t" : //TODO TAKE ITEM
                    break;
                case "l" : //TODO LOOK
                    break;
                default: // TODO "Your input was not correct, try again"


            }
        }
    }
}