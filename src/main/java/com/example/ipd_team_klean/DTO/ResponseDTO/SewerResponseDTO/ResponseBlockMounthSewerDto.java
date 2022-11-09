package com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponseBlockMounthSewerDto {
    int BlockCount;
    @Builder
    public ResponseBlockMounthSewerDto(int blockCount) {
        BlockCount = blockCount;
    }
}
