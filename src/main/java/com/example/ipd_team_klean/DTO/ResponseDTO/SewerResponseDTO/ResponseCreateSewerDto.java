package com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO;

import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Small_Sensor;
import com.example.ipd_team_klean.Entity.TH_Sensor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
public class ResponseCreateSewerDto {
    private  double Latitude;
    private  double Longtitude;

    private String Address_name;

    private String Region_name;

    private Block block;
    private Small_Sensor small_sensor;
    private TH_Sensor th_sensor;

    private  String state;


    @Builder
    public ResponseCreateSewerDto(double latitude, double longtitude, String address_name, String region_name, Block block, Small_Sensor small_sensor, TH_Sensor th_sensor, String state) {
        Latitude = latitude;
        Longtitude = longtitude;
        Address_name = address_name;
        Region_name = region_name;
        this.block = block;
        this.small_sensor = small_sensor;
        this.th_sensor = th_sensor;
        this.state = state;
    }
}
