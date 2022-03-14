package com.letscode.gateways.controllers.responses;

import com.letscode.domains.Inventory;
import lombok.Data;

@Data
public class InventoryResponse {

    private int gunsAmount;
    private int munitionAmount;
    private int waterAmount;
    private int foodAmount;
    private int points;

    public InventoryResponse(Inventory inventory) {
        gunsAmount = inventory.getGunsAmount();
        munitionAmount = inventory.getMunitionAmount();
        waterAmount = inventory.getWaterAmount();
        foodAmount = inventory.getFoodAmount();
        points = inventory.getPoints();
    }
}
