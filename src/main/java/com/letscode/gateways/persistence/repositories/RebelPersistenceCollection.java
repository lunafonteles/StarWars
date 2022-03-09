package com.letscode.gateways.persistence.repositories;
import com.letscode.domains.Rebel;
import java.util.HashMap;
import java.util.Map;

public class RebelPersistenceCollection {

    private static Map<String, Rebel> rebels = new HashMap<>();
    private static Map<String, Rebel> traitors = new HashMap<>();

    public Rebel save(Rebel rebel) {
        rebels.put(rebel.getName(), rebel);
        return rebel;
    }

    public void saveTraitor(Rebel rebel) {
        rebels.remove(rebel.getName());
        traitors.put(rebel.getName(), rebel);
    }

    public Rebel get(Rebel rebel){
        return rebels.get(rebel.getName());
    }
    //porcentagem de traidores
    //porcentagem de rebeldes
    //Quantidade média de cada tipo de recurso por rebelde (Ex: 2 armas por rebelde).
    //Pontos perdidos devido a traidores. obs: como sao esses pontos?
    //outros requisitos: documentar endpoints e fornecer forma de usa-los
    //realizar testes
}
