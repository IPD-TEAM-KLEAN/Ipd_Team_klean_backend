package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.BatteryRequestDTO.ChangeBatteryRequestDTO;
import com.example.ipd_team_klean.DTO.ResponseDTO.BatteryResponeDTO.ChangeBatteryListResponseDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BatteryResponeDTO.ChangeBatteryResponseDto;
import com.example.ipd_team_klean.Entity.Battery;
import com.example.ipd_team_klean.Entity.CollectionBattery;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Error.CustomException;
import com.example.ipd_team_klean.Error.ErrorCode;
import com.example.ipd_team_klean.Repository.BatteryRepository.BatteryRepository;
import com.example.ipd_team_klean.Repository.BatteryRepository.ChangeBatteryRepository;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BatteryService {
    private  final BatteryRepository batteryRepository;
    private  final SewerRepository sewerRepository;
    private  final ChangeBatteryRepository changeBatteryRepository;



    public ChangeBatteryResponseDto ChangeBatter(ChangeBatteryRequestDTO changeBatteryRequestDTO){
        Sewer findSewer = sewerRepository.findByLatAndLon(changeBatteryRequestDTO.getLatitude(), changeBatteryRequestDTO.getLongitude()); // 해당 하수구 찾기

        if(findSewer == null){
            new CustomException("", ErrorCode.NotFoundUserException);
        }
        findSewer.getBattery().setValue(changeBatteryRequestDTO.getValue());
        findSewer.getBattery().setCreateTime(LocalTime.now());
        findSewer.getBattery().setCreateDate(LocalDate.now());
        findSewer.getBattery().setLocalDateTime(LocalDateTime.now());
        sewerRepository.save(findSewer);

        CollectionBattery collectionBattery = CollectionBattery.builder()
                .battery(findSewer.getBattery())
                .crateDate(LocalDateTime.now())
                .value(changeBatteryRequestDTO.getValue())
                .build();

        changeBatteryRepository.save(collectionBattery);

        ChangeBatteryResponseDto changeBatteryResponseDto = ChangeBatteryResponseDto
                .builder()
                .value(changeBatteryRequestDTO.getValue())
                .build();

        return  changeBatteryResponseDto;

    }



}
