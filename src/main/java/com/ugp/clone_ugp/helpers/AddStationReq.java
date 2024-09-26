package com.ugp.clone_ugp.helpers;

import com.ugp.clone_ugp.services.StationService;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
public class AddStationReq {

        private String details;
        private  String cid;
        private String counter;
        private String traffic;
        private double longitude;
        private double latitude;
        private String name;

}
