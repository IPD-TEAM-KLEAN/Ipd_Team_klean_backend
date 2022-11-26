package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.Service.H_SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class H_SeosorController {
    private H_SensorService h_sensorService;

}
