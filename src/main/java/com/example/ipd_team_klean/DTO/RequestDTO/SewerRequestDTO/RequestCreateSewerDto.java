package com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestCreateSewerDto {
    private double latitude;
    private double longitude;

    private String blcokstate;
    private  String smallstate;
    private  String tstate;
    private  String hstate;

    @Builder

    public RequestCreateSewerDto(double latitude, double longitude, String blcokstate, String smallstate, String tstate, String hstate) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.blcokstate = blcokstate;
        this.smallstate = smallstate;
        this.tstate = tstate;
        this.hstate = hstate;
    }
}
