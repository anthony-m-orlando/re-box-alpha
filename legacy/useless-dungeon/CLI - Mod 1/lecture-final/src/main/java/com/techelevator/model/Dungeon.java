package com.techelevator.model;

import java.util.HashMap;
import java.util.Map;

public class Dungeon {
    private Map<Integer,Room> dungeonRooms = new HashMap<>();
    private Hero currentHero;
    private int currentRoom;

    private int dungeonDifficulty;

    public Dungeon(){}

    public Dungeon (Map<Integer,Room> dungeonRooms, Hero currentHero, int currentRoom){
        this.dungeonRooms = dungeonRooms;
        this.currentHero = currentHero;
        this.currentRoom = currentRoom;
        this.dungeonDifficulty = 1;
    }
    public int getDungeonDifficulty() {
        return dungeonDifficulty;
    }

    public void setDungeonDifficulty(int dungeonDifficulty) {
        this.dungeonDifficulty = dungeonDifficulty;
    }
    public Map<Integer,Room> getDungeonRooms() {
        return dungeonRooms;
    }

    public Hero getCurrentHero() {
        return currentHero;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }
}
