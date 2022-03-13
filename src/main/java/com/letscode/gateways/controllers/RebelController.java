package com.letscode.gateways.controllers;

import com.letscode.domains.Inventory;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import com.letscode.gateways.controllers.requests.TradeRequest;
import com.letscode.gateways.controllers.requests.LocationRequest;
import com.letscode.gateways.controllers.requests.RebelRequest;
import com.letscode.gateways.controllers.responses.RebelResponse;
import com.letscode.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rebels")
@RequiredArgsConstructor
public class RebelController {

    private final CreateRebel createRebel;
    private final ReportRebelAsTraitor reportRebelAsTraitor;
    private final TradeItems tradeItems;
    private final UpdateLocation updateLocation;
    private final GetRebelById getRebelById;
    private final ListRebels listRebels;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public RebelResponse createRebel (@RequestBody RebelRequest rebelRequest) {
        Rebel rebel = rebelRequest.toDomain();
        Rebel rebelSaved = createRebel.create(rebel);
        return new RebelResponse(rebelSaved);
    }

    @PatchMapping (path = "/{id}/location",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public RebelResponse updateLocation (Long rebelId, @RequestBody LocationRequest locationRequest) {
        Location location = locationRequest.toDomain();
        Rebel locationSaved = updateLocation.update(location, rebelId);
        return new RebelResponse(locationSaved);
    }

    @PatchMapping (path = "/{id}/report",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public RebelResponse reportRebelAsTraitor (Long id, @RequestBody RebelRequest rebelRequest) {
        Rebel rebel = rebelRequest.toDomain();
        Rebel accusationsSaved = reportRebelAsTraitor.report(rebel);
        return new RebelResponse(accusationsSaved);
        //todo ajeitar
    }

    @PutMapping(path = "/trade",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public boolean tradeItems (Long rebel1Id, Long rebel2Id, @RequestBody TradeRequest tradeRequest) {
        try{
            tradeItems.trade(rebel1Id, rebel2Id, tradeRequest.getGivenItems(), tradeRequest.getReceiveItems());
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    //todo: ajeitar

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Rebel getById (Long id) {
        Rebel rebel = getRebelById.execute(id);
        return rebel;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<RebelResponse> listRebels () {
        List<Rebel> rebels = listRebels.execute();
        return rebels.stream().map(RebelResponse::new).collect(Collectors.toList());
    }

}
