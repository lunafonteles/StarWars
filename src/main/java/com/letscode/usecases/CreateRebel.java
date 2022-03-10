package com.letscode.usecases;
import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;

import com.letscode.gateways.persistence.RebelPersistenceH2;
import com.letscode.usecases.validators.CreateRebelValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.val;

@RequiredArgsConstructor
@Service
public class CreateRebel {
    private final CreateRebelValidator createRebelValidator;
    private final RebelPersistenceGateway rebelPersistenceGateway;

    public Rebel create(Rebel rebel) {
        val validationErrors = createRebelValidator.validate(rebel);

        if (!validationErrors.isEmpty()) {
            throw new ValidationException(validationErrors);
        }

        return rebelPersistenceGateway.save(rebel);
    }

}
