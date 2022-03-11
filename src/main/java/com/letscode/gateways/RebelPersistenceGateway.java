package com.letscode.gateways;

import com.letscode.domains.Inventory;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;

import java.util.List;
import java.util.Optional;

public interface RebelPersistenceGateway {

    Rebel save(Rebel rebel);
    Rebel updateLocation(Location location, Long rebelId);
    Rebel tradeItems(Inventory inventory);
    boolean existsById(Long id);
    void saveTraitor(Rebel rebel);
    Rebel getByName(Rebel rebel);
    List<Rebel> getAll();
    Optional<Rebel> getById(Long id);
}
