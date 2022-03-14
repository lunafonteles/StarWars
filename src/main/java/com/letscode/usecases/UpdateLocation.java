package com.letscode.usecases;

import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.usecases.validators.UpdateLocationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.val;

@Service
@RequiredArgsConstructor
public class UpdateLocation {

    private final RebelPersistenceGateway rebelPersistenceGateway;
    private final UpdateLocationValidator updateLocationValidator;

    public Rebel update(Location location, Long rebelId) {
        val validationErrors = updateLocationValidator.validate(location);

        if (!validationErrors.isEmpty()) {
            throw new ValidationException(validationErrors);
        }
        return rebelPersistenceGateway.updateLocation(location, rebelId);
    }
}
