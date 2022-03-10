package com.letscode.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Inventory {

    private int gunsAmount;
    private int munitionAmount;
    private int waterAmount;
    private int foodAmount;
    private int points;

//@AllArgsConstructor
//@Builder
//public class Inventory {
//    private Long id;
//    private List<Item> item;

    public Inventory(int gunsAmount, int munitionAmount, int waterAmount, int foodAmount) {
        this.gunsAmount = gunsAmount;
        this.munitionAmount = munitionAmount;
        this.waterAmount = waterAmount;
        this.foodAmount = foodAmount;
        this.points = (gunsAmount * 4) + (munitionAmount * 3) + (waterAmount * 2) + (foodAmount);
    }
}

//obrigatorio ser criado junto c rebelde, n sei se tem q ser sempre igual
//rebelde n pode manipular itens, somente por troca
//1 arma = 4 pt ; 1 Munição = 3 pt ; 1 Água = 2 pt ; 1 Comida = 1 pt


