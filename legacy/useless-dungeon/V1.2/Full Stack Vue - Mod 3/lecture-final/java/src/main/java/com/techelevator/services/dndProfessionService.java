package com.techelevator.services;

import com.techelevator.model.dnd.APIList;
import com.techelevator.model.dnd.APIListItem;
import com.techelevator.model.dnd.DnDClass;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import java.util.List;

public class dndProfessionService {
    public static String API_BASE_URL = "https://www.dnd5eapi.co/api/classes";
    private RestTemplate restTemplate = new RestTemplate();

    public List<APIListItem> getListOfProfessionIndices() {
        APIList professionIndexList = null;
        try{
            professionIndexList = restTemplate.getForObject(API_BASE_URL, APIList.class);
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return professionIndexList.results;
    }

    public DnDClass getProfessionByIndex(String index){
        DnDClass profession = new DnDClass();
        try {
            profession = restTemplate.getForObject(API_BASE_URL + "/" + index, DnDClass.class);
        }catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return profession;
    }
}
