package com.techelevator.model.main;

import java.util.List;

public class Dungeon {
    private int dungeonId;
    private String  dungeonName;
    private int lateralLimit;
    private int verticalLimit;
    private List<Room> dungeonRooms;

    public int getDungeonId() {
        return dungeonId;
    }

    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    public String getDungeonName() {
        return dungeonName;
    }

    public void setDungeonName(String dungeonName) {
        this.dungeonName = dungeonName;
    }

    public int getLateralLimit() {
        return lateralLimit;
    }

    public void setLateralLimit(int lateralLimit) {
        this.lateralLimit = lateralLimit;
    }

    public int getVerticalLimit() {
        return verticalLimit;
    }

    public void setVerticalLimit(int verticalLimit) {
        this.verticalLimit = verticalLimit;
    }

    public List<Room> getDungeonRooms() {
        return dungeonRooms;
    }

    public void setDungeonRooms(List<Room> dungeonRooms) {
        this.dungeonRooms = dungeonRooms;
    }
}
