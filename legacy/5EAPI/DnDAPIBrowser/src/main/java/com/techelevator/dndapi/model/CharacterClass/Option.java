package com.techelevator.dndapi.model.CharacterClass;

public class Option {
    private String option_type;
    private Item item;
    // getters and setters

    public Option() {}

    public Option(String option_type, Item item) {
        this.option_type = option_type;
        this.item = item;
    }

    public String getOption_type() {
        return option_type;
    }

    public void setOption_type(String option_type) {
        this.option_type = option_type;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
