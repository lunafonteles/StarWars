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

    @ApiModelProperty(required = true, value = "Nome do rebelde", example = "Fulano")
    private String name;
    @ApiModelProperty(required = true, value = "Idade do rebelde", example = "30")
    private Integer age;
    @ApiModelProperty(required = true, value = "Gênero do rebelde", example = "Feminino")
    private String gender;
    private Location location;
    private Inventory inventory;

    public Rebel toDomain() {
        return Rebel.builder()
                .name(name)
                .gender(gender)
                .age(age)
                .location(location)
                .inventory(inventory)
                .build();
    }
}
