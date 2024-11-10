package com.techelevator.model;

public class Species {
    private int speciesId;
    private String speciesName;

    private int speciesDarkVision;

    public Species() {
    }

    public Species(int speciesId, String speciesName, int speciesDarkVision) {
        this.speciesId = speciesId;
        this.speciesName = speciesName;
        this.speciesDarkVision = speciesDarkVision;
    }

    public int getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(int speciesId) {
        this.speciesId = speciesId;
    }

    public String getSpeciesName(){
        return speciesName;
    }

    public void setSpeciesName(String speciesName){
        this.speciesName = speciesName;
    }

    public int getSpeciesDarkVision(){
        return speciesDarkVision;
    }

    public void setSpeciesDarkVision(int speciesDarkVision){
        this.speciesDarkVision = speciesDarkVision;
    }

}
