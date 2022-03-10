package com.letscode.domains;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Inventory {
    private Long id;
    private List<Item> item;

}

//obrigatorio ser criado junto c rebelde, n sei se tem q ser sempre igual
//rebelde n pode manipular itens, somente por troca
//1 arma = 4 pt ; 1 Munição = 3 pt ; 1 Água = 2 pt ; 1 Comida = 1 pt


