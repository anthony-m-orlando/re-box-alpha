package com.techelevator.useless_dungeon.services;
import com.techelevator.useless_dungeon.model.Monster;
import com.techelevator.util.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class MonsterService {
    public static String API_BASE_URL = "http://localhost:8080/monsters";
    private RestTemplate restTemplate = new RestTemplate();

    public List<Monster> getAllMonsters() {
        List<Monster> monsters = null;
        Monster[] monsterResponse = null;
        try {
            monsterResponse = restTemplate.getForObject(API_BASE_URL, Monster[].class);
            monsters = Arrays.asList(monsterResponse);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return monsters;
    }
}


