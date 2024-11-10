package com.techelevator.dndapi.model.CharacterClass;

import com.techelevator.dndapi.model.AbilityScore;

public class Prerequisite {
    private AbilityScore ability_score;
    private int minimum_score;
    // getters and setters

    public Prerequisite() {}

    public Prerequisite(AbilityScore ability_score, int minimum_score) {
        this.ability_score = ability_score;
        this.minimum_score = minimum_score;
    }

    public AbilityScore getAbility_score() {
        return ability_score;
    }

    public void setAbility_score(AbilityScore ability_score) {
        this.ability_score = ability_score;
    }

    public int getMinimum_score() {
        return minimum_score;
    }

    public void setMinimum_score(int minimum_score) {
        this.minimum_score = minimum_score;
    }


}
