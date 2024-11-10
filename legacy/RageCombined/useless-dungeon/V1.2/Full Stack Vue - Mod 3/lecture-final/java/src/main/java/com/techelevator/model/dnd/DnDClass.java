package com.techelevator.model.dnd;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DnDClass {
    public String index;
    public String name;
    public int hit_die;
    public ArrayList<SavingThrow> saving_throws;
    @JsonProperty("starting_equipment")
    public ArrayList<EquipmentSlot> startingEquipment;
    public ArrayList<Proficiency> proficiencies;
    public String class_levels;
    public String url;

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

    public int getHit_die() {
        return hit_die;
    }

    public void setHit_die(int hit_die) {
        this.hit_die = hit_die;
    }

    public ArrayList<SavingThrow> getSaving_throws() {
        return saving_throws;
    }

    public void setSaving_throws(ArrayList<SavingThrow> saving_throws) {
        this.saving_throws = saving_throws;
    }

    public ArrayList<EquipmentSlot> getStartingEquipment() {
        return startingEquipment;
    }

    public void setStartingEquipment(ArrayList<EquipmentSlot> startingEquipment) {
        this.startingEquipment = startingEquipment;
    }


    public String getClass_levels() {
        return class_levels;
    }

    public void setClass_levels(String class_levels) {
        this.class_levels = class_levels;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(ArrayList<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }
}
