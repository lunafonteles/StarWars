package com.letscode.gateways.controllers;

import com.letscode.domains.Rebel;
import com.letscode.gateways.controllers.responses.RebelResponse;
import com.letscode.usecases.reports.DataReports;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final DataReports dataReports;

    @GetMapping(path = "/rebel", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public double reportPercentRebel () {
        return dataReports.percentageOfRebel();
    }

    @GetMapping(path = "/traitor", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public double reportPercentTraitor () {
        try{
            return dataReports.percentageOfTraitor();
        }
        catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ("Lista vazia de Traidores"));
        }
    }




}



