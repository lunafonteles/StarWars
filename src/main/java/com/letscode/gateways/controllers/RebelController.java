package com.letscode.gateways.controllers;

import com.letscode.domains.Inventory;
import com.letscode.domains.Location;
import com.letscode.domains.Rebel;
import com.letscode.gateways.controllers.requests.InventoryRequest;
import com.letscode.gateways.controllers.requests.LocationRequest;
import com.letscode.gateways.controllers.requests.RebelRequest;
import com.letscode.gateways.controllers.responses.InventoryResponse;
import com.letscode.gateways.controllers.responses.LocationResponse;
import com.letscode.gateways.controllers.responses.RebelResponse;
import com.letscode.usecases.CreateRebel;
import com.letscode.usecases.ReportRebelAsTraitor;
import com.letscode.usecases.TradeItems;
import com.letscode.usecases.UpdateLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rebels")
@RequiredArgsConstructor
public class RebelController {

    private final CreateRebel createRebel;
    private final ReportRebelAsTraitor reportRebelAsTraitor;
    private final TradeItems tradeItems;
    private final UpdateLocation updateLocation;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public RebelResponse createRebel (@RequestBody RebelRequest rebelRequest) {
        Rebel rebel = rebelRequest.toDomain();
        Rebel rebelSaved = createRebel.create(rebel);
        return new RebelResponse(rebelSaved);
    }

    @PutMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public LocationResponse updateLocation (@PathVariable("id") Long id, @RequestBody LocationRequest locationRequest) {
        Location location = locationRequest.toDomain();
        location.setLatitude(location.getLatitude());
        location.setLongitude(location.getLongitude());
        location.setBase(location.getBase());

        Location locationSaved = updateLocation.update(location);
        return new LocationResponse(locationSaved);
    }

/*    @PutMapping(path = "/trade",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public InventoryResponse tradeItems (@PathVariable("tarde") Long id, @RequestBody InventoryRequest inventoryRequest) {
        Inventory inventory = inventoryRequest.toDomain();
        inventory.setItem(inventory.getItem());
    }*/
    //rever

    //falta o reportRebelAsTraitor()

/*    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<RebelResponse> listRebels () {
        List<Rebel> rebels = listRebels.execute();
        return rebels.stream().map(RebelResponse::new).collect(Collectors.toList());
    }*/

    //n sei se precisa
}
