package com.letscode.usecases;

import com.letscode.domains.Location;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.usecases.validators.UpdateLocationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateLocation {

    private final RebelPersistenceGateway rebelPersistenceGateway;
    private final UpdateLocationValidator updateLocationValidator;

    public Location update(Location location) {
        List<String> validationErrors = updateLocationValidator.validate(location);

        if (!validationErrors.isEmpty()) {
            throw new ValidationException(validationErrors);
        }

        return rebelPersistenceGateway.updateLocation(location);
    }
    //apenas atualizar, nao precisa armazenar o historico
    //a implement
}
