package com.example.ipd_team_klean.DTO.ResponseDTO.SmallSensorResponeDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponseActiveSmallSewerListDto {
    private  int id;
    private  String Latitude;
    private  String Longtitude;

    private  String State;
    private String Address_name;

    private String Region_name;


    @Builder
    public ResponseActiveSmallSewerListDto(int id, String latitude, String longtitude, String state, String address_name, String region_name) {
        this.id = id;
        Latitude = latitude;
        Longtitude = longtitude;
        State = state;
        Address_name = address_name;
        Region_name = region_name;
    }
}
