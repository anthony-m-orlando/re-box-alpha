package com.techelevator.model;
/**********************************************************************************************************************/
/** Useless Dungeon Hero - this will represent the player.                                                            */
/** The class is marked Final since this is the only version of Hero that should exist.                               */
/** Author: AMO     1/31/24                                                                                           */
/** Revision Log:																			                          */
/**     																					                          */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

public final class Hero extends Creature implements Combatable {
    private Profession profession; //Every Hero needs a profession
    private int attack; //The Current Attack of the Hero

    public Hero(String name, int health, int defense, Profession heroProfession) {
        super(name, heroProfession.getStartingHealth(), heroProfession.getStartingDefense());
        this.profession = heroProfession;
        this.attack = heroProfession.getStartingAttack();
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
