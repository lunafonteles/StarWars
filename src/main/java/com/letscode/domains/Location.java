package com.letscode.domains;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    public float latitude;
    public float longitude;
    public String base;
}
