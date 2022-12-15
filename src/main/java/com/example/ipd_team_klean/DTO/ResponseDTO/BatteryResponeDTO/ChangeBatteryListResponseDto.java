package com.example.ipd_team_klean.DTO.ResponseDTO.BatteryResponeDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
public class ChangeBatteryListResponseDto {
    private  double value;
    private  LocalDateTime localDateTime;
    private  String latitude;
    private  String longitude;
    private  int sewerId;

    @Builder

    public ChangeBatteryListResponseDto(double value, LocalDateTime localDateTime, String latitude, String longitude, int sewerId) {
        this.value = value;
        this.localDateTime =  localDateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sewerId = sewerId;
    }
}
