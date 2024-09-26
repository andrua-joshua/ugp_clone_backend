package com.ugp.clone_ugp.helpers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddReportReq {

    private String category;
    private String details;
    private String type;
    private String firstname;
    private String lastname;
    private String phone;
    private double longitude;
    private double latitude;
}
