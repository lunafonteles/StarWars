package com.letscode.persistence;
import com.letscode.domains.Rebel;
import java.util.HashMap;
import java.util.Map;

public class RebelPersistence {

    private static Map<String, Rebel> rebels = new HashMap<>();
    private static Map<String, Rebel> trators = new HashMap<>();

    public Rebel save(Rebel rebel) {
        rebels.put(rebel.getName(), rebel);
        return rebel;
    }

    public void delete(Rebel rebel) {
        rebels.remove(rebel.getName());
        trators.put(rebel.getName(), rebel);
    }

    //porcentagem de traidores
    //porcentagem de rebeldes
    //Quantidade média de cada tipo de recurso por rebelde (Ex: 2 armas por rebelde).
    //Pontos perdidos devido a traidores. obs: como sao esses pontos?
    //outros requisitos: documentar endpoints e fornecer forma de usa-los
    //realizar testes
}
