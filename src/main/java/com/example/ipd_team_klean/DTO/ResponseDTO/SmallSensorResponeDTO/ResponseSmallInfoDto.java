package com.example.ipd_team_klean.DTO.ResponseDTO.SmallSensorResponeDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter

public class ResponseSmallInfoDto {
    private  String state;
    private  int SmallCount;
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
    private LocalDate SmallDate;
    private LocalTime SmallTime;

    @Builder
    public ResponseSmallInfoDto(String state, int smallCount, int jan, int feb, int mar, int apr, int may, int jun, int july, int aug, int sep, int oct, int nov, int dec, LocalDate smallDate, LocalTime smallTime) {
        this.state = state;
        SmallCount = smallCount;
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
        SmallDate = smallDate;
        SmallTime = smallTime;
    }
}
