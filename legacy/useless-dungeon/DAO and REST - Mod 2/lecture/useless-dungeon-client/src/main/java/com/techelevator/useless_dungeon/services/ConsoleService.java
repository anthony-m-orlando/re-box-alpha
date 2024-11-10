package com.techelevator.useless_dungeon.services;

import com.techelevator.useless_dungeon.model.*;
import com.techelevator.useless_dungeon.model.security.UserCredentials;

import java.util.List;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public void printGreeting() {
        System.out.println("Welcome to the useless dungeon.");
        System.out.println("You will find this game impossible to beat!");
        System.out.println("Good Luck!");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: Select a Hero");
        System.out.println("2: Create a new Hero");
        System.out.println("3: Start the Game");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

    public void printListOfHeroes(List<Hero> heroes) {
        System.out.println("Heroes:");
        for (Hero hero : heroes) {
            System.out.println(hero.getId() + " -- " + hero.getName());
        }
    }

    public void printHero(Hero hero) {
        System.out.println("Selected Hero:");
        System.out.println(hero.getName());
        System.out.println("Health: " + hero.getHealth());
        System.out.println("Attack: " + hero.getAttack());
        System.out.println("Defense: " + hero.getDefense());
    }
    public static void printMonsterDescription(Monster currentMonster){
        //Print out the Monster Description
        System.out.println("The room contains the following monster: ");
        System.out.println(currentMonster.getName());
    }

    public static void printRoomDescription(Room currentRoom){
        System.out.println("Welcome to room number " + currentRoom.getId());
        System.out.println(currentRoom.getDescription());
    }
    public static void printHeroAttack(Monster currentMonster, Hero myHero) {
        //Print out the Hero Attack Description
        System.out.println("You Attack!");
        //  System.out.println(currentMonster.getName() + " takes " + myHero.getHeroDamage() + " Damage!");
        System.out.println(currentMonster.getName() + "now has " + (currentMonster.getHealth() - 1) + " Health");
    }

    public static void printMonsterAttack(Monster currentMonster) {
        //Print out the Monster Attack Description
        System.out.println(currentMonster.getName() + " attacks with " + currentMonster.getAttackDescription());
        System.out.println("You Are Dead.");
        System.out.println("Game Over.");
    }

    public static void printGameOverMessage(){
        System.out.println("You Are Dead.");
        System.out.println("Game Over.");
    }

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }


    public static int promptForCombatOptions() {
        boolean validInput = false;
        Scanner userInput = new Scanner(System.in);
        int selected = 0;

        while (!validInput){
            System.out.println("Please Choose from the following options: ");
            System.out.println("1 -> Attack!");
            System.out.println("2 -> Run Away!");
            System.out.println("3 -> Surrender!");
            System.out.println("4 -> Try Anything! (Choose Randomly)");
            if (userInput.hasNextInt()){
                selected = userInput.nextInt();
                validInput = true;
            }
        }
        return selected;
    }

    public static int promptForExplorationOptions(){
        boolean validInput = false;
        Scanner userInput = new Scanner(System.in);
        int selected = 0;
        while (!validInput){
            System.out.println("Please Choose from the following options: ");
            System.out.println("1 -> Stay here a while!");
            System.out.println("2 -> Move through the door!");
            System.out.println("3 -> Surrender!");
            if (userInput.hasNextInt()){
                selected = userInput.nextInt();
                validInput = true;
            }
        }
        return selected;

    }

    public Hero promptForHeroDetails() {
        System.out.println("Enter the following information to create a new hero:");
        Hero newHero = new Hero();
        newHero.setName(promptForString("Name: "));
        return newHero;
    }

    public Profession promptForProfessionOptions(List<Profession> professions) {
        System.out.println("Select from the following options (Numeric Input Only):");
        for (Profession profession : professions) {
            System.out.println(profession.getProfessionId() + ":" + profession.getProfessionName());
        }
        int selected = promptForInt("Profession: ");
        for (Profession profession : professions) {
            if (profession.getProfessionId() == selected) {
                return profession;
            }
        }
        return null;
    }
    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
              return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

}
