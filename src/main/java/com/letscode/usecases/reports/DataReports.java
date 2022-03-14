package com.letscode.usecases.reports;

import com.letscode.domains.Rebel;
import com.letscode.gateways.RebelPersistenceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DataReports {

    private final RebelPersistenceGateway rebelPersistenceGateway;

    public double percentageOfRebel() {
        List<Rebel> list = rebelPersistenceGateway.getAll();
        List<Rebel> rebelList = new ArrayList<>();
        for (Rebel rebel : list) {
            if (!rebel.isTraitor()) {
                rebelList.add(rebel);
            }
        }
        double reportValue = ( (double) rebelList.size() / (double) list.size() ) * 100;
        System.out.println("Value: " + reportValue);
        return reportValue;
    }

    public double percentageOfTraitor() {
        List<Rebel> list = rebelPersistenceGateway.getAll();
        List<Rebel> traitorList = new ArrayList<>();
        for (Rebel rebel : list) {
            if (rebel.isTraitor()) {
                traitorList.add(rebel);
            }
        }
        return ( (double) traitorList.size() / (double) list.size() ) * 100;
    }
}
