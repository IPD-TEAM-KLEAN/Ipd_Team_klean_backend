package com.example.ipd_team_klean.DTO.RequestDTO.BlockRequestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
// 상태 변화하면 해당 값 변경
public class RequestUpdateSewerBlockDto {

    private double latitude;
    private double longitude;
    private String state;

    public RequestUpdateSewerBlockDto(double latitude, double longitude, String state) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }
}