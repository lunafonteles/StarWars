package com.letscode.usecases;

import com.letscode.domains.Rebel;
import com.letscode.persistence.RebelPersistence;

public class ReportRebelAsTraitor {

    //se 3 rebeldes reportarem uma pessoa, ela se torna traidora
    //não pode negociar recursos nem manipular inventário, nem ser exibido em relatórios.
    //
    public RebelPersistence rebelPersistence;

    public void reportTraitor (Rebel rebel){
        Rebel accusedRebel = rebelPersistence.get(rebel); //apenas se o rebelde não já ser traidor
        int accusationsAmount = accusedRebel.getAccusationsAmount();

        if(accusationsAmount < 2){
            accusedRebel.setAccusationsAmount(accusationsAmount + 1);
        }
        else if(accusationsAmount == 2){
            accusedRebel.setAccusationsAmount(accusationsAmount + 1);
            accusedRebel.setTraitor(true);
            rebelPersistence.saveTraitor(accusedRebel);
        }
    }
}
