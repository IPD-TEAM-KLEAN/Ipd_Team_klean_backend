package com.example.ipd_team_klean.DTO.ResponseDTO.ChageBlockResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ChangeBlockReponseDto {

    private  double value;

    @Builder

    public ChangeBlockReponseDto(double value) {
        this.value = value;
    }
}
