package com.letscode.usecases;
import com.letscode.domains.Rebel;
import com.letscode.gateways.persistence.RebelPersistenceH2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateRebel {

    private RebelPersistenceH2 rebelPersistenceH2;

    public Rebel create(Rebel rebel) {
        return rebelPersistenceH2.save(rebel);
    }

}
