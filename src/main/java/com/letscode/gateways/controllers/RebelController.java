package com.letscode.gateways.controllers;

import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import com.letscode.gateways.controllers.requests.LocationRequest;
import com.letscode.gateways.controllers.requests.RebelRequest;
import com.letscode.gateways.controllers.responses.RebelResponse;
import com.letscode.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rebels")
@RequiredArgsConstructor
public class RebelController {

    private final CreateRebel createRebel;
    private final ReportRebelAsTraitor reportRebelAsTraitor;
    private final TradeItems tradeItems;
    private final UpdateLocation updateLocation;
    private final GetRebelById getRebelById;

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

//    @PatchMapping (path = "/report",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public RebelResponse reportRebelAsTraitor (Long id, @RequestBody RebelRequest rebelRequest) {
//        Rebel rebel = rebelRequest.toDomain();
//        rebel.getId(id);
//        Rebel reportSaved = reportRebelAsTraitor.report(rebel);
//        return new RebelResponse(reportSaved);
        //todo ajeitar

/*    @PutMapping(path = "/trade",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public InventoryResponse tradeItems (Long id, @RequestBody InventoryRequest inventoryRequest) {
        Inventory inventory = inventoryRequest.toDomain();
        inventory.setItem(inventory.getItem());

        Inventory inventorySaved = tradeItems.execute(inventory);
        return new InventoryResponse((inventorySaved));
    }*/
    //todo: ajeitar

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Rebel> getById (Long id) {
        Optional<Rebel> rebel = getRebelById.execute(id);
        return rebel;
    }


/*    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<RebelResponse> listRebels () {
        List<Rebel> rebels = listRebels.execute();
        return rebels.stream().map(RebelResponse::new).collect(Collectors.toList());
    }*/

    //n sei se precisa
}
