package com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ChangeHListReponseDto {
    private  double value;
    private LocalDateTime localDateTime;

    private  String latitude;
    private  String longitude;
    private  int sewerId;

    @Builder

    public ChangeHListReponseDto(double value, LocalDateTime localDateTime, String latitude, String longitude, int sewerId) {
        this.value = value;
        this.localDateTime = localDateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sewerId = sewerId;
    }
}
