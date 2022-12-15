package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.ResponseDTO.BatteryResponeDTO.ChangeBatteryListResponseDto;
import com.example.ipd_team_klean.Service.ChangeBatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChangeBatteryController {

    private  final ChangeBatteryService changeBatteryService;

    @GetMapping("/change/battery/list")
    public ResponseEntity<?> ChangeBatterList(){
        List<ChangeBatteryListResponseDto> changeBatteryListResponseDtoList= changeBatteryService.batteryList();

        return ResponseEntity.ok().body(changeBatteryListResponseDtoList);
    }
}
