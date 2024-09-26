package com.ugp.clone_ugp.modules;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lost_and_found_items")
@Builder
public class LostAndFound {

    @Id
    @GeneratedValue
    private Integer id;
    private String nameOnItem;
    private String imgUrl;
    private String propertyType;
    private String location;
    private String storage;
    private String contactPhone;
    private String contactPerson;
    private String serialNo;
    private String status;
    private String details;
    private Date dateFound;
    private String category;

}
