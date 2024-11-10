package com.techelevator.model;

public class AIAction {

    private int priority;
    private String actionName;
    private String target;

    public AIAction(int priority, String actionName, String target) {
        this.priority = priority;
        this.actionName = actionName;
        this.target = target;
    }

    public AIAction() {

    }
    public int getPriority() {
        return priority;
    }

    public String getActionName() {
        return actionName;
    }

    public String getTarget() {
        return target;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public void setTarget(String target) {
        this.target = target;
    }



}
