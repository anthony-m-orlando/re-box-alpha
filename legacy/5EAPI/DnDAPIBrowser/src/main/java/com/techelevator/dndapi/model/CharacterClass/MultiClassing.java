package com.techelevator.dndapi.model.CharacterClass;

import com.techelevator.dndapi.model.Proficiency;

import java.util.List;

public class MultiClassing {
    private List<Prerequisite> prerequisites;
    private List<Proficiency> proficiencies;
    // getters and setters

    public MultiClassing() {}

    public MultiClassing(List<Prerequisite> prerequisites, List<Proficiency> proficiencies) {
        this.prerequisites = prerequisites;
        this.proficiencies = proficiencies;
    }

    public List<Prerequisite> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Prerequisite> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }


}
