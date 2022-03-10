package com.letscode.gateways;

import com.letscode.domains.Rebel;

import java.util.List;
import java.util.Optional;

public interface RebelPersistenceGateway {

    Rebel save(Rebel rebel);
    boolean existsById(Long id);
    void delete(Rebel rebel);
    List<Rebel> findAll();
    Optional<Rebel> findById(Long id);
}
