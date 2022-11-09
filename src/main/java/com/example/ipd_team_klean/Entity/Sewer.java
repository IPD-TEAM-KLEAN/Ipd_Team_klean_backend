package com.example.ipd_team_klean.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Sewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sewer_id")
    private  int id;
    @Column(nullable = false)
    private  double lat;
    @Column(nullable = false)
    private  double lon;

    @Setter
    //@Column(nullable = false)
    @Column(nullable = false)
    private String Address_name;

    @Setter
    //@Column(nullable = false)
    @Column(nullable = false)
    private String Region_name;

    @OneToOne(mappedBy = "sewer")
    private  Block block;
    @Builder

    public Sewer(Double latitude, Double longitude, String address_name, String region_name, Block block) {
        this.lat = latitude;
        lon = longitude;
        Address_name = address_name;
        Region_name = region_name;
        this.block = block;
    }
}
