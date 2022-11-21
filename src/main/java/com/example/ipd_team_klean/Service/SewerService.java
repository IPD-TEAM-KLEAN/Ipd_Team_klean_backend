package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO.RequestCreateSewerDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseActiveSewerListDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseSewerInfo;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseCreateSewerDto;
import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Entity.Small_Sensor;
import com.example.ipd_team_klean.Entity.TH_Sensor;
import com.example.ipd_team_klean.Error.CustomException;
import com.example.ipd_team_klean.Error.ErrorCode;
import com.example.ipd_team_klean.Repository.BlockRepository.BlockRepository;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import com.example.ipd_team_klean.Repository.Small_SensorRepository.Small_SensorRepository;
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





    public ResponseCreateSewerDto CreateSewer(RequestCreateSewerDto requestCreateSewerDto) throws Exception {
        if(sewerRepository.existsByLatAndLon(requestCreateSewerDto.getLatitude(),requestCreateSewerDto.getLongitude())== true){
            throw new CustomException("해당 이메일이 존재 합니다.", ErrorCode.DuplicatedSewerException);
        }
        //System.out.println(requestCreateSewerDto.getLongitude());
        //System.out.println(requestCreateSewerDto.getLatitude());
        Map<String, Object> map = locationService.getLocation(requestCreateSewerDto.getLongitude(),requestCreateSewerDto.getLatitude()).documents[0].address; // y 위도 latitude, x 경도 longitude

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
                .states(requestCreateSewerDto.getBlcokstate())
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
                .states(requestCreateSewerDto.getSmallstate())
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

        System.out.println(requestCreateSewerDto.getTstate());
        TH_Sensor th = TH_Sensor.builder()
                .TStates(requestCreateSewerDto.getTstate())
                .TCount(0)
                .TJan_Count(0)
                .TFeb_Count(0)
                .TMar_Count(0)
                .TApr_Count(0)
                .TMay_Count(0)
                .TJun_Count(0)
                .TJuly_Count(0)
                .TAug_Count(0)
                .TSep_Count(0)
                .TOct_Count(0)
                .TNov_Count(0)
                .HStates(requestCreateSewerDto.getHstate())
                .HCount(0)
                .HJan_Count(0)
                .HFeb_Count(0)
                .HMar_Count(0)
                .HApr_Count(0)
                .HMay_Count(0)
                .HJun_Count(0)
                .HJuly_Count(0)
                .HAug_Count(0)
                .HSep_Count(0)
                .HOct_Count(0)
                .HNov_Count(0)
                .sewer(sewer)
                .build();



        sewerRepository.save(sewer);
        blockRepository.save(block);
        small_sensorRepository.save(small);
        th_sensorRepository.save(th);


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
                .state(sewer.getBlock().getStates())
                .address_name(sewer.getAddress_name())
                .region_name(sewer.getRegion_name())
                .build();
        return responseBlockSewerInfo;
    }



}
