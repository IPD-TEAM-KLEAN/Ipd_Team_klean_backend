package com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponseActiveSewerDto {
    private  int id;
    private  double Latitude;
    private  double Longtitude;

    private  String State;
    private String Address_name;

    private String Region_name;

    @Builder

    public ResponseActiveSewerDto(int id,double latitude, double longtitude, String state, String address_name, String region_name) {
        this.id = id;
        Latitude = latitude;
        Longtitude = longtitude;
        State = state;
        Address_name = address_name;
        Region_name = region_name;
    }
}
