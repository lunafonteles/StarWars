package com.letscode.usecases.validators;

import com.letscode.domains.Inventory;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TradeItemsValidator {
    public boolean oneOfThemIsTraitor(Rebel rebel1, Rebel rebel2){
        return rebel1.isTraitor() || rebel2.isTraitor();
    }

    public boolean hasTheSamePoints(Inventory givenItems, Inventory receivedItems){
        return givenItems.getPoints() == receivedItems.getPoints();
    }

    public boolean rebelHasTheItemsToTrade(Rebel rebel, Inventory itemsToTrade){
        Inventory rebelInventory = rebel.getInventory();
        boolean hasTheAmountOfFood = rebelInventory.getFoodAmount() >= itemsToTrade.getFoodAmount();
        boolean hasTheAmountOfGuns = rebelInventory.getGunsAmount() >= itemsToTrade.getGunsAmount();
        boolean hasTheAmountOfWater = rebelInventory.getWaterAmount() >= itemsToTrade.getWaterAmount();
        boolean hasTheAmountOfMunition = rebelInventory.getMunitionAmount() >= itemsToTrade.getMunitionAmount();

        return (hasTheAmountOfFood && hasTheAmountOfGuns && hasTheAmountOfMunition && hasTheAmountOfWater);
    }

    public List<String> validate(Rebel rebel1, Rebel rebel2, Inventory givenItems, Inventory receivedItems){
        List<String> validationErrors = new ArrayList<>();

        if (oneOfThemIsTraitor(rebel1, rebel2)) {
            validationErrors.add("Um deles é traidor");
        }
        if (!hasTheSamePoints(givenItems, receivedItems)) {
            validationErrors.add("A quantidade de pontos a trocar é diferente");
        }
        if (!rebelHasTheItemsToTrade(rebel1, givenItems) || !rebelHasTheItemsToTrade(rebel2, receivedItems)) {
            validationErrors.add("Um dos rebeldes não tem os itens necessárioa para a troca");
        }

        return validationErrors;
    }
}
