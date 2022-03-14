package com.letscode.usecases.validators;

import com.letscode.domains.Rebel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ReportRebelValidator {
    public List<String> validate(Rebel rebel) {
        List<String> validationErrors = new ArrayList<>();

        if (rebel.isTraitor()) return List.of(rebel.getName() + " já é um(a) traidor(a)");

        return validationErrors;
    }
}
