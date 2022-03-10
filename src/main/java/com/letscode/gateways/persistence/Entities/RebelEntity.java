package com.letscode.gateways.persistence.Entities;
import com.letscode.domains.Inventory;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "TB_REBELS")
@NoArgsConstructor
public class RebelEntity {
    @Id @GeneratedValue
    public Long id;
    @Column(name = "NAME")
    public String name;
    @Column(name = "GENDER")
    public String gender;
    @Column(name = "AGE")
    public int age;
    //@OneToOne
    //public Location location;
    //@OneToOne(mappedBy = "rebel", cascade = CascadeType.ALL)
    //public List<ItemEntity> inventory;

    public RebelEntity(Rebel rebel) {
        id = rebel.getId();
        name = rebel.getName();
        gender = rebel.getGender();
        age = rebel.getAge();
        //location = rebel.getLocation().stream().map(location -> new LocationEntity(location().collect(Collectors.toList()));
        //inventory = rebel.inventory.getItem().stream().map(inventory -> new ItenEntity(inventory().collect(Collectors.toList()));
    }

    public Rebel toDomain() {
        return Rebel.builder()
                .id(id)
                .name(name)
                .gender(gender)
                .age(age)
                //.inventory(inventory.stream().map(ItenEntity::toDomain).collect(Collectors.toList()))
                .build();
    }

}
