package com.techelevator.model;

public class Hero {

    private int heroId;
    private String name;
    private int level;
    private int primaryClassId;
    private int heroRaceId;
    private int perception;
    private int height;
    private String primary_profession_name;

    private String heroSpecies;

    private String imageFile;

    private int initiative=0;

    public Hero() {
    }

    public Hero(int heroId, String name, int level, int primaryClassId, int heroRaceId, int perception, int height, String primary_profession_name, String heroSpecies, String imageFile) {
        this.heroId = heroId;
        this.name = name;
        this.level = level;
        this.primaryClassId = primaryClassId;
        this.heroRaceId = heroRaceId;
        this.perception = perception;
        this.height = height;
        this.primary_profession_name = primary_profession_name;
        this.heroSpecies = heroSpecies;
        this.imageFile = imageFile;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPrimaryClassId() {
        return primaryClassId;
    }

    public void setPrimaryClassId(int primaryClassId) {
        this.primaryClassId = primaryClassId;
    }

    public int  getHeroRaceId() {
        return heroRaceId;
    }

    public void setHeroRaceId(int heroRaceId) {
        this.heroRaceId = heroRaceId;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPrimary_profession_name() {
        return primary_profession_name;
    }

    public void setPrimary_profession_name(String primary_profession_name) {
        this.primary_profession_name = primary_profession_name;
    }

    public String getHeroSpecies() {
        return heroSpecies;
    }

    public void setHeroSpecies(String heroSpecies) {
        this.heroSpecies = heroSpecies;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
}
