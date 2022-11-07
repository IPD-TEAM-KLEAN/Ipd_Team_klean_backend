package com.example.ipd_team_klean.Repository;

import com.example.ipd_team_klean.Entity.Sewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SewerRepository extends JpaRepository<Sewer, Integer>, SewerRepositoryCustom {

    // 위도 경도로 해당 하수구 찾기
    Sewer findByLatAndLon(double lat, double lon);
    Boolean existsByLatAndLon(double lat, double lon);

    @Override
    List<Sewer> getStateActiveSewerOrange(String status);
    @Override
    List<Sewer> getStateActiveSewerRed(String status);

    @Override
    List<Sewer> getBlockJanSewer( );

    @Override
    List<Sewer> getBlockFebSewer( );

    @Override
    List<Sewer> getBlockMarSewer( );

    @Override
    List<Sewer> getBlockAprSewer( );

    @Override
    List<Sewer> getBlockMaySewer( );

    @Override
    List<Sewer> getBlockJunSewer( );

    @Override
    List<Sewer> getBlockJulySewer( );

    @Override
    List<Sewer> getBlockAugSewer( );

    @Override
    List<Sewer> getBlockSepSewer( );

    @Override
    List<Sewer> getBlockOctSewer( );

    @Override
    List<Sewer> getBlockNovSewer( );

    @Override
    List<Sewer> getBlockDecSewer( );
}
