package com.letscode.usecases.validators;

import com.letscode.domains.Rebel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateRebelValidator {

    public List<String> validate(Rebel rebel) {
        List<String> validationErrors = new ArrayList<>();

        if (rebel == null) return List.of("Rebelde não pode ser nulo");

        if (rebel.getId() != null) {
            validationErrors.add("Rebelde já cadastrado. Id=" + rebel.getId());
        }

        if (!StringUtils.hasText(rebel.getName())) {
            validationErrors.add("Nome obrigatório");
        }

        if (!StringUtils.hasText(rebel.getGender())) {
            validationErrors.add("Gênero obrigatório");
        }

        if (rebel.getAge() == null) {
            validationErrors.add("Idade obrigatória");
        }

        if(rebel.getLocation() == null) {
            validationErrors.add("Localização obrigatória");
        }

        if (rebel.getInventory() == null) {
            validationErrors.add("Inventário obrigatório");
        }
        if (rebel.getInventory().getPoints() < 10){
            validationErrors.add("Os pontos do inventário não podem ser inferir a 10");
        }
        if (rebel.getInventory().getPoints() > 10){
            validationErrors.add("Os pontos do inventário não podem ultrapassar a 10");
        }
        return validationErrors;
    }
}
