package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.BatteryRequestDTO.ChangeBatteryRequestDTO;
import com.example.ipd_team_klean.DTO.ResponseDTO.BatteryResponeDTO.ChangeBatteryResponseDto;
import com.example.ipd_team_klean.Entity.Battery;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Error.CustomException;
import com.example.ipd_team_klean.Error.ErrorCode;
import com.example.ipd_team_klean.Repository.BatteryRepository.BatteryRepository;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class BatteryService {
    private  final BatteryRepository batteryRepository;
    private  final SewerRepository sewerRepository;



    public ChangeBatteryResponseDto ChangeBatter(ChangeBatteryRequestDTO changeBatteryRequestDTO){
        Sewer findSewer = sewerRepository.findByLatAndLon(changeBatteryRequestDTO.getLatitude(), changeBatteryRequestDTO.getLongitude()); // 해당 하수구 찾기

        if(findSewer == null){
            new CustomException("", ErrorCode.NotFoundUserException);
        }
        findSewer.getBattery().setValue(changeBatteryRequestDTO.getValue());
        findSewer.getBattery().setCreateTime(LocalTime.now());
        findSewer.getBattery().setCreateDate(LocalDate.now());

        sewerRepository.save(findSewer);

        ChangeBatteryResponseDto changeBatteryResponseDto = ChangeBatteryResponseDto
                .builder()
                .value(changeBatteryRequestDTO.getValue())
                .build();

        return  changeBatteryResponseDto;

    }
}
