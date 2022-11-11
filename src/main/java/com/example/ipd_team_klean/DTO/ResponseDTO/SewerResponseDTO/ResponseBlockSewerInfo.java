package com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
public class ResponseBlockSewerInfo {
    private  double Latitude;
    private  double Longtitude;
    private  String State;
    private  int BlockCount;
    private  int Jan;

    private int Feb;

    private int Mar;

    private int Apr;

    private int May;

    private int Jun;

    private int July;

    private int Aug;

    private int Sep;

    private int Oct;

    private int Nov;

    private int Dec;
    private LocalDate BlockDate;
    private LocalTime BlockTime;
    private String Address_name;
    private String Region_name;

    private  int Accumulate_Count;
    @Builder

    public ResponseBlockSewerInfo(double latitude, double longtitude, String state, int blockCount, int jan, int feb, int mar, int apr, int may, int jun, int july, int aug, int sep, int oct, int nov, int dec, LocalDate blockDate, LocalTime blockTime, String address_name, String region_name, int accumulate_Count) {
        Latitude = latitude;
        Longtitude = longtitude;
        State = state;
        BlockCount = blockCount;
        Jan = jan;
        Feb = feb;
        Mar = mar;
        Apr = apr;
        May = may;
        Jun = jun;
        July = july;
        Aug = aug;
        Sep = sep;
        Oct = oct;
        Nov = nov;
        Dec = dec;
        BlockDate = blockDate;
        BlockTime = blockTime;
        Address_name = address_name;
        Region_name = region_name;
        Accumulate_Count = accumulate_Count;
    }
}
