package com.example.ipd_team_klean.DTO.RequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestCreateSewerDto {
    private double latitude;
    private double longitude;
    private String state;

    @Builder
    public RequestCreateSewerDto(double latitude, double longitude, String state) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }
}
