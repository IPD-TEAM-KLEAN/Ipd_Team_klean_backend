package com.example.ipd_team_klean.DTO.RequestDTO.ChnageBlockDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ChangeBlockRequestDto {
    @NotNull
    @NotEmpty
    private String latitude;
    @NotNull
    @NotEmpty
    private String longitude;

    private  String state;
    private  double value;

    @Builder

    public ChangeBlockRequestDto(String latitude, String longitude, String state, double value) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
        this.value = value;
    }
}
