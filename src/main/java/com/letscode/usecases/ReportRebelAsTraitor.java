package com.letscode.usecases;

import com.letscode.domains.Rebel;
import com.letscode.exceptions.ValidationException;
import com.letscode.gateways.RebelPersistenceGateway;
import com.letscode.usecases.validators.ReportRebelValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportRebelAsTraitor {

    public final RebelPersistenceGateway rebelPersistenceGateway;
    public final ReportRebelValidator reportRebelValidator;

    public Rebel report (Long id){
        Rebel accusedRebel = rebelPersistenceGateway.getById(id);

        val validationErrors = reportRebelValidator.validate(accusedRebel);

        if (!validationErrors.isEmpty()) {
            throw new ValidationException(validationErrors);
        }

        int accusationsAmount = accusedRebel.getAccusationsAmount();

        if(accusationsAmount < 2){
            accusedRebel.setAccusationsAmount(accusationsAmount + 1);
        }
        else if(accusationsAmount == 2){
            accusedRebel.setAccusationsAmount(accusationsAmount + 1);
            accusedRebel.setTraitor(true);
        }
        return accusedRebel;
    }
}
