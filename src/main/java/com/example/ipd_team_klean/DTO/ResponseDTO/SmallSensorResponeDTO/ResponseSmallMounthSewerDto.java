package com.example.ipd_team_klean.DTO.ResponseDTO.SmallSensorResponeDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponseSmallMounthSewerDto {
    int SmallCount;
    @Builder
    public ResponseSmallMounthSewerDto(int smallCount) {
        SmallCount = smallCount;
    }
}
