package com.letscode.gateways.persistence;

import com.letscode.domains.Inventory;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import com.letscode.gateways.RebelPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Profile("collection")
@Component
@RequiredArgsConstructor
public class RebelPersistenceCollection implements RebelPersistenceGateway {

    private static Map<Long, Rebel> rebels = new HashMap<>() {{
        put(1L, new Rebel(1L, "Joe", "Masculino", 31,
                new Location(10.65F, 3.4F, "Mars"),
                new Inventory(1, 1, 1, 1, 10),
                false, 0));

        put(2L, new Rebel(2L, "luna", "Feminino", 31,
                new Location(10.65F, 3.4F, "Earth"),
                new Inventory(1, 1, 1, 1, 10),
                false, 0));

        put(3L, new Rebel(3L, "Igor", "Masculino", 31,
                new Location(10.65F, 3.4F, "Terra"),
                new Inventory(1, 1, 1, 1, 10),
                false, 0));
    }};
    private static Long rebelId = 4L;

    @Override
    public Rebel save(Rebel rebel) {
        if (rebel.getId() == null) {
            rebel.setId(rebelId++);
        }
        rebels.put(rebel.getId(), rebel);
        return rebel;
    }

    @Override
    public Rebel updateLocation(Location location, Long id) {
        Rebel rebel = rebels.get(id);
        rebel.setLocation(location);
        rebels.put(rebel.getId(), rebel);
        return rebel;
    }

    @Override
    public List<Rebel> getAll() {
        return new ArrayList<>(rebels.values());
    }

    @Override
    public Rebel getById(Long id) {
        return rebels.get(id);
    }

    @Override
    public void updateInventory(Rebel rebel, Inventory receivedItems, Inventory givenItems) {
        rebel.getInventory().setGunsAmount(
            rebel.getInventory().getGunsAmount()
                - givenItems.getGunsAmount()
                + receivedItems.getGunsAmount());

        rebel.getInventory().setMunitionAmount(
            rebel.getInventory().getMunitionAmount()
                - givenItems.getMunitionAmount()
                + receivedItems.getMunitionAmount());

        rebel.getInventory().setWaterAmount(
            rebel.getInventory().getWaterAmount()
                - givenItems.getWaterAmount()
                + receivedItems.getWaterAmount());

        rebel.getInventory().setFoodAmount(
            rebel.getInventory().getFoodAmount()
                - givenItems.getFoodAmount()
                + receivedItems.getFoodAmount());

        save(rebel);
    }
}
