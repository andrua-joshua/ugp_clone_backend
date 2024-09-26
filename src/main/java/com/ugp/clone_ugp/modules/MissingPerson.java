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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "missing_persons")
@Builder
public class MissingPerson {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private String status;
    private Date dateReported;
    private String imgUrl;

}
