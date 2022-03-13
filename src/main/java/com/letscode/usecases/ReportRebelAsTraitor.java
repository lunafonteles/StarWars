package com.letscode.usecases;

import com.letscode.domains.Rebel;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.gateways.persistence.RebelPersistenceCollection;
import com.letscode.usecases.validators.ReportRebelValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportRebelAsTraitor {

    //se 3 rebeldes reportarem uma pessoa, ela se torna traidora
    //não pode negociar recursos nem manipular inventário, nem ser exibido em relatórios.
    //
    public RebelPersistenceGateway rebelPersistenceGateway;
    public ReportRebelValidator reportRebelValidator;

    public Rebel report (Rebel rebel){
        Rebel accusedRebel = rebelPersistenceGateway.getByName(rebel); //apenas se o rebelde não já ser traidor
        int accusationsAmount = accusedRebel.getAccusationsAmount();

        if(accusationsAmount < 2){
            accusedRebel.setAccusationsAmount(accusationsAmount + 1);
        }
        else if(accusationsAmount == 2){
            accusedRebel.setAccusationsAmount(accusationsAmount + 1);
            accusedRebel.setTraitor(true);
            rebelPersistenceGateway.saveTraitor(accusedRebel);
        }
        return accusedRebel;
    }
}
