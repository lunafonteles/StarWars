package com.letscode.usecases;
import com.letscode.domains.Rebel;
import com.letscode.persistence.RebelPersistence;

public class CreateRebel {

    private RebelPersistence rebelPersistence;

    public Rebel create(Rebel rebel) {
        return rebelPersistence.save(rebel);
    }

}
