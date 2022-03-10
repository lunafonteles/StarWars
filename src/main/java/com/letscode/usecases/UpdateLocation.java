package com.letscode.usecases;

import com.letscode.domains.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateLocation {
    public Location update(Location location) {
    }
    //apenas atualizar, nao precisa armazenar o historico
    //a implement
}
