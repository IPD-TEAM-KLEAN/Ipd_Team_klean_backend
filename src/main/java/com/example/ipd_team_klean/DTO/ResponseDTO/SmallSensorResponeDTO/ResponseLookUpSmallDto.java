package com.example.ipd_team_klean.DTO.ResponseDTO.SmallSensorResponeDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponseLookUpSmallDto {
    private String state;

    @Builder
    public ResponseLookUpSmallDto(String state) {
        this.state = state;
    }
}
