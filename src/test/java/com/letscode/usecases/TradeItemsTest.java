package com.letscode.usecases;

import com.letscode.domains.Inventory;
import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.usecases.validators.TradeItemsValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
public class TradeItemsTest { //Não ta testantdo !!!!!!!!!!!!!!!!!

    @InjectMocks TradeItems tradeItems;
    @Mock TradeItemsValidator tradeItemsValidator;
    @Mock RebelPersistenceGateway rebelPersistenceGateway;

    @Test
    void should_trade_items_when_validation_succeed(){
        Rebel rebel1 = Rebel.builder().build();
        Rebel rebel2 = Rebel.builder().build();

        Inventory givenItems = Inventory.builder().build();
        Inventory receivedItems = Inventory.builder().build();

        Mockito.when(tradeItemsValidator.validate(rebel1,rebel2,givenItems,receivedItems)).thenReturn(List.of());
        tradeItems.trade(rebel1.getId(),rebel2.getId(),givenItems,receivedItems);
        Mockito.verify(rebelPersistenceGateway).tradeItems(rebel1.getId(),rebel2.getId(),givenItems,receivedItems);
    }

    @Test
    void shouldnt_trade_items_when_validation_fails(){
        Rebel rebel1 = Rebel.builder().build();
        Rebel rebel2 = Rebel.builder().build();

        Inventory givenItems = Inventory.builder().build();
        Inventory receivedItems = Inventory.builder().build();

        Mockito.when(tradeItemsValidator.validate(rebel1,rebel2,givenItems,receivedItems)).thenReturn(List.of("Validation error"));
        Assertions.assertThrows(ValidationException.class, () -> tradeItems.trade(rebel1.getId(), rebel2.getId(), givenItems, receivedItems));
    }
}
