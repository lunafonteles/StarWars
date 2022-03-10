package com.letscode.gateways.controllers.responses;

import com.letscode.domains.Item;
import lombok.Data;

@Data
public class ItemResponse {
    private String name;
    private int amount;

    public ItemResponse(Item item) {
        name = item.getName();
        amount = item.getAmount();

    }
}
