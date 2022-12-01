package com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@NoArgsConstructor
@Getter
public class ResponseSewerInfoBlockSeason {

    private int Jan_Count;

    private int Feb_Count;

    private int Mar_Count;

    private int Apr_Count;

    private int May_Count;

    private int Jun_Count;

    private int July_Count;

    private int Aug_Count;

    private int Sep_Count;

    private int Oct_Count;

    private int Nov_Count;

    private int Dec_Count;


    @Builder
    public ResponseSewerInfoBlockSeason(int jan_Count, int feb_Count, int mar_Count, int apr_Count, int may_Count, int jun_Count, int july_Count, int aug_Count, int sep_Count, int oct_Count, int nov_Count, int dec_Count) {
        Jan_Count = jan_Count;
        Feb_Count = feb_Count;
        Mar_Count = mar_Count;
        Apr_Count = apr_Count;
        May_Count = may_Count;
        Jun_Count = jun_Count;
        July_Count = july_Count;
        Aug_Count = aug_Count;
        Sep_Count = sep_Count;
        Oct_Count = oct_Count;
        Nov_Count = nov_Count;
        Dec_Count = dec_Count;
    }
}
