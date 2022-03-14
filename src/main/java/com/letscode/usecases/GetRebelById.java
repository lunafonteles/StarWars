package com.letscode.usecases;

import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetRebelById {

    private final RebelPersistenceGateway rebelPersistenceGateway;

    public Rebel execute(Long id) {
        if (id == null) {
            throw new ValidationException("id é obrigatorio");
        }
        return rebelPersistenceGateway.getById(id);
    }
}
