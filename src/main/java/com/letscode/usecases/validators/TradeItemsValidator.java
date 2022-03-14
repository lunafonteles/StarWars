package com.letscode.usecases.validators;

import com.letscode.domains.Inventory;
import com.letscode.domains.Rebel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TradeItemsValidator {
    public boolean oneOfThemIsTraitor(Rebel rebel1, Rebel rebel2){
        return rebel1.isTraitor() || rebel2.isTraitor();
    }

    public boolean hasTheSamePoints(Inventory givenItems, Inventory receivedItemns){
        return givenItems.getPoints() == receivedItemns.getPoints();
    }

    public boolean rebelHasTheItemsToTrade(Rebel rebel, Inventory itemsToTrade){
        Inventory rebelInventory = rebel.getInventory();
        boolean hasTheAmountOfFood = rebelInventory.getFoodAmount() >= itemsToTrade.getFoodAmount();
        boolean hasTheAmountOfGuns = rebelInventory.getGunsAmount() >= itemsToTrade.getGunsAmount();
        boolean hasTheAmountOfWater = rebelInventory.getWaterAmount() >= itemsToTrade.getWaterAmount();
        boolean hasTheAmountOfMunition = rebelInventory.getMunitionAmount() >= itemsToTrade.getMunitionAmount();

        return (hasTheAmountOfFood && hasTheAmountOfGuns && hasTheAmountOfMunition && hasTheAmountOfWater);
    }

    public List<String> validate(Rebel rebel1, Rebel rebel2, Inventory givenItems, Inventory receivedItems) {
        List<String> validationErrors = new ArrayList<>();

        if (Objects.equals(rebel1.getId(), rebel2.getId())) {
            validationErrors.add("Você não pode negociar com você mesmo");
        }

        if (rebel1.isTraitor() || rebel2.isTraitor()) {
            validationErrors.add("Traidores não podem negociar");
        }

        hasEnoughPointsToTrade(rebel1, givenItems, validationErrors);
        hasEnoughPointsToTrade(rebel2, receivedItems, validationErrors);

        hasItemsToTrade(rebel1, givenItems, validationErrors);
        hasItemsToTrade(rebel2, receivedItems, validationErrors);

        if (!Objects.equals(givenItems.getPoints(), receivedItems.getPoints())) {
            validationErrors.add("Os pontos devem ser iguais");
        }

        return validationErrors;
    }

    private void hasItemsToTrade(Rebel rebel, Inventory inventory, List<String> validationErrors) {
        if (inventory.getGunsAmount() > rebel.getInventory().getGunsAmount()) {
            validationErrors.add(rebel.getName() + " não tem armas suficientes para negociar");
        }

        if (inventory.getMunitionAmount() > rebel.getInventory().getMunitionAmount()) {
            validationErrors.add(rebel.getName() + " não tem munições suficientes para negociar");
        }

        if (inventory.getWaterAmount() > rebel.getInventory().getWaterAmount()) {
            validationErrors.add(rebel.getName() + " não tem água suficientes para negociar");
        }

        if (inventory.getFoodAmount() > rebel.getInventory().getFoodAmount()) {
            validationErrors.add(rebel.getName() + " não tem comida suficientes para negociar");
        }
    }

    private void hasEnoughPointsToTrade(Rebel rebel, Inventory inventory, List<String> validationErrors) {
        if (rebel.getInventory().getPoints() < inventory.getPoints()) {
            validationErrors.add(rebel.getName() + " não tem pontos suficientes para negociar");
        }
    }
}
