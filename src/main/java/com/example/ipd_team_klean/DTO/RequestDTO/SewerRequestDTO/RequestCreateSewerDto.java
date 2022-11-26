package com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestCreateSewerDto {
    private String latitude;
    private String longitude;



    @Builder

    public RequestCreateSewerDto(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;

    }
}
