package com.techelevator.dndapi.model.CharacterClass;

import java.util.List;

public class From {
    private String option_set_type;
    private List<Option> options;
    // getters and setters

    public From() {}

    public From(String option_set_type, List<Option> options) {
        this.option_set_type = option_set_type;
        this.options = options;
    }

    public String getOption_set_type() {
        return option_set_type;
    }

    public void setOption_set_type(String option_set_type) {
        this.option_set_type = option_set_type;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
