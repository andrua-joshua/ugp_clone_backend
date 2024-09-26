package com.ugp.clone_ugp.controllers;

import com.ugp.clone_ugp.helpers.AddStationReq;
import com.ugp.clone_ugp.modules.Station;
import com.ugp.clone_ugp.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/station")
public class StationController {

    @Autowired
    StationService stationService;


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteStation(
            @PathVariable("id") Integer id
    ){
        stationService.deleteStation(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Station>> getAllStations(){
        return  ResponseEntity.ok(stationService.getAllStations());
    }


    @PostMapping("addStation")
    public ResponseEntity<Void> addStation(
            @RequestBody AddStationReq stationReq
            ) {
        stationService.addStation(stationReq);
        return ResponseEntity.ok().build();
    }


}
