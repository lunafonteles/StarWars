package com.letscode.domains;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Rebel {
    private String name;
    private String gender;
    private int age;
    private Location location;
    private Inventory inventory;
    private boolean isTraitor = false;
    private int accusationsAmount = 0;

    public Rebel(String name, String gender, int age, Location location, Inventory inventory) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.inventory = inventory;
    }
}
