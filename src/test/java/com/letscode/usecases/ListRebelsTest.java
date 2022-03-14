package com.letscode.usecases;

import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class ListRebelsTest {

    @InjectMocks ListRebels listRebels;
    @Mock RebelPersistenceGateway rebelPersistenceGateway;

    @Test
    void should_list_rebels_when_validation_succeed() {
        Mockito.when(rebelPersistenceGateway.getAll()).thenReturn(List.of(Rebel.builder().build()));
        listRebels.execute();
    }

    @Test
    void should_throw_exception_when_validation_fails() {
        Assertions.assertThrows(ValidationException.class, () -> listRebels.execute());
    }
}
