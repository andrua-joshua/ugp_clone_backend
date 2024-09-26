package com.ugp.clone_ugp.helpers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddLostAndFoundReq {

    private String nameOnItem;
    private String propertyType;
    private String location;
    private String storage;
    private String contactPhone;
    private String contactPerson;
    private String serialNo;
    private String status;
    private String details;
    private String category;

}
