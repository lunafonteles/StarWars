package com.letscode.gateways.controllers.requests;

import com.letscode.domains.Inventory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TradeRequest {

    @ApiModelProperty(required = true, value = "Items a receber")
    private Inventory givenItems;
    @ApiModelProperty(required = true, value = "Items a enviar")
    private Inventory receiveItems;

}
