package com.letscode.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class Rebel {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private Location location;
    private Inventory inventory;
    private boolean isTraitor = false;
    private int accusationsAmount = 0;
}




