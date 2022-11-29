package com.example.ipd_team_klean.Repository.SewerRepository;

import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseActiveSewerListDto;
import com.example.ipd_team_klean.Entity.Sewer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface SewerRepositoryCustom {
    List<Sewer> getStateActiveSewer();

    Slice<ResponseActiveSewerListDto> getSewerScroll(Pageable pageable);
}
