package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.Repository.Small_SensorRepository.Small_SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Small_SensorService {
    final Small_SensorRepository small_sensorRepository;

}
