package com.ugp.clone_ugp.modules;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "stations")
@Builder
public class Station {

    @Id
    @GeneratedValue
    private Integer id;
    private String details;
    private  String cid;
    private String counter;
    private String traffic;
    private double longitude;
    private double latitude;
    private String name;
}
