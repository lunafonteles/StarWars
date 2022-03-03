package com.letscode.domains;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rebel {
    public String name;
    public String gender;
    public int age;
    public Location location;
    public Inventory inventory;
    public boolean trator = false;
}
