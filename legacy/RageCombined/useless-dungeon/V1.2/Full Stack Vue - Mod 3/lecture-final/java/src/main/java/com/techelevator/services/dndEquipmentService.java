package com.techelevator.services;

import com.techelevator.model.dnd.APIList;
import com.techelevator.model.dnd.APIListItem;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class dndEquipmentService {

    public static String API_BASE_URL = "https://www.dnd5eapi.co/api/equipment";
    private RestTemplate restTemplate = new RestTemplate();

    public List<APIListItem> getListOfEquipmentIndices() {
        APIList equipmentIndexList = null;
        try{
            equipmentIndexList = restTemplate.getForObject(API_BASE_URL, APIList.class);
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return equipmentIndexList.results;
    }

}
