package com.techelevator.useless_dungeon.model;

/**********************************************************************************************************************/
/** Useless Dungeon Creature this will be the parent class for all creatures in the dungeon (Hero, Monster, etc...    */
/** Author: AMO     1/31/24                                                                                           */
/** Revision Log:																			                          */
/**     																					                          */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

public abstract class Creature {

    private static int creatureCount; //This will keep a count of how many creatures are instantiated
    private int id; //The Unique ID of the Creature (All Creatures in the program must have a unique ID
    private String name; //The name of the creature
    private int health; //How much health does the creature have
    private int defense; //Useless Defense Rating for now until attacks have a chance to miss. At this point all attacks automatically hit.

    //Manual Constructor
    public Creature(String name, int health, int defense) {
        this.name = name;
        this.health = health;
        this.defense = defense;
        creatureCount++;
        this.id = creatureCount;
    }
    //Default Constructor (This will be important when we get to the DAO pattern
    public Creature(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    public int getDefense() {
        return defense;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
}