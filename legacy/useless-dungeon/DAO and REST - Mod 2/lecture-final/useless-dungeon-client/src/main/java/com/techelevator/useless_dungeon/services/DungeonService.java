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
	public List<Hero> getHeroesForUser() {
        List<Hero> heroes = null;
        try {
    		ResponseEntity<Hero[]> response =
                    restTemplate.exchange(baseUrl +"heroes", HttpMethod.GET,
                            makeAuthEntity(), Hero[].class);
            heroes = List.of(response.getBody());
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
		return heroes;
	}

    public Hero getHeroById(int heroId) {
        Hero hero = null;
        try {
            ResponseEntity<Hero> response =
                    restTemplate.exchange(baseUrl + "heroes/" + heroId, HttpMethod.GET,
                            makeAuthEntity(), Hero.class);
            hero = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return hero;
    }

    public List<Profession> getProfessions() {
        List<Profession> professions = null;
        try {
            ResponseEntity<Profession[]> response =
                    restTemplate.exchange(baseUrl + "heroes/professions", HttpMethod.GET,
                            makeAuthEntity(), Profession[].class);
            professions = List.of(response.getBody());
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return professions;
    }

    public Hero createHero(Hero newHero) {
        Hero hero = null;
        try {
            ResponseEntity<Hero> response =
                    restTemplate.exchange(baseUrl + "heroes", HttpMethod.POST,
                            makeHeroEntity(newHero), Hero.class);
            hero = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return hero;
    }

    private HttpEntity<Hero> makeHeroEntity(Hero hero) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(hero, headers);
    }


}
