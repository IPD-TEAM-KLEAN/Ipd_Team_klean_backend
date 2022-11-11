package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO.RequestCreateSewerDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseCreateSewerDto;
import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Declaration;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Repository.BlockRepository.BlockRepository;
import com.example.ipd_team_klean.Repository.DeclarationRepository.DeclarationRepository;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SewerService {
    private final SewerRepository sewerRepository;
    private  final  LocationService locationService;
    private  final BlockRepository blockRepository;

    private  final DeclarationRepository declarationRepository;


    public ResponseCreateSewerDto CreateSewer(RequestCreateSewerDto requestCreateSewerDto) throws Exception {
        if(sewerRepository.existsByLatAndLon(requestCreateSewerDto.getLatitude(),requestCreateSewerDto.getLongitude())== true){
            throw  new Exception("해당 하수구가 이미 존재합니다.");
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
                .build();

        Block block = Block.builder()
                .states(requestCreateSewerDto.getState())
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

        // 초기 신고 상태 0 으로 해서 신고 만들기
        Declaration declaration = Declaration.builder().declaration_Count(0).accumulate_Count(0).sewer(sewer).build();


        sewerRepository.save(sewer);
        blockRepository.save(block);
        declarationRepository.save(declaration);


        ResponseCreateSewerDto responseCreateSewerDto = ResponseCreateSewerDto.builder()
                .latitude(sewer.getLat())
                .longtitude(sewer.getLon())
                .address_name(sewer.getAddress_name())
                .region_name(sewer.getRegion_name())
                .build();




        return responseCreateSewerDto;
    }


    //오랜지 하수구 전체 리스트 얻기

    public Sewer findSewer( double lat, double lon){
        return sewerRepository.findByLatAndLon(lat, lon);
    }



}
