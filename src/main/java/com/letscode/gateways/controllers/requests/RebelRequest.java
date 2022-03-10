package com.letscode.gateways.controllers.requests;

import com.letscode.domains.Inventory;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RebelRequest {
    @ApiModelProperty(required = true, value = "Identificador do rebelde", example = "1")
    private Long id;
    @ApiModelProperty(required = true, value = "Nome do rebelde", example = "Fulano")
    private String name;
    @ApiModelProperty(required = true, value = "Idade do rebelde", example = "30")
    private int age;
    @ApiModelProperty(required = true, value = "Sexo do rebelde", example = "Feminino")
    private String gender;
    @ApiModelProperty(required = true, value = "Localizacao do rebelde", example = "lat, lon, base")
    private Location location;
    @ApiModelProperty(required = true, value = "Inventario do rebelde", example = "item, quantidade, pontos")
    private Inventory inventory;

    public Rebel toDomain() {
        return Rebel.builder()
                .id(id)
                .name(name)
                .gender(gender)
                .age(age)
                .location(location)
                .inventory(inventory)
                .build();
    }
}
