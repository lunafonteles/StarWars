package com.letscode.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Item {

    private String name;
    private int amount;
    //private int points;
}
