package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.Service.TH_SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TH_SensorController {
    final TH_SensorService th_sensorService;

}
