package com.ugp.clone_ugp.helpers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddMissingPersonReq {

    private String name;
    private String description;
    private String status;

}
