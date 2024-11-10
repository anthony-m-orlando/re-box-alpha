package com.techelevator.model.main;

import com.techelevator.model.main.Creature;

public class Monster extends Creature {

    private String attackDescription;
    private int attack;

    public Monster() {
    }

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
