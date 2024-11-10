package com.techelevator.useless_dungeon.model;
/**********************************************************************************************************************/
/** Useless Dungeon Room - This is the Room class for all monsters in the dungeon.                                    */
/**                                                                                                                   */
/** Author: AMO     1/31/24                                                                                           */
/** Revision Log:																			                          */
/**     			6/25/24 - AMO - Removed Static ID Generation																	                          */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

public class Room {
    private String description; //This is how the room will be described to the player
    private int Id; //This is the unique ID of the room

    public Room(String description, int id) {
        this.description = description;
        Id = id;
    }

    public Room(){}

    public String getDescription() {
        return description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

