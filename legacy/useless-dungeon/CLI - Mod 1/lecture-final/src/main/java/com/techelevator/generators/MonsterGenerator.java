package com.techelevator.generators;
/**********************************************************************************************************************/
/** Useless Dungeon Monster Generator - This class builds collections of Monsters Manually       */
/** Author: AMO     1/31/24                                                                    */
/** Revision Log:																			   */
/**     																					   */
/**********************************************************************************************************************/
/**********************************************************************************************************************/

//Model Imports - Only those Objects Required to Build Monster Collections
import com.techelevator.model.Monster;

//Collections
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonsterGenerator {
    public static List<Monster> getBasicFantasyMonsters(){
        //This Method returns an Array List with 4 Monsters
        List<Monster> output = new ArrayList<>();

        output.add(new Monster(1,"Velociraptor", 200, 100, "Tube Launched Optically Tracked Wire Guided Anti Personnel Missile ",500));
        output.add(new Monster(2,"Darth Vader", 500, 100, "Laser Sword ",5000));
        output.add(new Monster(3,"The Gelatinous Cube", 1000, 100, "Gelatinous Envelopment. Yuk!",10000));

        return output;
    }

    public static Map<Integer, Monster> getBasicFantasyMonsterMap(){
        //This Method creates a Map of Monsters that will correspond to the basic fantasy rooms Map
        Map<Integer,Monster> output = new HashMap<>();
        //Re-Use the ArrayList returned from the method above
        List<Monster> monsterList = getBasicFantasyMonsters();
        //Loop Through the Monsters
        for (Monster monster : monsterList){
            output.put(monster.getCreatureId() +1, monster); //These integers need to align with the Fantasy Rooms. Simply put, room 1 doesn't have a monster;
        }
        //Return the Monster Map
        return output;
    }

}
