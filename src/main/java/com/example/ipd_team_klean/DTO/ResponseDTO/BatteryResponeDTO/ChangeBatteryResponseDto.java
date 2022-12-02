package com.example.ipd_team_klean.DTO.ResponseDTO.BatteryResponeDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ChangeBatteryResponseDto {
    private  double value;
    @Builder

    public ChangeBatteryResponseDto(double value) {
        this.value = value;
    }
}
