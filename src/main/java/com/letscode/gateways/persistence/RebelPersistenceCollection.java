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

    private static Map<Long, Rebel> rebels = new HashMap<>();
    private static Map<String, Rebel> traitors = new HashMap<>();
    private static Map<Long, Rebel> locations = new HashMap<>();
    private static Long rebelId = 1L;

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
    public Rebel tradeItems(Long rebel1Id, Long rebel2Id, Inventory givenItems, Inventory receivedItems) {
        return  null;
    }

    @Override
    public boolean existsById(Long id) {
        return rebels.containsKey(id);
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
    public void saveTraitor(Rebel rebel) {
        rebels.remove(rebel.getName());
        traitors.put(rebel.getName(), rebel);
    }

    @Override
    public Rebel getByName(Rebel rebel){
        return rebels.get(rebel.getName());
    }

    //todo: porcentagem de traidores
    //todo: porcentagem de rebeldes
    //Quantidade média de cada tipo de recurso por rebelde (Ex: 2 armas por rebelde).
    //Pontos perdidos devido a traidores. obs: como sao esses pontos?
    //outros requisitos: documentar endpoints e fornecer forma de usa-los
    //realizar testes
}
