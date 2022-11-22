package com.example.ipd_team_klean.DTO.RequestDTO.SmallSensorRequestDTO;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestUpdateSewerSmallDto {
    private  double latitude;
    private  double longitude;

    private  String state;


    @Builder
    public RequestUpdateSewerSmallDto(double latitude, double longitude, String state) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }
}
