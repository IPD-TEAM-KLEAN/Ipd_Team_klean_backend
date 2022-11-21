package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.Service.Small_SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Small_SensorController {
    final Small_SensorService small_sensorService;

}
