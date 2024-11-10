package com.techelevator.builders;
/**********************************************************************************************************************/
/** Useless Dungeon Room  Builder - This class builds collections of Rooms Manually            */
/** Author: AMO     1/31/24                                                                    */
/** Revision Log:																			   */
/**     																					   */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

//Model Imports - Only those Objects Required to Build Room Collections
import com.techelevator.model.Room;

//Collections
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomBuilder {

    public static List<Room> getBasicFantasyRooms(){
        //This Method returns an Array List with 4 rooms
        List<Room> output = new ArrayList<>();

        output.add(new Room("This 10 foot by 20 foot entry hall has stone walls with a Door on the east side leading to another room."));
        output.add(new Room("This 20 foot by 30 foot dinning area has Velvet Elvis Paintings with a Door on the south wall leading to another room."));
        output.add(new Room("This 40 foot by 50 foot dance studio has Mirrored Walls with a Door on the west wall leading to another room."));
        output.add(new Room("This 20 foot by 20 foot arcade has posters of Metallica  with a Door on the north wall leading to another room. Cletus is gently restrained in the comfy chair."));

        return output;
    }

    public static Map<Integer,Room> getBasicFantasyRoomMap(){
        //This Method creates a Map of Rooms that will correspond to the basic fantasy Monsters
        Map<Integer,Room> output = new HashMap<>();
        //Re-Use the ArrayList returned from the method above
        List<Room> roomList = getBasicFantasyRooms();
        //Loop Through the Rooms
        for (Room room : roomList){
            output.put(room.getId(), room);
        }
        //Return the Room Map
        return output;
    }


}
