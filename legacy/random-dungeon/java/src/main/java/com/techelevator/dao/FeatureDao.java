package com.techelevator.dao;
import com.techelevator.model.Feature;

import java.util.List;

public interface FeatureDao {

    Feature getFeatureById(int featureId);
    public List<Feature> getAllFeatures();
    public Feature getRandomFeature();

}
