package com.example.ipd_team_klean.Repository.SewerRepository;

import com.example.ipd_team_klean.Entity.Sewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface SewerRepository extends JpaRepository<Sewer, Integer>, SewerRepositoryCustom {

    // 위도 경도로 해당 하수구 찾기
    Sewer findByLatAndLon(double lat, double lon);
    Boolean existsByLatAndLon(double lat, double lon);

    Optional findById(int id);

    @Override
    List<Sewer> getStateActiveSewer();
}
