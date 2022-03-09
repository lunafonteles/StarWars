package com.letscode.usecases;

import com.letscode.domains.Rebel;
import com.letscode.gateways.persistence.repositories.RebelPersistenceCollection;

public class ReportRebelAsTraitor {

    //se 3 rebeldes reportarem uma pessoa, ela se torna traidora
    //não pode negociar recursos nem manipular inventário, nem ser exibido em relatórios.
    //
    public RebelPersistenceCollection rebelPersistenceCollection;

    public void reportTraitor (Rebel rebel){
        Rebel accusedRebel = rebelPersistenceCollection.get(rebel); //apenas se o rebelde não já ser traidor
        int accusationsAmount = accusedRebel.getAccusationsAmount();

        if(accusationsAmount < 2){
            accusedRebel.setAccusationsAmount(accusationsAmount + 1);
        }
        else if(accusationsAmount == 2){
            accusedRebel.setAccusationsAmount(accusationsAmount + 1);
            accusedRebel.setTraitor(true);
            rebelPersistenceCollection.saveTraitor(accusedRebel);
        }
    }
}
