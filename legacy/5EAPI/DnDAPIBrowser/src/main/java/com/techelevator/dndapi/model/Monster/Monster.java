package com.techelevator.dndapi.model.Monster;

import com.techelevator.dndapi.model.*;
import com.techelevator.dndapi.model.Monster.*;

import java.util.List;

public class Monster {
    private String index;
    private String name;
    private String size;
    private String type;
    private String subtype;
    private String alignment;
    private int armor_class;
    private int hit_points;
    private String hit_dice;
    private Speed speed;
    private List<AbilityScore> ability_scores;
    private List<Proficiency> proficiencies;
    private Damage damage;
    private List<ConditionImmunity> condition_immunities;
    private List<Sense> senses;
    private List<Language> languages;
    private int challenge_rating;
    // getters and setters

    public Monster() {}

    public Monster(String index, String name, String size, String type, String subtype, String alignment, int armor_class, int hit_points, String hit_dice, Speed speed, List<AbilityScore> ability_scores, List<Proficiency> proficiencies, Damage damage, List<ConditionImmunity> condition_immunities, List<Sense> senses, List<Language> languages, int challenge_rating) {
        this.index = index;
        this.name = name;
        this.size = size;
        this.type = type;
        this.subtype = subtype;
        this.alignment = alignment;
        this.armor_class = armor_class;
        this.hit_points = hit_points;
        this.hit_dice = hit_dice;
        this.speed = speed;
        this.ability_scores = ability_scores;
        this.proficiencies = proficiencies;
        this.damage = damage;
        this.condition_immunities = condition_immunities;
        this.senses = senses;
        this.languages = languages;
        this.challenge_rating = challenge_rating;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getArmor_class() {
        return armor_class;
    }

    public void setArmor_class(int armor_class) {
        this.armor_class = armor_class;
    }

    public int getHit_points() {
        return hit_points;
    }

    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }

    public String getHit_dice() {
        return hit_dice;
    }

    public void setHit_dice(String hit_dice) {
        this.hit_dice = hit_dice;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public List<AbilityScore> getAbility_scores() {
        return ability_scores;
    }

    public void setAbility_scores(List<AbilityScore> ability_scores) {
        this.ability_scores = ability_scores;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public List<ConditionImmunity> getCondition_immunities() {
        return condition_immunities;
    }

    public void setCondition_immunities(List<ConditionImmunity> condition_immunities) {
        this.condition_immunities = condition_immunities;
    }

    public List<Sense> getSenses() {
        return senses;
    }

    public void setSenses(List<Sense> senses) {
        this.senses = senses;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public int getChallenge_rating() {
        return challenge_rating;
    }

    public void setChallenge_rating(int challenge_rating) {
        this.challenge_rating = challenge_rating;
    }
}