package com.letscode.gateways;

import com.letscode.domains.Location;
import com.letscode.domains.Rebel;

import java.util.List;
import java.util.Optional;

public interface RebelPersistenceGateway {

    Rebel save(Rebel rebel);
    Location updateLocation(Location location);
    boolean existsById(Long id);
    void saveTraitor(Rebel rebel);
    Rebel getByName(Rebel rebel);
    List<Rebel> findAll();
    //Optional<Rebel> findById(Long id);
}
