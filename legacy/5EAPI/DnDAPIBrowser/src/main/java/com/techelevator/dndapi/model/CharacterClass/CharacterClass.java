package com.techelevator.dndapi.model.CharacterClass;

import com.techelevator.dndapi.model.Proficiency;
import com.techelevator.dndapi.model.ProficiencyChoice;
import com.techelevator.dndapi.model.SavingThrow;

import java.util.List;

public class CharacterClass {
    private String index;
    private String name;
    private String hit_die;

    private List<ProficiencyChoice> proficiency_choices;
    private List<Proficiency> proficiencies;
    private List<SavingThrow> saving_throws;
    private List<StartingEquipment> starting_equipment;
    private List<StartingEquipmentOption> starting_equipment_options;
    private String class_levels;
    private MultiClassing multi_classing;
    private List<Subclass> subclasses;
    private String url;


    public CharacterClass(){};
    public CharacterClass(String index, String name, String hit_die) {
        this.index = index;
        this.name = name;
        this.hit_die = hit_die;
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

    public String getHit_die() {
        return hit_die;
    }

    public void setHit_die(String hit_die) {
        this.hit_die = hit_die;
    }

    public List<ProficiencyChoice> getProficiency_choices() {
        return proficiency_choices;
    }

    public void setProficiency_choices(List<ProficiencyChoice> proficiency_choices) {
        this.proficiency_choices = proficiency_choices;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<SavingThrow> getSaving_throws() {
        return saving_throws;
    }

    public void setSaving_throws(List<SavingThrow> saving_throws) {
        this.saving_throws = saving_throws;
    }

    public List<StartingEquipment> getStarting_equipment() {
        return starting_equipment;
    }

    public void setStarting_equipment(List<StartingEquipment> starting_equipment) {
        this.starting_equipment = starting_equipment;
    }

    public List<StartingEquipmentOption> getStarting_equipment_options() {
        return starting_equipment_options;
    }

    public void setStarting_equipment_options(List<StartingEquipmentOption> starting_equipment_options) {
        this.starting_equipment_options = starting_equipment_options;
    }

    public String getClass_levels() {
        return class_levels;
    }

    public void setClass_levels(String class_levels) {
        this.class_levels = class_levels;
    }

    public MultiClassing getMulti_classing() {
        return multi_classing;
    }

    public void setMulti_classing(MultiClassing multi_classing) {
        this.multi_classing = multi_classing;
    }

    public List<Subclass> getSubclasses() {
        return subclasses;
    }

    public void setSubclasses(List<Subclass> subclasses) {
        this.subclasses = subclasses;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
