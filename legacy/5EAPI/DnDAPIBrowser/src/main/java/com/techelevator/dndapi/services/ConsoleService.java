package com.techelevator.dndapi.services;

import java.util.Scanner;

import com.techelevator.dndapi.model.*;
import com.techelevator.dndapi.model.CharacterClass.CharacterClass;
import com.techelevator.dndapi.model.CharacterClass.StartingEquipment;
import com.techelevator.dndapi.model.CharacterClass.StartingEquipmentOption;
import com.techelevator.dndapi.model.CharacterClass.Subclass;
import com.techelevator.dndapi.model.Monster.Monster;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection() {
        int menuSelection;
        System.out.print("Please choose an option: ");
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("----Dungeons and Dragons Open API---");
        System.out.println("1: List all Character Classes");
        System.out.println("2: List details for a specific Character Class");
        System.out.println("3: List all  Monsters");
        System.out.println("4: List details for a specific Monster");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printClassList(Root classList) {
        int classID = 0;
        if (classList != null) {
            System.out.println("--------------------------------------------");
            System.out.println("Character Classes");
            System.out.println("--------------------------------------------");
            for (Result index : classList.getResults())
            {
                classID++;
                System.out.println(classID + "--" +index.getName());
            }
        }
    }

    public void printMonsterList(Root monsterList) {
        int monsterID=0;
        if (monsterList != null) {
            System.out.println("--------------------------------------------");
            System.out.println("Monsters");
            System.out.println("--------------------------------------------");
            for (Result index : monsterList.getResults())
            {
                monsterID++;
                System.out.println(monsterID + " -- " + index.getName());
            }
        }
    }

    public void printCharacterClassDetails(CharacterClass characterClass){
        if (characterClass != null){
            System.out.println("Character Class: " + characterClass.getName());
            System.out.println("Hit Die: " + characterClass.getHit_die());
            System.out.println(("Proficiencies: "));
            for (Proficiency proficiency : characterClass.getProficiencies()){
                System.out.println(proficiency.getName());
            }
            System.out.println("Saving Throws: ");
            for (SavingThrow savingThrow : characterClass.getSaving_throws()){
                System.out.println(savingThrow.getName());
            }
            System.out.println("Subclasses: ");
            for (Subclass subclass : characterClass.getSubclasses()){
                System.out.println(subclass.getName());
            }
            System.out.println("Starting Equipment: ");
            for (StartingEquipment startingEquipment : characterClass.getStarting_equipment()){
                System.out.println(startingEquipment.getEquipment().getName());
            }
            System.out.println("Starting Equipment Options: ");
            for (StartingEquipmentOption startingEquipmentOption : characterClass.getStarting_equipment_options()){
                System.out.println(startingEquipmentOption.getChoose() + " " + startingEquipmentOption.getType());
            }
            //TODO: Add Class Level Sub Structure
        }
    }

    public String promptForCharacterClass() {
        System.out.println("--------------------------------------------");
        System.out.print("Enter the id of the Character Class you would like to view: ");
        return scanner.nextLine();
    }

    public void printMonstersDetails(Monster monster){
        if (monster != null){
            System.out.println("Monster Name: " + monster.getName());
            System.out.println("Alignment: " + monster.getAlignment());
            System.out.println("Hit Points" + monster.getHit_points());
        }
    }

    public String promptForMonster() {
        System.out.println("--------------------------------------------");
        System.out.print("Enter the id of the Monster you would like to view: ");
        return scanner.nextLine();
    }

}
