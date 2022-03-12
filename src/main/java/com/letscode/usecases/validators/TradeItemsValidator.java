package com.letscode.usecases.validators;

import com.letscode.domains.Inventory;
import com.letscode.domains.ItemsToTrade;
import com.letscode.domains.Rebel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TradeItemsValidator {

    public boolean oneOfThemIsTraitor(Rebel rebel1, Rebel rebel2){
        return rebel1.isTraitor() || rebel2.isTraitor();
    }

    public boolean hasTheSamePoints(ItemsToTrade givenItems, ItemsToTrade receivedItemns){
        return givenItems.getPoints() == receivedItemns.getPoints();
    }

    public boolean rebelHasTheItemsToTrade(Rebel rebel, ItemsToTrade itemsToTrade){
        Inventory rebelInventory = rebel.getInventory();
        boolean hasTheAmountOfFood = rebelInventory.getFoodAmount() >= itemsToTrade.getFoodAmount();
        boolean hasTheAmountOfGuns = rebelInventory.getGunsAmount() >= itemsToTrade.getGunsAmount();
        boolean hasTheAmountOfWater = rebelInventory.getWaterAmount() >= itemsToTrade.getWaterAmount();
        boolean hasTheAmountOfMunition = rebelInventory.getMunitionAmount() >= itemsToTrade.getMunitionAmount();

        return (hasTheAmountOfFood && hasTheAmountOfGuns && hasTheAmountOfMunition && hasTheAmountOfWater);
    }
}
