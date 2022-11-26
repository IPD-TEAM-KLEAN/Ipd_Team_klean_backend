package com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestBlockSewerInfo {
    private String latitude;
    private String longitude;

    @Builder
    public RequestBlockSewerInfo(String latitude, String longitude, String state) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


}
