package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.ChnageThRequestDTO.ChangeHRequestDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO.ChangeHResponseDto;
import com.example.ipd_team_klean.Service.ChangeHService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChangeHContrller {

    private  final ChangeHService changeHService;

    @PostMapping("/change/humidity")
    public ResponseEntity<?> ChangeHumidity(@RequestBody ChangeHRequestDto changeHRequestDto){

        ChangeHResponseDto changeHResponseDto = changeHService.changeH(changeHRequestDto);
        return  ResponseEntity.ok().body(changeHResponseDto);


    }
}
