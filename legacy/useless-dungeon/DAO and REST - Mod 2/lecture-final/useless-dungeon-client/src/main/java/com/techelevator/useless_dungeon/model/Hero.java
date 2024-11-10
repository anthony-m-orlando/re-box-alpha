package com.techelevator.useless_dungeon.model;

/**********************************************************************************************************************/
/** Useless Dungeon Hero - this will represent the player.                                                            */
/** The class is marked Final since this is the only version of Hero that should exist.                               */
/** Author: AMO     1/31/24                                                                                           */
/** Revision Log:																			                          */
/**     			6/25/24 - AMO - Refactored Constructor to account for static ID change																	                          */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

public final class Hero extends Creature implements Combatable {
    private Profession profession; //Every Hero needs a profession
    private int attack; //The Current Attack of the Hero

    public Hero(int id, String name, Profession profession) {
        super(id, name, profession.getStartingHealth(),profession.getStartingDefense());
        this.profession = profession;
        this.attack = profession.getStartingAttack();
    }

    public Hero(){}

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}