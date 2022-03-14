package com.letscode.gateways.persistence;
import com.letscode.domains.Inventory;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.gateways.persistence.Entities.RebelEntity;
import com.letscode.gateways.persistence.repositories.RebelH2Repository;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Profile("h2")
@Component
@RequiredArgsConstructor
public class RebelPersistenceH2 implements RebelPersistenceGateway {

    private final RebelH2Repository rebelH2Repository;

    @Override
    public Rebel save(Rebel rebel) {
        RebelEntity rebelEntity = rebelH2Repository.save(new RebelEntity(rebel));
        return rebelEntity.toDomain();
    }

    @Override
    public List<Rebel> getAll() {
        return rebelH2Repository.findAll().stream().map(RebelEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Rebel getById(Long id) {
        return null;
    }

    @Override
    public Rebel updateLocation(Location location, Long id){
//        RebelEntity rebelEntity = rebelH2Repository.save(new RebelEntity(rebel));
//        return rebelEntity.toDomain();
        return null;
    }

}
