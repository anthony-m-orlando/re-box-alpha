package com.techelevator.model;

import java.util.List;

public class Creature {

    private int creatureId;
    private String name;
    private String creatureType;

    private String creatureSubType;

    private String organization;

    private String size;
    private String alignment;

    private String armorType;
    private int armorClass;

    private int  challengeRating;

    private int hitPoints;

    private int speed = 30;//TODO: make this a list of speeds

    private String hitDice;

    private int strength;

    private int dexterity;

    private int constitution;

    private int intelligence;

    private int wisdom;

    private int charisma;

    private String aiType;

    private String imageName;
    List<Action> actions;

    List<Trait> traits;

    List<Language> languages;

    List<Proficiency> proficiencies;

    List<Save> saves;


    public Creature() {

    }

public Creature(int creatureId, String name, String creatureType, String creatureSubType, String organization, String size, String alignment, String armorType, int armorClass, int challengeRating, int hitPoints, int speed, String hitDice, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String aiType, String imageName, List<Action> actions, List<Trait> traits, List<Language> languages, List<Proficiency> proficiencies, List<Save> saves) {
        this.creatureId = creatureId;
        this.name = name;
        this.creatureType = creatureType;
        this.creatureSubType = creatureSubType;
        this.organization = organization;
        this.size = size;
        this.alignment = alignment;
        this.armorType = armorType;
        this.armorClass = armorClass;
        this.challengeRating = challengeRating;
        this.hitPoints = hitPoints;
        this.speed = speed;
        this.hitDice = hitDice;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.aiType = aiType;
        this.imageName = imageName;
        this.actions = actions;
        this.traits = traits;
        this.languages = languages;
        this.proficiencies = proficiencies;
        this.saves = saves;
    }

    public int getCreatureId() {
        return creatureId;
    }

    public void setCreatureId(int creatureId) {
        this.creatureId = creatureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(String creatureType) {
        this.creatureType = creatureType;
    }

    public String getCreatureSubType() {
        return creatureSubType;
    }

    public void setCreatureSubType(String creatureSubType) {
        this.creatureSubType = creatureSubType;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public int getArmorClass() {
            return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getChallengeRating() {
        return challengeRating;
    }

    public void setChallengeRating(int challengeRating) {
        this.challengeRating = challengeRating;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getHitDice() {
        return hitDice;
    }

    public void setHitDice(String hitDice) {
        this.hitDice = hitDice;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity(){
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public String getAiType() {
        return aiType;
    }

    public void setAiType(String aiType) {
        this.aiType = aiType;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<Save> getSaves() {
        return saves;
    }

    public void setSaves(List<Save> saves) {
        this.saves = saves;
    }
}
