package com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestBlockSewerInfo {
    private double latitude;
    private double longitude;

    @Builder
    public RequestBlockSewerInfo(double latitude, double longitude, String state) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


}
