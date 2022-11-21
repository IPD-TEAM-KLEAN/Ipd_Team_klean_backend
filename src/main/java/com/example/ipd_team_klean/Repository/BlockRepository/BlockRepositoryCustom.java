package com.example.ipd_team_klean.Repository.BlockRepository;

import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Sewer;

import java.util.List;

public interface BlockRepositoryCustom {


    List<Block> getActiveBlock();



    List<Block> getBlockJanSewer( );
    List<Block> getBlockFebSewer( );
    List<Block> getBlockMarSewer( );
    List<Block> getBlockAprSewer( );
    List<Block> getBlockMaySewer( );
    List<Block> getBlockJunSewer( );
    List<Block> getBlockJulySewer( );
    List<Block> getBlockAugSewer( );
    List<Block> getBlockSepSewer( );
    List<Block> getBlockOctSewer( );
    List<Block> getBlockNovSewer( );
    List<Block> getBlockDecSewer( );
}
