package com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ChangeTResponseDto {
    private  double value;

    @Builder
    public ChangeTResponseDto(double value) {
        this.value = value;
    }
}
