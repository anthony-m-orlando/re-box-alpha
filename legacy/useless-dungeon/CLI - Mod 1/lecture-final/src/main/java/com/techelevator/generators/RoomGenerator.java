package com.techelevator.generators;
/**********************************************************************************************************************/
/** Useless Dungeon Room  Generator - This class builds collections of Rooms Manually            */
/** Author: AMO     1/31/24                                                                    */
/** Revision Log:																			   */
/**     																					   */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

//Model Imports - Only those Objects Required to Build Room Collections
import com.techelevator.model.Monster;
import com.techelevator.model.Room;

//Collections
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RoomGenerator {
    public static Map<Integer,Room> getRoomMap(int source) {
        if(source ==1) {
            return getDefaultRoomMap();
        } else if (source ==2) {
            return getFileRoomMap();
        }
        return getDefaultRoomMap();
    }

    private static Map<Integer, Room> getDefaultRoomMap() {
        Map<Integer, Room> roomMap = new HashMap<>();
        List<Monster> monsterList = MonsterGenerator.getBasicFantasyMonsters();

        roomMap.put(1, new Room(1,"This 10 foot by 20 foot entry hall has stone walls with a Door on the east side leading to another room.",getDefaultMonstersInRoom(1)));
        roomMap.put(2, new Room(2,"This 20 foot by 30 foot dinning area has Velvet Elvis Paintings with a Door on the south wall leading to another room.", getDefaultMonstersInRoom(2)));
        roomMap.put(3, new Room(3,"This 40 foot by 50 foot dance studio has Mirrored Walls with a Door on the west wall leading to another room.", getDefaultMonstersInRoom(3)));
        roomMap.put(4, new Room(4,"This 20 foot by 20 foot arcade has posters of Metallica with a Door on the north wall leading to another room. Cletus is gently restrained in the comfy chair.", getDefaultMonstersInRoom(4)));

        return roomMap;
    }

    private static List<Monster> getDefaultMonstersInRoom(int roomId){
        List<Monster> monsterList = new ArrayList<>();
        if(roomId == 2){
            monsterList.add(new Monster(1, "Velociraptor",  200, 100,  "Tube Launched Optically Tracked Wire Guided Anti Personnel Missile.", 500));
        } else if(roomId == 3){
            monsterList.add(new Monster(2, "Darth Gonzo",  500, 500,  "Red Laser Sword.", 5000));
        }else if (roomId ==4){
            monsterList.add(new Monster(3, "The Gelatenous Cube",  1000, 100,  "Gelatenous Envelopment. --Yuk!", 50000));
        }

        return monsterList;
    }
    private static Map<Integer, Room> getFileRoomMap() {
        Map<Integer, Room> roomMap = new HashMap<>();
        List<Monster> monsterList = MonsterGenerator.getBasicFantasyMonsters();
        File inputFile = null;
        inputFile = new File("src/main/java/com/techelevator/data/rooms.csv");
        String[] fileLine;

        try (Scanner inputScanner = new Scanner(inputFile)) {
            while (inputScanner.hasNextLine()) {
                fileLine = inputScanner.nextLine().split(",");
                roomMap.put(Integer.parseInt(fileLine[0]), new Room(Integer.parseInt(fileLine[0]),fileLine[1],getDefaultMonstersInRoom(Integer.parseInt(fileLine[0]))));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return roomMap;
    }
}
