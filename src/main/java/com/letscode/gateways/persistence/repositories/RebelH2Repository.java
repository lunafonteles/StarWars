package com.letscode.gateways.persistence.repositories;
import com.letscode.gateways.persistence.Entities.RebelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RebelH2Repository extends JpaRepository<RebelEntity, Long> {

}
