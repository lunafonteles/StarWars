package com.letscode.gateways.controllers.requests;

import com.letscode.domains.Inventory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class InventoryRequest {
    @ApiModelProperty(required = true, value = "Identificador do inventario", example = "1")
    private Long id;
    @ApiModelProperty(required = true, value = "Items", example = "nome, quantidade")
    private List<ItemRequest> item;

    public Inventory toDomain() {
        return Inventory.builder()
                .id(id)
                .item(item.stream().map(ItemRequest::toDomain).collect(Collectors.toList()))
                .build();
    }
}
