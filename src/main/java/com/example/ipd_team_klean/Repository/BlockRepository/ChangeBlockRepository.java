package com.example.ipd_team_klean.Repository.BlockRepository;

import com.example.ipd_team_klean.Entity.ChangeBlock;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ChangeBlockRepository extends JpaRepository <ChangeBlock, Integer> {

    List<ChangeBlock> findAll();

}
