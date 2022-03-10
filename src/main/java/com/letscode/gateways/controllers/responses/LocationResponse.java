package com.letscode.gateways.controllers.responses;

import com.letscode.domains.Location;
import io.swagger.annotations.ApiModelProperty;

public class LocationResponse {
    @ApiModelProperty(required = true, value = "Latitude do rebelde", example = "41,54")
    private Float latitude;
    @ApiModelProperty(required = true, value = "Longitude do rebelde", example = "45,45")
    private Float longitude;
    @ApiModelProperty(required = true, value = "Base da galaxia", example = "seila")
    private String base;

    public LocationResponse(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        base = location.getBase();
    }
}
