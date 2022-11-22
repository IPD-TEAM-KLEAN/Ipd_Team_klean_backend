package com.example.ipd_team_klean.Repository.Small_SensorRepository;

import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Small_Sensor;

import java.util.List;

public interface Small_SensorRepositoryCustom {
    List<Small_Sensor> getActiveSmall();
    List<Small_Sensor> getSmallJanSewer( );
    List<Small_Sensor> getSmallFebSewer( );
    List<Small_Sensor> getSmallMarSewer( );
    List<Small_Sensor> getSmallAprSewer( );
    List<Small_Sensor> getSmallMaySewer( );
    List<Small_Sensor> getSmallJunSewer( );
    List<Small_Sensor> getSmallJulySewer( );
    List<Small_Sensor> getSmallAugSewer( );
    List<Small_Sensor> getSmallSepSewer( );
    List<Small_Sensor> getSmallOctSewer( );
    List<Small_Sensor> getSmallNovSewer( );
    List<Small_Sensor> getSmallDecSewer( );
}
