package com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponseActiveSewerListSize {
    private int ActiveSewerListSize;

    @Builder

    public ResponseActiveSewerListSize(int activeSewerListSize) {
        ActiveSewerListSize = activeSewerListSize;
    }
}
