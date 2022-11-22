package com.example.ipd_team_klean.DTO.ResponseDTO.SmallSensorResponeDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponeQuarterSmallDto {
    private  int firstquarter;
    private  int secondquarter;
    private  int thirdquarter;
    private  int fourthquarter;
    @Builder

    public ResponeQuarterSmallDto(int firstquarter, int secondquarter, int thirdquarter, int fourthquarter) {
        this.firstquarter = firstquarter;
        this.secondquarter = secondquarter;
        this.thirdquarter = thirdquarter;
        this.fourthquarter = fourthquarter;
    }
}
