package com.example.ipd_team_klean.Repository.TH_SensorRepository;

import com.example.ipd_team_klean.Entity.H_Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface H_SensorRepository extends JpaRepository<H_Sensor, Integer> {
}
