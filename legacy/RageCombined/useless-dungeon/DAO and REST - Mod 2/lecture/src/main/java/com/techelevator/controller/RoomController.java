package com.techelevator.controller;
import com.techelevator.dao.RoomDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.main.Room;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomDao roomDao;

    public RoomController(RoomDao roomDao){
        this.roomDao = roomDao;
    }

    /**
     * GET
     * /rooms
     *
     *
     * @return a list of rooms in the dungeon
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Room> getRooms() {
        try {
            return roomDao.getMapOfRooms();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
