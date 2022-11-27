package com.example.ipd_team_klean.DTO.ResponseDTO.ChageBlockResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ChangeBlockReponseDto {

    private  double value;

    @Builder

    public ChangeBlockReponseDto(double value, LocalDateTime localDateTime) {
        this.value = value;
    }
}
