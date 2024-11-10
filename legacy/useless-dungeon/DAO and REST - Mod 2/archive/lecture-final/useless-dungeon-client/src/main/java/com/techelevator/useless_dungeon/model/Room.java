package com.techelevator.useless_dungeon.model;

/**********************************************************************************************************************/
/** Useless Dungeon Room - This is the Room class for all monsters in the dungeon.                                    */
/**                                                                                                                   */
/** Author: AMO     1/31/24                                                                                           */
/** Revision Log:																			                          */
/**     																					                          */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

public class Room {
    private String description; //This is how the room will be described to the player
    private int Id; //This is the unique ID of the room
    static int roomCount=0; //This keeps track of how many room objects have been instantiated

    public Room(String description) {
        this.description = description;
        roomCount++;
        Id = roomCount;
    }

    public Room(){}
    public String getDescription() {
        return description;
    }

    public int getId() {
        return Id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        Id = id;
    }
}
