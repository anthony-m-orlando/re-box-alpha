package com.techelevator.useless_dungeon.model;

/**********************************************************************************************************************/
/** Useless Dungeon Monster - This is the Monster class for all monsters in the dungeon.                              */
/**                                                                                                                   */
/** Author: AMO     1/31/24                                                                                           */
/** Revision Log:																			                          */
/**     		    6/25/24 - AMO - Removed Static ID Generation																			                          */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

public class Monster extends Creature implements Combatable{
    private String attackDescription; //Each Monster has a different attack
    private int attack; //This will be used to subtract from the hero's health when the monster attacks

    public Monster(int id, String name, int health, int defense, String attackDescription, int attack) {
        super(id, name, health, defense);
        this.attackDescription = attackDescription;
        this.attack = attack;
    }

    public Monster(){}

    public String getAttackDescription() {
        return attackDescription;
    }

    public void setAttackDescription(String attackDescription) {
        this.attackDescription = attackDescription;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}