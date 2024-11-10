package com.techelevator.useless_dungeon.dao;

import com.techelevator.useless_dungeon.model.main.Room;

import java.util.List;

public interface RoomDao {
    Room getRoomById(int id);
    List<Room> getListOfRooms();
}
