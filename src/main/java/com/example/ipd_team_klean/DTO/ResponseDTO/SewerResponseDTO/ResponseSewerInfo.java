package com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
public class ResponseSewerInfo {
    private  String Latitude;
    private  String Longtitude;
    private  String State;

    private String Address_name;
    private String Region_name;


    @Builder

    public ResponseSewerInfo(String latitude, String longtitude, String state, String address_name, String region_name) {
        Latitude = latitude;
        Longtitude = longtitude;
        State = state;
        Address_name = address_name;
        Region_name = region_name;
    }
}
