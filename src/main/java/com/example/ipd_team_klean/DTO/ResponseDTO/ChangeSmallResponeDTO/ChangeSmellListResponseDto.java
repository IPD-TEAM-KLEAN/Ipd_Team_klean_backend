package com.example.ipd_team_klean.DTO.ResponseDTO.ChangeSmallResponeDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ChangeSmellListResponseDto {

    private  double value;
    private LocalDateTime localDateTime;

    private  String latitude;
    private  String longitude;
    private  int sewerId;

    private  String Address_name;

    @Builder

    public ChangeSmellListResponseDto(double value, LocalDateTime localDateTime, String latitude, String longitude, int sewerId, String address_name) {
        this.value = value;
        this.localDateTime = localDateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sewerId = sewerId;
        Address_name = address_name;
    }
}
