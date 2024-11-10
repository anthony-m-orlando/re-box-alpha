package com.techelevator.model;

public class Language {

    private int languageId;
    private String name;

    public Language() {
    }

    public Language(int languageId, String name) {
        this.languageId = languageId;
        this.name = name;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    private void  setName(String name) {
        this.name = name;
    }


}
