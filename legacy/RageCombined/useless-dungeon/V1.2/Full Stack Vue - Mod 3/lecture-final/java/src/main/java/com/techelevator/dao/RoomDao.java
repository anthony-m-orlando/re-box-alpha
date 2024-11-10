package com.techelevator.dao;

import com.techelevator.model.main.Room;

import java.util.List;
import java.util.Map;

public interface RoomDao {
    Room getRoomById(int id);
    List<Room> getListOfRooms();

    List<Room> getRoomsByDungeonId(int dungeonId);
}
