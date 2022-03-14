package com.letscode.usecases;

import com.letscode.domains.Inventory;
import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.usecases.validators.TradeItemsValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TradeItems {

    private final RebelPersistenceGateway rebelPersistenceGateway;
    private final TradeItemsValidator tradeItemsValidator;

    public void trade(Long rebel1Id, Long rebel2Id, Inventory givenItems, Inventory receivedItems) {

        Rebel rebel1 = rebelPersistenceGateway.getById(rebel1Id);
        Rebel rebel2 = rebelPersistenceGateway.getById(rebel2Id);
        val validationErrors = tradeItemsValidator.validate(rebel1, rebel2, givenItems, receivedItems);

        if (!validationErrors.isEmpty()) {
            throw new ValidationException(validationErrors);
        }

        rebelPersistenceGateway.updateInventory(rebel1, receivedItems, givenItems);
        rebelPersistenceGateway.updateInventory(rebel2, givenItems, receivedItems);
    }
}
