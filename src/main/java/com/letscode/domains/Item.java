package com.letscode.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

    public String item;
    public int amount;
    public int points;
}
