package com.techelevator.model;

public class Save {
    private String ability;

    public int modifier;

    public Save(String ability, int modifier) {
        this.ability = ability;
        this.modifier = modifier;
    }

    public Save() {

    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }


}
