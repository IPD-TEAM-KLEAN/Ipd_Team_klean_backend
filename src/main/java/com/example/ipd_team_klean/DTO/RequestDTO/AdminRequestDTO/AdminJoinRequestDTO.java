package com.example.ipd_team_klean.DTO.RequestDTO.AdminRequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AdminJoinRequestDTO {
    private String email;
    private String password;
    private  String adminname;
    private  String address;
    private  String phoneNumber;

    @Builder
    public AdminJoinRequestDTO(String email, String password, String adminname, String address, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.adminname = adminname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
