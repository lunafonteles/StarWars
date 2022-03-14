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

@MockitoSettings
class GetRebelByIdTest {

    @InjectMocks private GetRebelById getRebelById;
    @Mock private RebelPersistenceGateway rebelPersistenceGateway;

    @Test
    void should_get_rebel_by_id_when_validation_succeed() {
        Rebel rebel = Rebel.builder().id(1L).build();
        getRebelById.execute(rebel.getId());
        Mockito.verify(rebelPersistenceGateway).getById(rebel.getId());
    }

    @Test
    void should_throw_exception_when_validation_fails() {
        Rebel rebel = Rebel.builder().build();
        Assertions.assertThrows(ValidationException.class, () -> getRebelById.execute(rebel.getId()));
    }
}
