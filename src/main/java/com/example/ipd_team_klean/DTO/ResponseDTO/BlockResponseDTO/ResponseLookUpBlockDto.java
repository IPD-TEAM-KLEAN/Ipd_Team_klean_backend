package com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponseLookUpBlockDto {
    private String state;

    @Builder
    public ResponseLookUpBlockDto(String state) {
        this.state = state;
    }
}
