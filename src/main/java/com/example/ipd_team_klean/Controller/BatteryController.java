package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.BatteryRequestDTO.ChangeBatteryRequestDTO;
import com.example.ipd_team_klean.DTO.ResponseDTO.BatteryResponeDTO.ChangeBatteryResponseDto;
import com.example.ipd_team_klean.Service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BatteryController {
    private final BatteryService batteryService;

    @PostMapping("/change/battery")
    public ResponseEntity<?> changeBatter(@RequestBody ChangeBatteryRequestDTO changeBatteryRequestDTO){

        ChangeBatteryResponseDto changeBatteryResponseDto = batteryService.ChangeBatter(changeBatteryRequestDTO);
        return ResponseEntity.ok().body(changeBatteryResponseDto);

    }

}
