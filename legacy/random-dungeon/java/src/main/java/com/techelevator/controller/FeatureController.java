package com.techelevator.controller;


import com.techelevator.dao.FeatureDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Feature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/feature")
public class FeatureController {

    private FeatureDao featureDao;

    public FeatureController(FeatureDao featureDao) {
        this.featureDao = featureDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Feature> getFeatures() {
        try {
            return featureDao.getAllFeatures();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public Feature getRandomFeature() {
        try {
            return featureDao.getRandomFeature();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Feature getFeatureById(@PathVariable int id) {
        try {
            return featureDao.getFeatureById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
