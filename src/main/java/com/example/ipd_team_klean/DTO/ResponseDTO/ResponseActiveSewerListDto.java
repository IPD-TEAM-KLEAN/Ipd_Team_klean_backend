package com.example.ipd_team_klean.DTO.ResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponseActiveSewerListDto {
    private  double Latitude;
    private  double Longtitude;

    private  String State;

    @Builder

    public ResponseActiveSewerListDto(double latitude, double longtitude, String state) {
        Latitude = latitude;
        Longtitude = longtitude;
        State = state;
    }
}
