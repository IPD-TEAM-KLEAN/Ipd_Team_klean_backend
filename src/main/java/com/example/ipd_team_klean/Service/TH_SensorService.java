package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.Repository.TH_SensorRepository.TH_SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TH_SensorService {
    final TH_SensorRepository th_sensorRepository;

}
