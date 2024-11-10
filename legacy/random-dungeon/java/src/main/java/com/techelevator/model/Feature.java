package com.techelevator.model;

public class Feature {

    private int featureId;
    private String featureName;
    private String featureDescription;
    private String imageName;

    public Feature() {
    }

    public Feature(int featureId, String featureName, String imageName, String featureDescription) {
        this.featureId = featureId;
        this.featureName = featureName;
        this.featureDescription = featureDescription;
        this.imageName = imageName;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName){
        this.featureName =  featureName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getFeatureDescription(){
        return this.featureDescription;
    }

    public void setFeatureDescription(String featureDescription){
        this.featureDescription = featureDescription;
    }

}
