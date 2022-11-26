package com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestCreateSewerDto {
    private String latitude;
    private String longitude;

    private String blockstate;
    private  String smallstate;
    private  String tstate;
    private  String hstate;

    @Builder

    public RequestCreateSewerDto(String latitude, String longitude, String blockstate, String smallstate, String tstate, String hstate) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.blockstate = blockstate;
        this.smallstate = smallstate;
        this.tstate = tstate;
        this.hstate = hstate;
    }
}
