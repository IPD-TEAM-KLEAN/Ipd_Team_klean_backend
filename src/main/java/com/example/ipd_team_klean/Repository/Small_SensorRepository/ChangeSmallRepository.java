package com.example.ipd_team_klean.Repository.Small_SensorRepository;

import com.example.ipd_team_klean.Entity.ChangeSmall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ChangeSmallRepository extends JpaRepository<ChangeSmall , Integer> {

    List<ChangeSmall> findAll();
}
