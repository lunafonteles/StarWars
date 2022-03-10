package com.letscode.gateways.controllers.responses;

import com.letscode.domains.Inventory;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import lombok.Data;

@Data
public class RebelResponse {

    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private Location location;
    private Inventory inventory;

    public RebelResponse(Rebel rebel) {
        id = rebel.getId();
        name = rebel.getName();
        age = rebel.getAge();
        gender = rebel.getGender();
        location = rebel.getLocation();
        inventory = rebel.getInventory();
    }
}
