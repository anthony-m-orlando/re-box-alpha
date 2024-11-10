package com.techelevator.dndapi.model.CharacterClass;

public class StartingEquipment {
    private Equipment equipment;
    private int quantity;
    // getters and setters

    public StartingEquipment() {}

    public StartingEquipment(Equipment equipment, int quantity) {
        this.equipment = equipment;
        this.quantity = quantity;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}