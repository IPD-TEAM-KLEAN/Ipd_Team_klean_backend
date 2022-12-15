package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.ResponseDTO.BatteryResponeDTO.ChangeBatteryListResponseDto;
import com.example.ipd_team_klean.Entity.Battery;
import com.example.ipd_team_klean.Entity.CollectionBattery;
import com.example.ipd_team_klean.Repository.BatteryRepository.ChangeBatteryRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChangeBatteryService {
    private  final ChangeBatteryRepository changeBatteryRepository;
    public List<ChangeBatteryListResponseDto> batteryList(){
        List<CollectionBattery> batteryList = changeBatteryRepository.findAll();
        List<ChangeBatteryListResponseDto> changeBatteryListResponseDtoList
                = new ArrayList<>();
        for(CollectionBattery battery : batteryList){
            ChangeBatteryListResponseDto changeBatteryListResponseDto = ChangeBatteryListResponseDto.builder()
                    .latitude(battery.getBattery().getSewer().getLat())
                    .longitude(battery.getBattery().getSewer().getLon())
                    .sewerId(battery.getBattery().getSewer().getId())
                    .value(battery.getValue())
                    .localDateTime(battery.getCrateDate())
                    .build();
            changeBatteryListResponseDtoList.add(changeBatteryListResponseDto);
        }
        return changeBatteryListResponseDtoList;
    }

}
