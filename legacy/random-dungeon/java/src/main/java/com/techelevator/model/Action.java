package com.techelevator.model;

public class Action {
    private int actionId;
    private String actionType;
    private String actionDescription;

    public Action(int actionId, String actionType, String actionDescription) {
        this.actionId = actionId;
        this.actionType = actionType;
        this.actionDescription = actionDescription;
    }

    public Action() {
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }


}
