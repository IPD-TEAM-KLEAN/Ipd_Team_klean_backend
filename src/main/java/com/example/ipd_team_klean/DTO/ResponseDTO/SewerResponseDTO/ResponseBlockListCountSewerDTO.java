package com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponseBlockListCountSewerDTO {
    private  int num;

    @Builder
    public ResponseBlockListCountSewerDTO(int num) {
        this.num = num;
    }
}
