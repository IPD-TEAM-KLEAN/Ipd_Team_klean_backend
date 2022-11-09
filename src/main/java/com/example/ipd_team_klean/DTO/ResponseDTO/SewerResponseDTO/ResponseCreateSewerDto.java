package com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO;

import com.example.ipd_team_klean.Entity.Block;
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


    @Builder

    public ResponseCreateSewerDto(double latitude, double longtitude, String address_name, String region_name, Block block) {
        Latitude = latitude;
        Longtitude = longtitude;
        Address_name = address_name;
        Region_name = region_name;
        this.block = block;
    }
}
