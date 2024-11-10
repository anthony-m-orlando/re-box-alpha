package com.techelevator.useless_dungeon.controller;

import com.techelevator.useless_dungeon.dao.RoomDao;
import com.techelevator.useless_dungeon.exception.DaoException;

import com.techelevator.useless_dungeon.model.main.Room;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/rooms")
@PreAuthorize("isAuthenticated()")
public class RoomController {

    private RoomDao roomDao;

    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Room> list(Principal principal) {
        List<Room> rooms = null;
        try {
            rooms = roomDao.getListOfRooms();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rooms;
    }
}
