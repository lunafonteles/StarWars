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
        if (tradeItemsValidator.oneOfThemIsTraitor(rebel1, rebel2)) {
            throw new ValidationException("Um deles é traidor");
        }
        if (!tradeItemsValidator.hasTheSamePoints(givenItems, receivedItems)) {
            throw new ValidationException("A quantidade de pontos a trocar é diferente");
        }
        if (!tradeItemsValidator.rebelHasTheItemsToTrade(rebel1, givenItems)
                || !tradeItemsValidator.rebelHasTheItemsToTrade(rebel2, receivedItems)) {
            throw new ValidationException("Um dos rebeldes não tem itens para concluir a troca");
        }

        rebelPersistenceGateway.updateInventory(rebel1, receivedItems, givenItems);
        rebelPersistenceGateway.updateInventory(rebel2, givenItems, receivedItems);
    }

//    private void updateInventory(Rebel rebel, Inventory givenItems, Inventory receivedItems) {
//        rebel.getInventory().setGunsAmount(rebel.getInventory().getGunsAmount() - givenItems.getGunsAmount() + receivedItems.getGunsAmount());
//        rebel.getInventory().setMunitionAmount(rebel.getInventory().getMunitionAmount() - givenItems.getMunitionAmount() + receivedItems.getMunitionAmount());
//        rebel.getInventory().setWaterAmount(rebel.getInventory().getWaterAmount() - givenItems.getWaterAmount() + receivedItems.getWaterAmount());
//        rebel.getInventory().setFoodAmount(rebel.getInventory().getFoodAmount() - givenItems.getFoodAmount() + receivedItems.getFoodAmount());

//        rebelPersistenceGateway.updateInventory(rebel, receivedItems, givenItems);
//        rebelPersistenceGateway.updateInventory(rebel, givenItems, receivedItems);

//        if (tradeItemsValidator.oneOfThemIsTraitor(rebel1, rebel2)) {
//            throw new ValidationException("Um deles é traidor");
//        }
//        if (!tradeItemsValidator.hasTheSamePoints(givenItems, receivedItems)) {
//            throw new ValidationException("A quantidade de pontos a trocar é diferente");
//        }
//        if (!tradeItemsValidator.rebelHasTheItemsToTrade(rebel1, givenItems)
//            || !tradeItemsValidator.rebelHasTheItemsToTrade(rebel2, receivedItems)) {
//            throw new ValidationException("Um dos rebeldes não tem itens para concluir a troca");
//        }
//
//        updateInventory(rebel1, receivedItems, givenItems);
//        updateInventory(rebel2, givenItems, receivedItems);
//
//    }
//
//    private void updateInventory(Rebel rebel, Inventory givenItems, Inventory receivedItems) {
//        rebel.getInventory().setGunsAmount(rebel.getInventory().getGunsAmount() - givenItems.getGunsAmount() + receivedItems.getGunsAmount());
//        rebel.getInventory().setMunitionAmount(rebel.getInventory().getMunitionAmount() - givenItems.getMunitionAmount() + receivedItems.getMunitionAmount());
//        rebel.getInventory().setWaterAmount(rebel.getInventory().getWaterAmount() - givenItems.getWaterAmount() + receivedItems.getWaterAmount());
//        rebel.getInventory().setFoodAmount(rebel.getInventory().getFoodAmount() - givenItems.getFoodAmount() + receivedItems.getFoodAmount());
//
//        rebelPersistenceGateway.save(rebel);
//    }
}
