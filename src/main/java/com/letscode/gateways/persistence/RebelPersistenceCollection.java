package com.letscode.gateways.persistence;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import com.letscode.gateways.RebelPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Profile("collection")
@Component
@RequiredArgsConstructor
public class RebelPersistenceCollection implements RebelPersistenceGateway {

    private static Map<String, Rebel> rebels = new HashMap<>();
    private static Map<String, Rebel> traitors = new HashMap<>();
    private static Map<Long, Location> locations = new HashMap<>();
    private static Long rebelId = 1L;

    @Override
    public Rebel save(Rebel rebel) {

        if (rebel.getId() == null) {
            rebel.setId(rebelId++);
        }

        rebels.put(rebel.getName(), rebel);
        return rebel;
    }

    @Override
    public Location updateLocation(Location location) {
        location.setLatitude(location.getLatitude());
        location.setLongitude(location.getLongitude());
        location.setBase(location.getBase());
        locations.put(location.getId(), location);

        return location;
    }

    @Override
    public boolean existsById(Long id) {
        return rebels.containsKey(id);
    }

    @Override
    public List<Rebel> findAll() {
        return null;
        //fazer
    }

/*    @Override
    public Optional<Rebel> findById(Long id) {
        return Optional.empty();
    }*/

    public void saveTraitor(Rebel rebel) {
        rebels.remove(rebel.getName());
        traitors.put(rebel.getName(), rebel);
    }

    public Rebel getByName(Rebel rebel){
        return rebels.get(rebel.getName());
    }

    //porcentagem de traidores
    //porcentagem de rebeldes
    //Quantidade média de cada tipo de recurso por rebelde (Ex: 2 armas por rebelde).
    //Pontos perdidos devido a traidores. obs: como sao esses pontos?
    //outros requisitos: documentar endpoints e fornecer forma de usa-los
    //realizar testes
}
