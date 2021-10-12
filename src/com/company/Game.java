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
        player.getCurrentRoom().enteredRoom();

        while (goAgain) {

            String input = sc.nextLine().toLowerCase().trim();
            String command = "";
            String object = "";


            if (input.contains(" ")) {
                command = input.substring(0, input.lastIndexOf(" "));
                object = input.substring(input.indexOf(" ") + 1);
            } else {
                command = input;
            }

            switch (command) {
                case "n", "e", "s", "w", "go", "north", "east", "south", "west":
                    if (command.startsWith("go")) {
                        object = object.substring(0, 1);
                        move(object, player);
                    } else {
                        command = command.substring(0, 1);
                        move(command, player);
                    }
                    break;
                case "a", "attack":
                    if (command.startsWith("attack")){
                        if (player.getCurrentWeapon() instanceof ShootingWeapon){
                            if (((ShootingWeapon) player.getCurrentWeapon()).getAmmo() <= 0){
                                System.out.println("You have no ammo left");
                                break;
                            }
                        }
                        attackSequence(player, object);
                    }
                    break;
                case "i", "inventory":
                    printInventory(player.getInventory());
                    break;
                case "q", "quit", "exit":
                    System.out.println("Leave now, and newer, come back!");
                    goAgain = false;
                    break;
                case "h", "help":
                    helpInfo();
                    break;
                case "d", "drop":
                    boolean itemDropped = player.drop(object);
                    if (itemDropped) {
                        System.out.println("You droppped " + object + " in the " + player.getCurrentRoom().getName() + ".");
                    } else {
                        System.out.println("You are not carrying '" + object + "' in your inventory");
                    }
                    break;
                case "t", "take":
                    System.out.println(player.take(object));
                    break;
                case "l", "look":
                    lookAround(player);
                    break;
                case "health":
                    // health
                    System.out.println(whatIsMyHealth(player));
                    System.out.println("You are at " + player.getHealth() + " health points.");
                    break;
                case "f", "eat":
                    Status eatStatus = player.eat(object);
                    switch (eatStatus) {
                        case NOTFOUND -> System.out.println("There is no " + object + ".");
                        case CANT -> System.out.println("You can't eat " + object + ".");
                        case OKAY -> System.out.println("You've eaten " + object + ". You are now at " + player.getHealth() + " health.");
                    }
                    break;
                case "equip":
                    Status weaponStatus = player.equip(object);
                    switch (weaponStatus) {
                        case NOTFOUND -> System.out.println("There is no " + object + ".");
                        case CANT -> System.out.println("You can't equip " + object + ".");
                        case OKAY -> System.out.println("You've equipped " + object + ".");
                    }
                    break;
                default:
                    System.out.println("Your input was not registered. Type 'help' for a list of possible commands.");

            }
            if (player.getHealth() <= 0){
                System.out.println("You have died");
                goAgain = false;
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

    private void lookAround(Player player) {
        System.out.println("You take a look at your surroundings...");
        System.out.println(player.getCurrentRoom().getDescription());
        ArrayList<Item> itemsRoom = player.getCurrentRoom().getItems();
        printItems(itemsRoom);
        ArrayList<Enemy> enemiesRoom = (player.getCurrentRoom().getRoomEnemies());
        printEnemies(enemiesRoom);
    }

    private void printEnemies(ArrayList<Enemy> enemiesRoom) {

        String result = "You see ";
        for (int i = 0; i < enemiesRoom.size(); i++) {

            if (i == enemiesRoom.size() -1){
                result += enemiesRoom.get(i).getEnemyDescription() + "!";
            }
        } if (result.equals("You see ")) {
            result = "";
        }
        System.out.println(result);
    }

    private void helpInfo() {
        System.out.println("There is little help to be found here." +
                "\nType 'look' to get a description of your current room. " +
                "\nType '(n)orth', '(e)ast', '(s)outh', or '(w)est' to move in one of the cardinal directions." +
                "\nType 'take' + the item you want to pick up." +
                "\nType 'drop' + the item you want to drop." +
                "\nType 'equip + the item you want to equip." +
                "\nType 'eat' + the food you want to eat." +
                "\nType 'attack' + the target you want to attack." +
                "\nType 'health' to see your health points." +
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
                ArrayList<Enemy> enemiesRoom = (player.getCurrentRoom().getRoomEnemies());
                printItems(itemsRoom);
                printEnemies(enemiesRoom);
            }
        }
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

    public void attackSequence(Player player, String target){
        Enemy enemy = player.findEnemy(target);


        if (player.attackEnemy(target, player)){
            System.out.println("You attack " + target + " with " + player.getCurrentWeapon().getItemName() + " dealing "
                    + player.getCurrentWeapon().getDamageRating() + " damage.");
            System.out.println("The " + enemy.getName() + " attacks you with " + enemy.getEnemyWeapon().getItemName()
                    + " dealing "
                    + enemy.getEnemyWeapon().getDamageRating()
                    + " damage.");
            if (player.getCurrentWeapon()instanceof ShootingWeapon){
                ((ShootingWeapon) player.getCurrentWeapon()).decreasingAmmo();
            }


            if (enemy.getHealth()<= 0){
                System.out.println("yay, you have won");
                player.getCurrentRoom().addItem(enemy.getEnemyWeapon());
                player.getCurrentRoom().removeEnemy(enemy);
            }

        } else {
            System.out.println("There is no such enemy in the room.");
    }


    }
}