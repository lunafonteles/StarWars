package com.letscode.gateways.controllers.requests;

import com.letscode.domains.Inventory;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class InventoryRequest {

    @ApiModelProperty(required = true, value = "Quantidade de armas", example = "1")
    private int gunsAmount;
    @ApiModelProperty(required = true, value = "Quantidade de munição", example = "1")
    private int munitionAmount;
    @ApiModelProperty(required = true, value = "Quantidade de água", example = "1")
    private int waterAmount;
    @ApiModelProperty(required = true, value = "Quantidade de comida", example = "1")
    private int foodAmount;
    private int points;

    public Inventory toDomain() {
        return Inventory.builder()
                .gunsAmount(gunsAmount)
                .munitionAmount(munitionAmount)
                .waterAmount(waterAmount)
                .foodAmount(foodAmount)
                .build();
    }


   /* @ApiModelProperty(required = true, value = "Identificador do inventario", example = "1")
    private Long id;
    @ApiModelProperty(required = true, value = "Items", example = "nome, quantidade")
    private List<ItemRequest> item;

   public Inventory toDomain() {
        return Inventory.builder()
                .id(id)
                .item(item.stream().map(ItemRequest::toDomain).collect(Collectors.toList()))
                .build();
    }*/
}
