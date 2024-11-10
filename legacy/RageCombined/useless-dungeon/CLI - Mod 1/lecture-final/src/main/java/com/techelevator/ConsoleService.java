package com.techelevator;

import com.techelevator.builders.ProfessionBuilder;
import com.techelevator.model.*;

import java.util.Scanner;

//This is a utility class that is used for command line input and output.
public class ConsoleService {

    //System Output Methods
    public static void printWelcomeMessage(){
        System.out.println("Welcome to the useless dungeon. ");
        System.out.println("You will find this game impossible to beat!");
        System.out.println("Good Luck!");
    }


    public static void printMissionMessage() {
        System.out.println("A local villager named Cletus Van Damm has wandered into this dangerous place. ");
        System.out.println("Your mission is to find Cletus and escape together. Both you and Cletus must survive the dungeon! ");
    }

    public static void printRoomDescription(Room currentRoom){
        System.out.println("Welcome to room number " + currentRoom.getId());
        System.out.println(currentRoom.getDescription());
    }

    public static void printMonsterDescription(Monster currentMonster){
        //Print out the Monster Description
        System.out.println("The room contains the following monster: ");
        System.out.println(currentMonster.getName());
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


    //User Input Methods
    public static Profession inputProfessionOptions(){
        boolean validInput = false;
        Scanner userInput = new Scanner(System.in);
        int selected = 0;

        while (!validInput) {
            System.out.println("Select from the following options (Numeric Input Only):");
            //Loop Through and Print out the Profession Options
            for (Profession profession : ProfessionBuilder.getBasicFantasyProfessions()) {
                System.out.println(profession.getProfessionId() + ":" + profession.getProfessionName());
            }
            //Make sure they only entered a number
            if (userInput.hasNextInt()){
                selected = userInput.nextInt();
                validInput = true;
            }
        }

        return ProfessionBuilder.getBasicFantasyProfessions().get(selected-1);
    }
    public static Hero inputHeroOptions() {
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
        Hero myHero = new Hero(characterName, 1,1, characterProfession);
        System.out.println("Welcome " + myHero.getName() + " the " + myHero.getProfession().getProfessionName());
        System.out.println("You are armed with: " + myHero.getProfession().getStartingWeapon());

        //Return the generated Hero
        return myHero;
    }

    public static int inputCombatOptions() {
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

    public static int inputExplorationOptions(){
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
