package com.example.ipd_team_klean.DTO.RequestDTO.AdminRequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class AdminJoinRequestDTO {

    @NotNull(message = "이메일은 필수 입력입니다.")
    @NotEmpty(message = "이메일은 빈값이 들어올수 없습니다..")
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private  String adminname;
    @NotNull
    @NotEmpty
    private  String address;
    @NotNull
    @NotEmpty
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
