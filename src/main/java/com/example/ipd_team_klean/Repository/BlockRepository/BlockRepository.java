package com.example.ipd_team_klean.Repository.BlockRepository;

import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Sewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BlockRepository extends JpaRepository<Block, Integer> , BlockRepositoryCustom{

    List<Block> findAll();

    @Override
    List<Block> getActiveBlock();


    /////////////////////////////////////


    @Override
    List<Block> getBlockJanSewer();

    @Override
    List<Block> getBlockFebSewer();

    @Override
    List<Block> getBlockMarSewer();

    @Override
    List<Block> getBlockAprSewer();

    @Override
    List<Block> getBlockMaySewer();

    @Override
    List<Block> getBlockJunSewer();

    @Override
    List<Block> getBlockJulySewer();

    @Override
    List<Block> getBlockAugSewer();

    @Override
    List<Block> getBlockSepSewer();

    @Override
    List<Block> getBlockOctSewer();

    @Override
    List<Block> getBlockNovSewer();

    @Override
    List<Block> getBlockDecSewer();
}
