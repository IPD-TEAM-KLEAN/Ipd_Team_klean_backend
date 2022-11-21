package com.example.ipd_team_klean.DTO.ResponseDTO.AdminResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class AdminJoinResponseDTO {
    private String email;
    private  String adminname;
    private  String address;
    private  String phoneNumber;
    private LocalDate createDate;
    @Builder

    public AdminJoinResponseDTO(String email, String adminname, String address, String phoneNumber, LocalDate createDate) {
        this.email = email;
        this.adminname = adminname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.createDate = createDate;
    }
}
