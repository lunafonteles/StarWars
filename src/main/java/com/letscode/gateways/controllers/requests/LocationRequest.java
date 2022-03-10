package com.letscode.gateways.controllers.requests;

import com.letscode.domains.Location;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationRequest {

    @ApiModelProperty(required = true, value = "Latitude do rebelde", example = "41,54")
    private float latitude;
    @ApiModelProperty(required = true, value = "Longitude do rebelde", example = "45,45")
    private float longitude;
    @ApiModelProperty(required = true, value = "Base da galaxia", example = "seila")
    private String base;

    public Location toDomain() {
        return Location.builder()
                .latitude(latitude)
                .longitude(longitude)
                .base(base)
                .build();
    }
}
