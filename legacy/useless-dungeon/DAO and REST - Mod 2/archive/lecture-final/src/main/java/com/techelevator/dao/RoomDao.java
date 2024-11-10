package com.techelevator.dao;

import com.techelevator.model.main.Room;

import java.util.List;
import java.util.Map;

public interface RoomDao {
    public Room getRoomById(int id);
    public List<Room> getMapOfRooms();
}
