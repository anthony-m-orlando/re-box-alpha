package com.techelevator.useless_dungeon.services;

import java.util.List;

import com.techelevator.useless_dungeon.model.*;
import com.techelevator.useless_dungeon.services.security.AuthenticatedApiService;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

public class DungeonService extends AuthenticatedApiService {

	public DungeonService(String baseUrl) {
		this.baseUrl = baseUrl;
	}

    public List<Room> getListOfRooms() {
        List<Room> rooms = null;
        try {
            ResponseEntity<Room[]> response =
                    restTemplate.exchange(baseUrl + "rooms", HttpMethod.GET,
                            makeAuthEntity(), Room[].class);
            rooms = List.of(response.getBody());
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return rooms;
    }

    public List<Monster> getListOfMonsters() {
        List<Monster> monsters = null;
        try {
            ResponseEntity<Monster[]> response =
                    restTemplate.exchange(baseUrl + "monsters", HttpMethod.GET,
                            makeAuthEntity(), Monster[].class);
            monsters = List.of(response.getBody());
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return monsters;
    }


}
