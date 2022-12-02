package com.example.ipd_team_klean.Repository.BatteryRepository;

import com.example.ipd_team_klean.Entity.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BatteryRepository extends JpaRepository<Battery, Integer> {


}
