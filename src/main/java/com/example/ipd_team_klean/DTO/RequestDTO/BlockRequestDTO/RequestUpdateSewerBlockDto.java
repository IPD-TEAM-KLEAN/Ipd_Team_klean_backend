package com.example.ipd_team_klean.DTO.RequestDTO.BlockRequestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
// 상태 변화하면 해당 값 변경
public class RequestUpdateSewerBlockDto {

    @NotNull
    @NotEmpty
    private String latitude;
    @NotNull
    @NotEmpty
    private String longitude;
    @NotNull
    @NotEmpty
    private String state;

    public RequestUpdateSewerBlockDto(String latitude, String longitude, String state) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }
}
