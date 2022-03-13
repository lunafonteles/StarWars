package com.letscode.gateways.controllers.requests;

import com.letscode.domains.Location;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationRequest {

    @ApiModelProperty(required = true, value = "Latitude do rebelde", dataType = "Float", example = "45.45")
    private Float latitude;
    @ApiModelProperty(required = true, value = "Longitude do rebelde", dataType = "Float", example = "45.45")
    private Float longitude;
    @ApiModelProperty(required = true, value = "Base da galaxia", example = "terra")
    private String base;

    public Location toDomain() {
        return Location.builder()
                .latitude(latitude)
                .longitude(longitude)
                .base(base)
                .build();
    }
}
