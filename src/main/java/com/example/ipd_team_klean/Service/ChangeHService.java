package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.ChnageThRequestDTO.ChangeHRequestDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO.ChangeHResponseDto;
import com.example.ipd_team_klean.Entity.ChangeH;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import com.example.ipd_team_klean.Repository.TH_SensorRepository.ChangeHRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChangeHService {
    private  final ChangeHRepository changeHRepository;
    private  final SewerRepository sewerRepository;

    public ChangeHResponseDto changeH(ChangeHRequestDto changeHRequestDto){



        Sewer findsewer = sewerRepository.findByLatAndLon(changeHRequestDto.getLatitude(), changeHRequestDto.getLongitude());

        findsewer.getH_sensor().setValue(changeHRequestDto.getValue());
        findsewer.getH_sensor().setLocalDateTime(LocalDateTime.now());
        sewerRepository.save(findsewer);

        ChangeH changeH  = ChangeH.builder()
                .value(changeHRequestDto.getValue())
                .crateDate(LocalDateTime.now())
                .h_sensor(findsewer.getH_sensor())
                .build();
        changeHRepository.save(changeH);

        ChangeHResponseDto changeHResponseDto = ChangeHResponseDto.builder().value(changeHRequestDto.getValue()).build();
        return  changeHResponseDto;

    }
}
