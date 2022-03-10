package com.letscode.gateways.controllers.requests;
import com.letscode.domains.Item;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemRequest {
    @ApiModelProperty(required = true, value = "Nome do item", example = "arma")
    private String name;
    @ApiModelProperty(required = true, value = "quantidade do item", example = "1")
    private int amount;

    public Item toDomain() {
        return Item.builder()
                .name(name)
                .amount(amount)
                .build();
    }
}
