package com.techelevator.useless_dungeon.services;
import com.techelevator.useless_dungeon.model.Room;
import com.techelevator.util.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RoomService {
    public static String API_BASE_URL = "http://localhost:8080/rooms";
    private RestTemplate restTemplate = new RestTemplate();

    public List<Room> getListOfRooms(){
        List<Room> rooms = null;
        Room[] roomResponse = null;
        try {
            roomResponse = restTemplate.getForObject(API_BASE_URL, Room[].class);
            rooms = Arrays.asList(roomResponse);
        }catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return rooms;
    }

}
