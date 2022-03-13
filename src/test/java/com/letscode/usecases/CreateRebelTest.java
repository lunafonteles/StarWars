package com.letscode.usecases;

import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.usecases.validators.CreateRebelValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MockitoSettings
class CreateRebelTest {

    @InjectMocks private CreateRebel createRebel;
    @Mock private CreateRebelValidator createRebelValidator;
    @Mock private RebelPersistenceGateway rebelPersistenceGateway;

    @Test
    void should_save_rebel_when_validation_succeed() {
      Rebel rebel = Rebel.builder().build();

      Mockito.when(createRebelValidator.validate(rebel)).thenReturn(List.of());
      createRebel.create(rebel);
      Mockito.verify(rebelPersistenceGateway).save(rebel);
    }

    @Test
    void shouldnt_save_rebel_when_validation_fails() {
        Rebel rebel = Rebel.builder().build();

        Mockito.when(createRebelValidator.validate(rebel)).thenReturn(List.of("Validation error"));
        Assertions.assertThrows(ValidationException.class, () -> createRebel.create(rebel));
    }
}
