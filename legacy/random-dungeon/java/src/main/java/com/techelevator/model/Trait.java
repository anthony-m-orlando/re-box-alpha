package com.techelevator.model;

public class Trait {

    private int traitId;

    private String description;

    public Trait() {

    }

    public Trait(int traitId, String description) {
        this.traitId = traitId;
        this.description = description;
    }

    public int getTraitId() {
        return traitId;
    }

    public void setTraitId(int traitId) {
        this.traitId = traitId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
