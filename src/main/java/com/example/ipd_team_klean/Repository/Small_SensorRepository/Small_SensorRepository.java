package com.example.ipd_team_klean.Repository.Small_SensorRepository;

import com.example.ipd_team_klean.Entity.Small_Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface Small_SensorRepository extends JpaRepository<Small_Sensor, Integer>, Small_SensorRepositoryCustom {


    List<Small_Sensor> findAll();
    @Override
    List<Small_Sensor> getActiveSmall();

    @Override
    List<Small_Sensor> getSmallJanSewer();

    @Override
    List<Small_Sensor> getSmallFebSewer();

    @Override
    List<Small_Sensor> getSmallMarSewer();

    @Override
    List<Small_Sensor> getSmallAprSewer();

    @Override
    List<Small_Sensor> getSmallMaySewer();

    @Override
    List<Small_Sensor> getSmallJunSewer();

    @Override
    List<Small_Sensor> getSmallJulySewer();

    @Override
    List<Small_Sensor> getSmallAugSewer();

    @Override
    List<Small_Sensor> getSmallSepSewer();

    @Override
    List<Small_Sensor> getSmallOctSewer();

    @Override
    List<Small_Sensor> getSmallNovSewer();

    @Override
    List<Small_Sensor> getSmallDecSewer();
}
