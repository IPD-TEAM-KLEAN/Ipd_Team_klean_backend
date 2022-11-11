package com.example.ipd_team_klean.DTO.ResponseDTO.DeclarationDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeclarationGetDTO {
    private  double Latitude;
    private  double Longtitude;

    private String Address_name;

    private String Region_name;

    private  int Declaration_Count;
    private  String State;


    @Builder
    public DeclarationGetDTO(double latitude, double longtitude, String address_name, String region_name, int declaration_Count, String state) {
        Latitude = latitude;
        Longtitude = longtitude;
        Address_name = address_name;
        Region_name = region_name;
        Declaration_Count = declaration_Count;
        State = state;
    }
}
