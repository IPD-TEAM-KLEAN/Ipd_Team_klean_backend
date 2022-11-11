package com.example.ipd_team_klean.DTO.ResponseDTO.DeclarationDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeclarationDTO {

    private int Declaration_Count;

    @Builder
    public DeclarationDTO(int declaration_Count) {
        Declaration_Count = declaration_Count;
    }
}
