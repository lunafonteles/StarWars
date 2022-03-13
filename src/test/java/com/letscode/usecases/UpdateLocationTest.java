package com.letscode.usecases;

import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.usecases.validators.UpdateLocationValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class UpdateLocationTest {

  @InjectMocks UpdateLocation updateLocation;
  @Mock UpdateLocationValidator updateLocationValidator;
  @Mock RebelPersistenceGateway rebelPersistenceGateway;

  @Test
  void should_update_Location_when_validation_succeed() {
    Rebel rebel = Rebel.builder().build();

    Mockito.when(updateLocationValidator.validate(rebel.getLocation())).thenReturn(List.of());
    updateLocation.update(rebel.getLocation(), rebel.getId());
    Mockito.verify(rebelPersistenceGateway).updateLocation(rebel.getLocation(), rebel.getId());
  }

  @Test
  void shouldnt_update_location_when_validation_fails() {
    Rebel rebel = Rebel.builder().build();

    Mockito.when(updateLocationValidator.validate(rebel.getLocation())).thenReturn(List.of("Validation error"));
    Assertions.assertThrows(ValidationException.class, () -> updateLocation.update(rebel.getLocation(), rebel.getId()));
  }
}