package com.letscode.usecases.validators;

import com.letscode.domains.Rebel;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ReportRebelValidator {
    public List<String> validate(Rebel rebel) {
        List<String> validationErrors = new ArrayList<>();

        if (rebel.isTraitor() == true) return List.of("Essa pessoa já é traidora");

        return validationErrors;
    }
}
