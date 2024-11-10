package com.techelevator.model;

public class Trap {

    private int trapId;
    private String name;
    private int challengeRating;
    private int disableDC;
    private int findDC;
    private String description;
    private boolean visible = false;
    private String imageFile;
    public Trap() {
    }

    public Trap(int trapId, String name, int challengeRating, int disableDC, int findDC, String description,String imageFile) {
        this.trapId = trapId;
        this.name = name;
        this.challengeRating = challengeRating;
        this.disableDC = disableDC;
        this.findDC = findDC;
        this.description = description;
        this.imageFile = imageFile;
    }

    public int getTrapId() {
        return trapId;
    }

    public void setTrapId(int trapId) {
        this.trapId = trapId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChallengeRating() {
        return challengeRating;
    }

    public void setChallengeRating(int challengeRating) {
        this.challengeRating = challengeRating;
    }

    public int getDisableDC() {
        return disableDC;
    }

    public void setDisableDC(int disableDC) {
        this.disableDC = disableDC;
    }

    public int getFindDC() {
        return findDC;
    }

    public void setFindDC(int findDC) {
        this.findDC = findDC;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
}
