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
    private  String lat;
    @Column(nullable = false)
    private  String lon;

    @Setter
    //@Column(nullable = false)
    @Column(nullable = false)
    private String Address_name;

    @Setter
    //@Column(nullable = false)
    @Column(nullable = false)
    private String Region_name;

    @Setter
    @Column(  nullable = false)
    private  String state;

    @OneToOne(mappedBy = "sewer")
    private  Block block; // 막힘과

    @OneToOne(mappedBy = "sewer")
    private Small_Sensor small_sensor; //  냄새 와 일대일 관계

    @OneToOne(mappedBy = "sewer")
    private TH_Sensor th_sensor; // 온습도 센서와 일대일 관계


    @OneToOne(mappedBy = "sewer")
    private H_Sensor h_sensor; // 온습도 센서와 일대일 관계





    @Builder

    public Sewer(String latitude, String longitude, String address_name, String region_name, Block block, String state) {
        this.lat = latitude;
        lon = longitude;
        Address_name = address_name;
        Region_name = region_name;
        this.block = block;
        this.state = state;

    }
}
