package com.techelevator.dao;

import com.techelevator.model.Event;
import java.util.List;

public interface EventDao {

    Event getEventById(int eventId);
    List<Event> getAllEvents();
    Event getRandomEvent();

}
