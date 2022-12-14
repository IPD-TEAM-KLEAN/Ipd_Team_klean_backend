package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.ChnageThRequestDTO.ChangeTRequestDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO.ChangeTListReponseDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO.ChangeTResponseDto;
import com.example.ipd_team_klean.Service.ChangeTService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChangeTController {
    private  final ChangeTService changeTService;

    @PostMapping("/change/temperature")
    public ResponseEntity<?> ChangeTemperature(@RequestBody ChangeTRequestDto changeTRequestDto){

        ChangeTResponseDto changeTResponseDto = changeTService.changeT(changeTRequestDto);

        System.out.println(changeTResponseDto.getValue());

        return  ResponseEntity.ok().body(changeTResponseDto);
    }

    @GetMapping("/change/temperature/list")
    public ResponseEntity<?> ChangeTemperatureList(){
        List<ChangeTListReponseDto> changeTListReponseDtoList = changeTService.changeTList();

        return ResponseEntity.ok().body(changeTListReponseDtoList);
    }


}
