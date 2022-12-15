package com.example.ipd_team_klean.Repository.BatteryRepository;

import com.example.ipd_team_klean.Entity.ChangeBlock;
import com.example.ipd_team_klean.Entity.CollectionBattery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ChangeBatteryRepository extends JpaRepository<CollectionBattery, Integer> {
    List<CollectionBattery> findAll();
}
