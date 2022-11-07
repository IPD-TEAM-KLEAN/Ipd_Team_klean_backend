package com.example.ipd_team_klean.Repository;

import com.example.ipd_team_klean.Entity.Sewer;

import java.util.List;

public interface SewerRepositoryCustom {
    List<Sewer> getStateActiveSewerOrange(String status);
    List<Sewer> getStateActiveSewerRed(String status);

    List<Sewer> getBlockJanSewer( );
    List<Sewer> getBlockFebSewer( );
    List<Sewer> getBlockMarSewer( );
    List<Sewer> getBlockAprSewer( );
    List<Sewer> getBlockMaySewer( );
    List<Sewer> getBlockJunSewer( );
    List<Sewer> getBlockJulySewer( );
    List<Sewer> getBlockAugSewer( );
    List<Sewer> getBlockSepSewer( );
    List<Sewer> getBlockOctSewer( );
    List<Sewer> getBlockNovSewer( );
    List<Sewer> getBlockDecSewer( );

}
