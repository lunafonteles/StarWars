package com.letscode.usecases;

import com.letscode.domains.Inventory;
import com.letscode.domains.ItemsToTrade;
import com.letscode.domains.Rebel;
import com.letscode.usecases.validators.TradeItemsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TradeItems {
    //public Inventory execute(Inventory inventory) {
    //    return null;
    //}

    private TradeItemsValidator tradeItemsValidator;

    public void execute(Rebel rebel1, Rebel rebel2, ItemsToTrade givenItems, ItemsToTrade receivedItems){
      if(tradeItemsValidator.oneOfThemIsTraitor(rebel1, rebel2)){
          //exception
      }
      if (!tradeItemsValidator.hasTheSamePoints(givenItems,receivedItems)){
          //exception
      }
      if (!tradeItemsValidator.rebelHasTheItemsToTrade(rebel1,givenItems) || !tradeItemsValidator.rebelHasTheItemsToTrade(rebel2,receivedItems)){
          //execption
      }
      Inventory rebel1Inventory = rebel1.getInventory();
      Inventory rebel2Inventory = rebel2.getInventory();

      updateInventory(rebel1Inventory, givenItems, receivedItems);
      updateInventory(rebel2Inventory, receivedItems, givenItems);
    }

    private void updateInventory(Inventory rebelInventory, ItemsToTrade givenItems, ItemsToTrade receivedItems) {
        rebelInventory.setGunsAmount(rebelInventory.getGunsAmount() - givenItems.getGunsAmount() + receivedItems.getGunsAmount());
        rebelInventory.setMunitionAmount(rebelInventory.getMunitionAmount() - givenItems.getMunitionAmount() + receivedItems.getMunitionAmount());
        rebelInventory.setWaterAmount(rebelInventory.getWaterAmount() - givenItems.getWaterAmount() + receivedItems.getWaterAmount());
        rebelInventory.setFoodAmount(rebelInventory.getFoodAmount() - givenItems.getFoodAmount() + receivedItems.getFoodAmount());
    }

    //deverão oferecer mesma quantidade de pontos. Ex: 1 arma e 1 água (1 x 4 + 1 x 2) valem 6 comidas (6 x 1) ou 2 munições (2 x 3).
    //nao precisa armazenar troca, apenas atualizar os inventarios
}
