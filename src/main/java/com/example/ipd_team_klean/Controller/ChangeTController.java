package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.ChnageThRequestDTO.ChangeTRequestDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO.ChangeTResponseDto;
import com.example.ipd_team_klean.Service.ChangeTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChangeTController {
    private  final ChangeTService changeTService;

    @PostMapping("/change/temperature")
    public ResponseEntity<?> ChangeTemperature(@RequestBody ChangeTRequestDto changeTRequestDto){

        ChangeTResponseDto changeTResponseDto = changeTService.changeT(changeTRequestDto);

        return  ResponseEntity.ok().body(changeTResponseDto);
    }


}
