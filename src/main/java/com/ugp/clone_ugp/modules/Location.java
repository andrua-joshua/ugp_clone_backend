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
@Table(name = "locations")
@Builder
public class Location {

    @Id
    @GeneratedValue
    private Integer id;
    private double latitude;
    private double longitude;
}
