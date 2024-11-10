package com.techelevator.useless_dungeon.services;

import com.techelevator.useless_dungeon.model.Profession;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class HeroService extends AuthenticatedApiService {

    public static String API_BASE_URL = "http://localhost:8080/hero";
    private RestTemplate restTemplate = new RestTemplate();

    public HeroService(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    public List<Profession> getListOfProfessions(){
        List<Profession> professions = null;
        try {
            ResponseEntity<Profession[]> professionResponse =
                    restTemplate.exchange(baseUrl + "/professions", HttpMethod.GET,
                            makeAuthEntity(), Profession[].class);
            professions = Arrays.asList(professionResponse.getBody());
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return professions;
    }
}
