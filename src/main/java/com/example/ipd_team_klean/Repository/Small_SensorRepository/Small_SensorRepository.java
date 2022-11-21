package com.example.ipd_team_klean.Repository.Small_SensorRepository;

import com.example.ipd_team_klean.Entity.Small_Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface Small_SensorRepository extends JpaRepository<Small_Sensor, Integer> {
}
