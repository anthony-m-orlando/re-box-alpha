package com.techelevator.model;

public class Skill {
    private int skillId;
    private String name;
    private String description;

    private String abilityScore;

    public Skill() {

    }

    public Skill(int skillId, String name, String description, String abilityScore) {
        this.skillId = skillId;
        this.name = name;
        this.description = description;
        this.abilityScore = abilityScore;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityScore(String abilityScore) {
        this.abilityScore = abilityScore;
    }


}
