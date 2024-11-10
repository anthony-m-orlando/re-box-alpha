package com.techelevator.dndapi.model.CharacterClass;

public class StartingEquipmentOption {
    private String desc;
    private int choose;
    private String type;
    private From from;
    // getters and

    public StartingEquipmentOption() {}

    public StartingEquipmentOption(String desc, int choose, String type, From from) {
        this.desc = desc;
        this.choose = choose;
        this.type = type;
        this.from = from;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }


}