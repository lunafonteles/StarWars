package com.letscode.usecases;

import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ListRebels {
  private final RebelPersistenceGateway rebelPersistenceGateway;

  public List<Rebel> execute() {

      if (rebelPersistenceGateway.getAll().isEmpty()) {
          throw new ValidationException("A lista de rebeldes está vazia");
      }

      return rebelPersistenceGateway.getAll();
  }
}
