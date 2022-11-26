package com.example.ipd_team_klean.DTO.RequestDTO.ChnageThRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ChangeHRequestDto {
    @NotNull
    @NotEmpty
    private String latitude;
    @NotNull
    @NotEmpty
    private String longitude;
    private  double value;

    @Builder

    public ChangeHRequestDto(String latitude, String longitude, double value) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.value = value;
    }
}
