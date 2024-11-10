package com.techelevator.model;

/**********************************************************************************************************************/
/** Useless Dungeon Monster - This is the Monster class for all monsters in the dungeon.                              */
/**                                                                                                                   */
/** Author: AMO     1/31/24                                                                                           */
/** Revision Log:																			                          */
/**     																					                          */
/**********************************************************************************************************************/
/**********************************************************************************************************************/
public class Monster extends Creature implements Combatable{
    private int monsterId;
    private String attackDescription; //Each Monster has a different attack
    private int attack; //This will be used to subtract from the hero's health when the monster attacks

    public Monster(int monsterId, String name, int health, int defense,  String attackDescription, int attack) {
        super(name, health, defense);
        this.monsterId = monsterId;
        this.attackDescription = attackDescription;
        this.attack = attack;
    }
    public Monster(){}

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public String getAttackDescription() {
        return attackDescription;
    }

    public void setAttackDescription(String attackDescription) {
        this.attackDescription = attackDescription;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
