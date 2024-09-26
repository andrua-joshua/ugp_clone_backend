package com.ugp.clone_ugp.modules;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "reports")
@Builder
public class Report {

    @Id
    @GeneratedValue
    private Integer id;
    private String category; //Murder or any other type of crime
    private String details;
    private String type; //crime or complaint
    private String firstname;
    private String lastName;
    private String phone;
    @Column(nullable = true)
    private String attachment; //the url of the attachment
//    private String audio; //the url of the audio recording
    private double latitude;
    private double longitude;

}
