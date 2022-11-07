package com.example.ipd_team_klean.DTO.ResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
public class ResponseUpdateSewerDto {
    private  double Latitude;
    private  double Longitude;
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
    private  LocalDate BlockDate;
    private LocalTime BlockTime;



    @Builder

    public ResponseUpdateSewerDto(double latitude, double longtitude, String state, int blockCount, int jan, int feb, int mar, int apr, int may, int jun, int july, int aug, int sep, int oct, int nov, int dec,LocalDate blockDate ,LocalTime blockTime) {
        Latitude = latitude;
        Longitude = longtitude;
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
    }
}
