package com.techelevator.controller;

import com.techelevator.dao.EventDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/event")
public class EventController {

    private EventDao eventDao;

    public EventController(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Event> getEvents() {
        try {
            return eventDao.getAllEvents();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable int id) {
        try {
            return eventDao.getEventById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/random", method = RequestMethod.GET)
public Event getRandomEvent() {
        try {
            return eventDao.getRandomEvent();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
