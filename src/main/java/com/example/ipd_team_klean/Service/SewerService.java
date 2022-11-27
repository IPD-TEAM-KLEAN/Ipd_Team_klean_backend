package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO.RequestCreateSewerDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseLookUpBlockDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseActiveSewerListDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseSewerInfo;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseCreateSewerDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SmallSensorResponeDTO.ResponseLookUpSmallDto;
import com.example.ipd_team_klean.Entity.*;
import com.example.ipd_team_klean.Error.CustomException;
import com.example.ipd_team_klean.Error.ErrorCode;
import com.example.ipd_team_klean.Repository.BlockRepository.BlockRepository;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import com.example.ipd_team_klean.Repository.Small_SensorRepository.Small_SensorRepository;
import com.example.ipd_team_klean.Repository.TH_SensorRepository.H_SensorRepository;
import com.example.ipd_team_klean.Repository.TH_SensorRepository.TH_SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
// 하수구 상태 disable , active
public class SewerService {
    private final SewerRepository sewerRepository;
    private  final  LocationService locationService;
    private  final BlockRepository blockRepository;
    private  final Small_SensorRepository small_sensorRepository;
    private  final TH_SensorRepository th_sensorRepository;

    private  final H_SensorRepository h_sensorRepository;




    public ResponseCreateSewerDto CreateSewer(RequestCreateSewerDto requestCreateSewerDto) throws Exception {
        if(sewerRepository.existsByLatAndLon(requestCreateSewerDto.getLatitude(),requestCreateSewerDto.getLongitude())== true){
            throw new CustomException("해당 이메일이 존재 합니다.", ErrorCode.DuplicatedSewerException);
        }
        //System.out.println(requestCreateSewerDto.getLongitude());
        //System.out.println(requestCreateSewerDto.getLatitude());
        Double parseLong = Double.parseDouble(requestCreateSewerDto.getLongitude());
        Double parseLat = Double.parseDouble(requestCreateSewerDto.getLatitude());
        Map<String, Object> map = locationService.getLocation(parseLong,parseLat).documents[0].address; // y 위도 latitude, x 경도 longitude

       // System.out.println(map);
        Collection<Object> values = map.values();
//        System.out.println(values);
        String Address_name = (String) map.get("address_name");
        String Region_name = (String) map.get("region_1depth_name");
//        System.out.println(Address_name);
//        System.out.println(Region_name);
        Sewer sewer = Sewer.builder()
                .latitude(requestCreateSewerDto.getLatitude())
                .longitude(requestCreateSewerDto.getLongitude())
                .address_name(Address_name)
                .region_name(Region_name)
                .state("Disable")
                .build();

        Block block = Block.builder()
                .states("Disable")
                .blockCount(0)
                .jan_Count(0)
                .feb_Count(0)
                .mar_Count(0)
                .apr_Count(0)
                .may_Count(0)
                .jun_Count(0)
                .july_Count(0)
                .aug_Count(0)
                .sep_Count(0)
                .oct_Count(0)
                .nov_Count(0)
                .sewer(sewer)
                .build();

        Small_Sensor small = Small_Sensor.builder()
                .states("Disable")
                .smallCount(0)
                .jan_Count(0)
                .feb_Count(0)
                .mar_Count(0)
                .apr_Count(0)
                .may_Count(0)
                .jun_Count(0)
                .july_Count(0)
                .aug_Count(0)
                .sep_Count(0)
                .oct_Count(0)
                .nov_Count(0)
                .sewer(sewer)
                .build();

        TH_Sensor th = TH_Sensor.builder()
                .value(0)
                .sewer(sewer)
                .build();

        H_Sensor h = H_Sensor.builder()
                .value(0)
                .sewer(sewer)
                .build();

        sewerRepository.save(sewer);
        blockRepository.save(block);
        small_sensorRepository.save(small);
        th_sensorRepository.save(th);
        h_sensorRepository.save(h);


        ResponseCreateSewerDto responseCreateSewerDto = ResponseCreateSewerDto.builder()
                .latitude(sewer.getLat())
                .longtitude(sewer.getLon())
                .address_name(sewer.getAddress_name())
                .region_name(sewer.getRegion_name())
                .state(sewer.getState())
                .build();

        return responseCreateSewerDto;
    }


    public List<ResponseActiveSewerListDto>  getStateActiveSewer(){
        List<Sewer> sewers = sewerRepository.getStateActiveSewer();
        List<ResponseActiveSewerListDto> responseActiveSewerListDtos = new ArrayList<>();
        for(Sewer sewer : sewers){
           ResponseActiveSewerListDto responseActiveSewerListDto = ResponseActiveSewerListDto.builder()
                   .id(sewer.getId())
                   .address_name(sewer.getAddress_name())
                   .region_name(sewer.getRegion_name())
                    .latitude(sewer.getLat())
                    .longtitude(sewer.getLon())
                    .state(sewer.getState())
                    .build();
            responseActiveSewerListDtos.add(responseActiveSewerListDto);
        }
        return responseActiveSewerListDtos;
    }


    //오랜지 하수구 전체 리스트 얻기

    public ResponseSewerInfo findSewer(int id) throws Throwable {
        Sewer sewer = (Sewer) sewerRepository.findById(id).orElseThrow(()-> new CustomException("",ErrorCode.NotFoundUserException));
        ResponseSewerInfo responseBlockSewerInfo = ResponseSewerInfo.builder()
                .latitude(sewer.getLat())
                .longtitude(sewer.getLon())
                .state(sewer.getState())
                .address_name(sewer.getAddress_name())
                .region_name(sewer.getRegion_name())
                .build();
        return responseBlockSewerInfo;
    }






}
