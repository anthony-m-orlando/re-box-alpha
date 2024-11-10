package com.techelevator.useless_dungeon.model;
/**********************************************************************************************************************/
/** Useless Dungeon Profession - this will determine the initial stats of the Hero                                    */
/**                                                                                                                   */
/** Author: AMO     1/31/24                                                                                           */
/** Revision Log:																			                          */
/**     																					                          */
/**********************************************************************************************************************/
/**********************************************************************************************************************/
public class Profession {
    private int professionId;
    private String professionName;
    private int startingHealth;
    private int startingDefense;
    private int startingAttack;
    private String startingWeapon;

    public Profession(int professionId, String professionName, int startingHealth, int startingDefense, int startingAttack, String startingWeapon) {
        this.professionId = professionId;
        this.professionName = professionName;
        this.startingHealth = startingHealth;
        this.startingDefense = startingDefense;
        this.startingAttack = startingAttack;
        this.startingWeapon = startingWeapon;
    }

    public String getStartingWeapon() {
        return startingWeapon;
    }

    public void setStartingWeapon(String startingWeapon) {
        this.startingWeapon = startingWeapon;
    }

    public int getProfessionId() {
        return professionId;
    }

    public void setProfessionId(int professionId) {
        this.professionId = professionId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    public void setStartingHealth(int startingHealth) {
        this.startingHealth = startingHealth;
    }

    public int getStartingDefense() {
        return startingDefense;
    }

    public void setStartingDefense(int startingDefense) {
        this.startingDefense = startingDefense;
    }

    public int getStartingAttack() {
        return startingAttack;
    }

    public void setStartingAttack(int startingAttack) {
        this.startingAttack = startingAttack;
    }
}
