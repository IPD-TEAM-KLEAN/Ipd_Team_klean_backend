package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.ChnageThRequestDTO.ChangeTRequestDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO.ChangeTListReponseDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO.ChangeTResponseDto;
import com.example.ipd_team_klean.Entity.ChangeT;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import com.example.ipd_team_klean.Repository.TH_SensorRepository.ChangeTRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChangeTService {
    private  final ChangeTRepository changeTRepository;
    private  final SewerRepository sewerRepository;

    public ChangeTResponseDto changeT(ChangeTRequestDto changeTRequestDto){

        System.out.println(changeTRequestDto.getLatitude());
        System.out.println(changeTRequestDto.getLongitude());
        System.out.println(changeTRequestDto.getValue());





        Sewer findsewer = sewerRepository.findByLatAndLon(changeTRequestDto.getLatitude(), changeTRequestDto.getLongitude());

        findsewer.getTh_sensor().setValue(changeTRequestDto.getValue());
        findsewer.getTh_sensor().setLocalDateTime(LocalDateTime.now());
        sewerRepository.save(findsewer);
        ChangeT changet = ChangeT.builder()
                .value(changeTRequestDto.getValue())
                .crateDate(LocalDateTime.now())
                .th_sensor(findsewer.getTh_sensor())
                .build();
        changeTRepository.save(changet);

        ChangeTResponseDto changeTResponseDto = ChangeTResponseDto.builder()
                .value(changeTRequestDto.getValue())
                .build();

        return  changeTResponseDto;

    }

    public  List<ChangeTListReponseDto> changeTList(){
        List<ChangeT> changeTList = changeTRepository.findAll();
        List<ChangeTListReponseDto> changeTListReponseDtoList = new ArrayList<>();

        for( ChangeT changeT : changeTList ){
            ChangeTListReponseDto changeTListReponseDto = ChangeTListReponseDto
                    .builder()
                    .latitude(changeT.getTh_sensor().getSewer().getLat())
                    .longitude(changeT.getTh_sensor().getSewer().getLon())
                    .sewerId(changeT.getTh_sensor().getSewer().getId())
                    .value(changeT.getValue())
                    .localDateTime(changeT.getCrateDate())
                    .build();

            changeTListReponseDtoList.add(changeTListReponseDto);
        }
        return  changeTListReponseDtoList;
    }
}
