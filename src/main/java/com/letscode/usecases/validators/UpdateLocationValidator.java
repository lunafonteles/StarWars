package com.letscode.usecases.validators;

import com.letscode.domains.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UpdateLocationValidator {
    public List<String> validate(Location location) {
        List<String> validationErrors = new ArrayList<>();

        if (location.getLatitude() == null) {
            validationErrors.add("Latitude obrigatória");
        }

        if (location.getLongitude() == null) {
            validationErrors.add("Longitude obrigatória");
        }

        if (!StringUtils.hasText(location.getBase())) {
            validationErrors.add("Base obrigatória");
        }

        return validationErrors;
    }

}
