package com.letscode.gateways;

import com.letscode.domains.Inventory;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;

import java.util.List;

public interface RebelPersistenceGateway {

    Rebel save(Rebel rebel);
    Rebel updateLocation(Location location, Long rebelId);
    boolean existsById(Long id);
    List<Rebel> getAll();
    Rebel getById(Long id);
}
