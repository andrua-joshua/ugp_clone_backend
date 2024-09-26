package com.ugp.clone_ugp.services;

import com.ugp.clone_ugp.helpers.AddStationReq;
import com.ugp.clone_ugp.modules.Station;
import com.ugp.clone_ugp.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    StationRepository stationRepository;

    public List<Station> getAllStations(){
        return stationRepository.findAll();
    }

    public void addStation(AddStationReq stationReq){
        Station station = Station.builder()
                .details(stationReq.getDetails())
                .cid(stationReq.getCid())
                .counter(stationReq.getCounter())
                .traffic(stationReq.getTraffic())
                .name(stationReq.getName())
                .longitude(stationReq.getLongitude())
                .latitude(stationReq.getLatitude())
                .build();

        stationRepository.save(station);
    }


    public void deleteStation(Integer id){
        Station station = stationRepository.findById(id).orElseThrow();
        stationRepository.delete(station);
    }

}
