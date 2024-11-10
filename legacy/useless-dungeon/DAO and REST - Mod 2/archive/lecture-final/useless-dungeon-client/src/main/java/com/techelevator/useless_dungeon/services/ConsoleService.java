package com.techelevator.useless_dungeon.services;

import com.techelevator.useless_dungeon.model.*;

import java.util.Scanner;



//This is a utility class that is used for command line input and output.
public class ConsoleService {
    private final Scanner scanner = new Scanner(System.in);
    private final HeroService heroService = new HeroService("http://localhost:8080/hero");

    //System Output Methods
    public void printWelcomeMessage() {
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

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    public void printMissionMessage() {
        System.out.println("A local villager named Cletus Van Damm has wandered into this dangerous place. ");
        System.out.println("Your mission is to find Cletus and escape together. Both you and Cletus must survive the dungeon! ");
    }

    public void printRoomDescription(Room currentRoom){
        System.out.println("Welcome to room number " + currentRoom.getId());
        System.out.println(currentRoom.getDescription());
    }

    public void printMonsterDescription(Monster currentMonster){
        //Print out the Monster Description
        System.out.println("The room contains the following monster: ");
        System.out.println(currentMonster.getName());
    }

    public void printHeroAttack(Monster currentMonster, Hero myHero) {
        //Print out the Hero Attack Description
        System.out.println("You Attack!");
        //  System.out.println(currentMonster.getName() + " takes " + myHero.getHeroDamage() + " Damage!");
        System.out.println(currentMonster.getName() + "now has " + (currentMonster.getHealth() - 1) + " Health");
    }

    public void printMonsterAttack(Monster currentMonster) {
        //Print out the Monster Attack Description
        System.out.println(currentMonster.getName() + " attacks with " + currentMonster.getAttackDescription());
        System.out.println("You Are Dead.");
        System.out.println("Game Over.");
    }

    public void printGameOverMessage(){
        System.out.println("You Are Dead.");
        System.out.println("Game Over.");
    }


    //User Input Methods
    public Profession inputProfessionOptions(){
        boolean validInput = false;
        Scanner userInput = new Scanner(System.in);
        int selected = 0;

        while (!validInput) {
            System.out.println("Select from the following options (Numeric Input Only):");

            //Loop Through and Print out the Profession Options
            for (Profession profession : heroService.getListOfProfessions()) {
                System.out.println(profession.getProfessionId() + ":" + profession.getProfessionName());
            }
            //Make sure they only entered a number
            if (userInput.hasNext()) {
                String input = userInput.nextLine();
                if (input.matches("\\d+")) {
                    selected = Integer.parseInt(input);
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
        }

        return null;
        //return ProfessionGenerator.getBasicFantasyProfessions().get(selected-1);
    }
    public Hero inputHeroOptions() {
        Scanner userInput = new Scanner(System.in);
        String characterName;
        Profession characterProfession;

        System.out.println("What is your name?");
        characterName = userInput.nextLine();
        characterProfession = inputProfessionOptions();
        //Default Character Name if no input
        if (characterName.isEmpty()){
            characterName = "Sir Larry";
        }

        //Initialize the My Hero Object
        Hero myHero = new Hero(characterName, 1, 1, characterProfession);
        System.out.println("Welcome " + myHero.getName() + " the " + myHero.getProfession().getProfessionName());
        System.out.println("You are armed with: " + myHero.getProfession().getStartingWeapon());

        //Return the generated Hero
        return myHero;
    }

    public int inputCombatOptions() {
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

    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }
    public int inputExplorationOptions(){
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

}
