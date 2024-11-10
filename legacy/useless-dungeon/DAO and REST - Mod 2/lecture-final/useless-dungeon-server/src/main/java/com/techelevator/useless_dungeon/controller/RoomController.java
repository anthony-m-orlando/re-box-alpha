package com.techelevator.useless_dungeon.controller;

import com.techelevator.useless_dungeon.dao.RoomDao;
import com.techelevator.useless_dungeon.exception.DaoException;

import com.techelevator.useless_dungeon.model.main.Room;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@PreAuthorize("isAuthenticated()")
public class RoomController {

    private final RoomDao roomDao;

    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<Room> getListOfRooms() {
        try {
           return roomDao.getListOfRooms();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }

   @GetMapping(path = "/{roomId}")
    public Room getRoomById(@PathVariable int roomId){
        try {
            return roomDao.getRoomById(roomId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }

}
