package com.techelevator.model;
/**********************************************************************************************************************/
/** Useless Dungeon Room - This is the Room class for all monsters in the dungeon.                                    */
/**                                                                                                                   */
/** Author: AMO     1/31/24                                                                                           */
/** Revision Log:																			                          */
/**     																					                          */
/**********************************************************************************************************************/
import java.util.List;
/**********************************************************************************************************************/

public class Room {
    private int roomId; //This is the unique ID of the room
    private String description; //This is how the room will be described to the player
    private List<Monster> monsterList;

    public Room(int roomId, String description, List<Monster> monsterList) {
        this.roomId = roomId;
        this.description = description;
        this.monsterList = monsterList;
    }
    public Room(){}

    public int getRoomId() {
        return roomId;
    }

    public void setId(int roomId) {
        this.roomId = roomId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }
}
