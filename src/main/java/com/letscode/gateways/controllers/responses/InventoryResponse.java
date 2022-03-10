package com.letscode.gateways.controllers.responses;

import com.letscode.domains.Inventory;
import com.letscode.domains.Item;
import lombok.Data;

import java.util.List;

@Data
public class InventoryResponse {
    private Long id;
    private List<Item> item;

    public InventoryResponse(Inventory inventory) {
        id = inventory.getId();
        item = inventory.getItem();
    }
}
