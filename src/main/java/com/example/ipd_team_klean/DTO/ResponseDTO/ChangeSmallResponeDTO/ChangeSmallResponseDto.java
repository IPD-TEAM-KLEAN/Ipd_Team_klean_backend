package com.example.ipd_team_klean.DTO.ResponseDTO.ChangeSmallResponeDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ChangeSmallResponseDto {
    private  double value;

    @Builder
    public ChangeSmallResponseDto(double value) {
        this.value = value;
    }
}
