package com.example.ipd_team_klean.Repository.DeclarationRepository;

import com.example.ipd_team_klean.Entity.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DeclarationRepository extends JpaRepository<Declaration, Integer> , DeclarationRepositoryCustom{


    @Override
    List<Declaration> getDeclarationSewer();
}
