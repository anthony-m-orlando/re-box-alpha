package com.techelevator.model.main;

public class Hero extends Creature {


    private Profession profession;
    private int attack;

    public Hero() {
    }

    public Hero(Profession profession) {
        this.setProfession(profession);
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
        this.setAttack(profession.getStartingAttack());
        this.setHealth(profession.getStartingHealth());
        this.setDefense(profession.getStartingDefense());
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}
