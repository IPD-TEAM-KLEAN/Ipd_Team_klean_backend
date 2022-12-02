package com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
public class ResponseSewerInfo {
    private  String Latitude;
    private  String Longtitude;
    private  String State;

    private String Address_name;
    private String Region_name;


    private  Double nowTemperature;


    private  Double nowHumidity;

    private int BlockCount;
    private  LocalDate BlockDate;
    private  LocalTime BlockTime;
    private  Double BlockValue;

    private  int SmallCount;
    private  LocalDate SmallDate;
    private  LocalTime SmallTime;

    private  double BatteryValue;
    private  LocalDate BatteryDate;
    private  LocalTime BatteryTime;








    @Builder
    public ResponseSewerInfo(String latitude, String longtitude, String state, String address_name, String region_name, Double nowTemperature, Double nowHumidity, int blockCount, LocalDate blockDate, LocalTime blockTime, Double blockValue, int smallCount, LocalDate smallDate, LocalTime smallTime, double batteryValue, LocalDate batteryDate, LocalTime batteryTime) {
        Latitude = latitude;
        Longtitude = longtitude;
        State = state;
        Address_name = address_name;
        Region_name = region_name;
        this.nowTemperature = nowTemperature;
        this.nowHumidity = nowHumidity;
        BlockCount = blockCount;
        BlockDate = blockDate;
        BlockTime = blockTime;
        BlockValue = blockValue;
        SmallCount = smallCount;
        SmallDate = smallDate;
        SmallTime = smallTime;
        this.BatteryValue = batteryValue;
        this.BatteryDate = batteryDate;
        this.BatteryTime= batteryTime;
    }
}
