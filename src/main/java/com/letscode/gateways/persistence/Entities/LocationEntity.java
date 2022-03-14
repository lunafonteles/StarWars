package com.letscode.gateways.persistence.Entities;

import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_LOCATION")
@NoArgsConstructor
public class LocationEntity {
    @Id
    @GeneratedValue
    public Long id;
    @Column(name = "LATITUDE")
    public Float latitude;
    @Column(name = "LONGITUDE")
    public Float longitude;
    @Column(name = "BASE")
    public String base;

    public LocationEntity (Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        base = location.getBase();
    }

/*    public Location toDomain() {
        Location.builder()
                .latitude(latitude)
                .longitude(longitude)
                .base(base)
                .build();
    }*/
}
