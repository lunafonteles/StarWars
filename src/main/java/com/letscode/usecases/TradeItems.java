package com.letscode.usecases;

import com.letscode.domains.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TradeItems {
    public Inventory execute(Inventory inventory) {
        return null;
    }
    //deverão oferecer mesma quantidade de pontos. Ex: 1 arma e 1 água (1 x 4 + 1 x 2) valem 6 comidas (6 x 1) ou 2 munições (2 x 3).
    //nao precisa armazenar troca, apenas atualizar os inventarios
}
