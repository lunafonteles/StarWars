package com.letscode.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Inventory {

    private int gunsAmount;
    private int munitionAmount;
    private int waterAmount;
    private int foodAmount;
    private int points;

    public Inventory(int gunsAmount, int munitionAmount, int waterAmount, int foodAmount, int points) {
        this.gunsAmount = gunsAmount;
        this.munitionAmount = munitionAmount;
        this.waterAmount = waterAmount;
        this.foodAmount = foodAmount;
        this.points = (gunsAmount * 4) + (munitionAmount * 3) + (waterAmount * 2) + (foodAmount);
    }
}


