package com.letscode.domains;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
<<<<<<< HEAD
@AllArgsConstructor
@Builder
public class Rebel {
    public Long id;
    public String name;
    public String gender;
    public int age;
    public Location location;
    public Inventory inventory;
    public boolean trator = false;
=======
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
>>>>>>> 48a395bb05bc659c2358d2dae6c46191a7bdb07d
}
