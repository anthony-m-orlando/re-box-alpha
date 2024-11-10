package com.techelevator.model;

public class Proficiency {

    private int proficiencyId;

    private Skill skill;

    private int modifier;

    public Proficiency() {

    }

    public Proficiency(int proficiencyId, Skill skill, int modifier) {
        this.proficiencyId = proficiencyId;
        this.skill = skill;
        this.modifier = modifier;
    }

    public int getProficiencyId() {
        return proficiencyId;
    }

    public void setProficiencyId(int proficiencyId) {
        this.proficiencyId = proficiencyId;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

}
