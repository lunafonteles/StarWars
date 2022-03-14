package com.letscode.usecases;

import com.letscode.domains.Rebel;
import com.letscode.gateways.RebelPersistenceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ListRebels {
  private final RebelPersistenceGateway rebelPersistenceGateway;

  public List<Rebel> execute() { return rebelPersistenceGateway.getAll(); }
}
