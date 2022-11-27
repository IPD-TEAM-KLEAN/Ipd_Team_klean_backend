package com.example.ipd_team_klean.Repository.TH_SensorRepository;

import com.example.ipd_team_klean.Entity.TH_Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TH_SensorRepository extends JpaRepository<TH_Sensor, Integer> {

    List<TH_Sensor> findAll();
}
