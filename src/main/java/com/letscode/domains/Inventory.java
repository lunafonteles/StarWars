package com.letscode.domains;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Inventory {

    public String item;
    public int amount;
    public int points;

}

//obrigatorio ser criado junto c rebelde, n sei se tem q ser sempre igual
//rebelde n pode manipular itens, somente por troca
//1 arma = 4 pt ; 1 Munição = 3 pt ; 1 Água = 2 pt ; 1 Comida = 1 pt


