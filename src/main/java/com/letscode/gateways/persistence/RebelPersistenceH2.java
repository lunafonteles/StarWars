package com.letscode.gateways.persistence;
import com.letscode.domains.Rebel;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.gateways.persistence.Entities.RebelEntity;
import com.letscode.gateways.persistence.repositories.RebelH2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RebelPersistenceH2 implements RebelPersistenceGateway {

    //private static Map<String, Rebel> rebels = new HashMap<>();
    //private static Map<String, Rebel> trators = new HashMap<>();

    private final RebelH2Repository rebelH2Repository;

    @Override
    public Rebel save(Rebel rebel) {
        RebelEntity rebelEntity = rebelH2Repository.save(new RebelEntity(rebel));
        return rebelEntity.toDomain();
    }
    @Override
        public void delete(Rebel rebel) {
        //rebels.remove(rebel.getName());
        //trators.put(rebel.getName(), rebel);
    }

    @Override
    public List<Rebel> findAll() {
        return rebelH2Repository.findAll().stream().map(RebelEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Optional<Rebel>findById(Long id) {
        return Optional.empty();
    }



    //porcentagem de traidores
    //porcentagem de rebeldes
    //Quantidade média de cada tipo de recurso por rebelde (Ex: 2 armas por rebelde).
    //Pontos perdidos devido a traidores. obs: como sao esses pontos?
    //outros requisitos: documentar endpoints e fornecer forma de usa-los
    //realizar testes
}
