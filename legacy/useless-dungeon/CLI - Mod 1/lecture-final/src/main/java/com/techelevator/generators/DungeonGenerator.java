package com.techelevator.generators;

import com.techelevator.model.Dungeon;
import com.techelevator.model.Hero;

public class DungeonGenerator {
    public static Dungeon generateDungeon(int dungeonType, Hero myHero) {
        return new Dungeon(RoomGenerator.getRoomMap(dungeonType), myHero, 1);
    }

}
