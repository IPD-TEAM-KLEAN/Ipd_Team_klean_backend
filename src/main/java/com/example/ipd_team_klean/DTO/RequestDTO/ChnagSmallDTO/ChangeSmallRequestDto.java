package com.example.ipd_team_klean.DTO.RequestDTO.ChnagSmallDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
public class ChangeSmallRequestDto {
    @NotNull
    @NotEmpty
    private String latitude;
    @NotNull
    @NotEmpty
    private String longitude;

    private  String state;
    private  double value;
    @Builder
    public ChangeSmallRequestDto(String latitude, String longitude, String state, double value) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
        this.value = value;
    }
}
