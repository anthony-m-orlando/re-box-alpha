package com.techelevator.useless_dungeon.model;

/**********************************************************************************************************************/
/** Useless Dungeon Monster - This is the Monster class for all monsters in the dungeon.                              */
/**                                                                                                                   */
/** Author: AMO     1/31/24                                                                                           */
/** Revision Log:																			                          */
/**     																					                          */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

public class Monster extends Creature implements Combatable{
    private String attackDescription; //Each Monster has a different attack
    private int attack; //This will be used to subtract from the hero's health when the monster attacks
    static int monsterCount=0; //This keeps track of how many monsters have been created

    public Monster(String name, int health, int defense, String attackDescription, int attack) {
        super(name, health, defense);
        this.attackDescription = attackDescription;
        this.attack = attack;
        monsterCount++;
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
