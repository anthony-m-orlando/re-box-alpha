package com.techelevator.model.dnd;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquipmentSlot {

    @JsonProperty("equipment")
    public EquipmentItem equipmentItem;
    public int quantity;
}
