package com.letscode.usecases.reports;

import com.letscode.domains.Rebel;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.usecases.ListRebels;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DataReports {

    private final RebelPersistenceGateway rebelPersistenceGateway;

    public float percentageOfRebel() {
        List<Rebel> list = rebelPersistenceGateway.getAll();
        List<Rebel> rebelList = new ArrayList<>();
        for (Rebel rebel : list) {
            if (!rebel.isTraitor()) {
                rebelList.add(rebel);
            }
        }

        return ( rebelList.size() / list.size() ) * 100;
    }

    public float percentageOfTraitor() {
        List<Rebel> list = rebelPersistenceGateway.getAll();
        List<Rebel> traitorList = new ArrayList<>();
        for (Rebel rebel : list) {
            if (rebel.isTraitor()) {
                traitorList.add(rebel);
            }
        }
        return ( traitorList.size() / list.size() ) * 100;
    }

}
