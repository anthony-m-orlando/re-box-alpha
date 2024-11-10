package com.techelevator.model.main;

import java.util.List;

//This is the Room Class.
//You can Inherit from this class to create specialized versions
public class Room {
    private String description;
    private int Id; //This is the unique ID of the room
    private String name;
    private List<Monster> monsters;

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
