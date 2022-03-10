package com.letscode.domains;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Location {
    private Long id;
    private Float latitude;
    private Float longitude;
    private String base;
}
