package com.example.ipd_team_klean.DTO.ResponseDTO.ChageBlockResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ChangeBlockListResponseDto {
    private  int id;
    private  double value;
    private LocalDateTime localDateTime;

    private  String latitude;
    private  String longitude;
    private  int sewerId;

    private  String Address_name;

    @Builder

    public ChangeBlockListResponseDto(int id ,double value, LocalDateTime localDateTime, String latitude, String longitude, int sewerId, String address_name) {
        this.id = id;
        this.value = value;
        this.localDateTime = localDateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sewerId = sewerId;
        this.Address_name = address_name;
    }
}
