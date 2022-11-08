package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.RequestBlockSewerInfo;
import com.example.ipd_team_klean.DTO.RequestDTO.RequestCreateSewerDto;
import com.example.ipd_team_klean.DTO.RequestDTO.RequestUpdateSewerDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.*;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Service.SewerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SewerController {

    private final SewerService sewerService;

    @Autowired
    public SewerController(SewerService sewerService) {
        this.sewerService = sewerService;
    }




    // 하수구 생성 및 db 저장
    @PostMapping("/create/sewer")
    public ResponseEntity<?> CreateSewer(@RequestBody RequestCreateSewerDto requestCreateSewerDto) throws Exception {

        Sewer sewer = sewerService.CreateSewer(requestCreateSewerDto);

        ResponseCreateSewerDto responseCreateSewerDto = ResponseCreateSewerDto.builder()
                .latitude(sewer.getLat())
                .longtitude(sewer.getLon())
                .state(sewer.getStates())
                .blockCount(sewer.getBlockCount())
                .jan(sewer.getJan_Count())
                .feb(sewer.getFeb_Count())
                .mar(sewer.getMar_Count())
                .apr(sewer.getApr_Count())
                .may(sewer.getMay_Count())
                .jun(sewer.getJun_Count())
                .july(sewer.getJuly_Count())
                .aug(sewer.getAug_Count())
                .sep(sewer.getSep_Count())
                .oct(sewer.getOct_Count())
                .nov(sewer.getNov_Count())
                .dec(sewer.getDec_Count())
                .address_name(sewer.getAddress_name())
                .region_name(sewer.getRegion_name())
                .build();
        return  ResponseEntity.ok().body(responseCreateSewerDto);
    }


    // 하수구 상태 업데이트 (센서에서 들어 온 값 업데이트)
    @PutMapping("/update/sewer")
    public ResponseEntity<?> UpdateSewer(@RequestBody RequestUpdateSewerDto requestUpdateSewerDto) throws Exception {
        Sewer sewer = sewerService.UpdateSewer(requestUpdateSewerDto);
        ResponseUpdateSewerDto responseUpdateSewerDto = ResponseUpdateSewerDto.builder()
                .latitude(sewer.getLat())
                .longtitude(sewer.getLon())
                .state(sewer.getStates())
                .blockCount(sewer.getBlockCount())
                .jan(sewer.getJan_Count())
                .feb(sewer.getFeb_Count())
                .mar(sewer.getMar_Count())
                .apr(sewer.getApr_Count())
                .may(sewer.getMay_Count())
                .jun(sewer.getJun_Count())
                .july(sewer.getJuly_Count())
                .aug(sewer.getAug_Count())
                .sep(sewer.getSep_Count())
                .oct(sewer.getOct_Count())
                .nov(sewer.getNov_Count())
                .dec(sewer.getDec_Count())
                .blockDate(sewer.getBlockDate())
                .blockTime(sewer.getBlockTime())
                .build();
        return ResponseEntity.ok().body(responseUpdateSewerDto);


    }
    // 막힌 하수구 전체 리스트 보기
    @GetMapping("/active/state/sewer")
    public ResponseEntity<?> ActiveStateSewer(){
      List<ResponseActiveSewerListDto> responseActiveSewerListDtos = findActiveSewer();
        Map<String, Object> result = new HashMap<>();
        result.put("data", responseActiveSewerListDtos);
        return ResponseEntity.ok().body(responseActiveSewerListDtos);


    }
    @GetMapping("/block/list/count/sewer")
    public ResponseEntity<?> BlockListCountSewer(){
        List<ResponseActiveSewerListDto> responseActiveSewerListDtos = findActiveSewer();
        int num = responseActiveSewerListDtos.size();
        ResponseBlockListCountSewerDTO responseBlockListCountSewerDTO = ResponseBlockListCountSewerDTO.builder().num(num).build();

        return  ResponseEntity.ok().body(responseBlockListCountSewerDTO);


    }

    @GetMapping("block/sewer/info")
    public  ResponseEntity<?> BlockSewerInfo(@RequestBody RequestBlockSewerInfo requestBlockSewerInfo){
        Sewer sewer = sewerService.findSewer(requestBlockSewerInfo.getLatitude(),requestBlockSewerInfo.getLongitude());

        ResponseBlockSewerInfo responseBlockSewerInfo = ResponseBlockSewerInfo.builder()
                .latitude(sewer.getLat())
                .longtitude(sewer.getLon())
                .state(sewer.getStates())
                .blockCount(sewer.getBlockCount())
                .jan(sewer.getJan_Count())
                .feb(sewer.getFeb_Count())
                .mar(sewer.getMar_Count())
                .apr(sewer.getApr_Count())
                .may(sewer.getMay_Count())
                .jun(sewer.getJun_Count())
                .july(sewer.getJuly_Count())
                .aug(sewer.getAug_Count())
                .sep(sewer.getSep_Count())
                .oct(sewer.getOct_Count())
                .nov(sewer.getNov_Count())
                .dec(sewer.getDec_Count())
                .blockDate(sewer.getBlockDate())
                .blockTime(sewer.getBlockTime())
                .build();
        return ResponseEntity.ok().body(responseBlockSewerInfo);
    }

    // 월별 막힌 횟수 받기
    @GetMapping("block/1/sewer")
    public ResponseEntity<?> Block1Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getJanBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/2/sewer")
    public ResponseEntity<?> Block2Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getFebBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/3/sewer")
    public ResponseEntity<?> Block3Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getMarBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/4/sewer")
    public ResponseEntity<?> Block4Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getAprBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/5/sewer")
    public ResponseEntity<?> Block5Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getMayBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/6/sewer")
    public ResponseEntity<?> Block6Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getJunBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/7/sewer")
    public ResponseEntity<?> Block7Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getJulyBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/8/sewer")
    public ResponseEntity<?> Block8Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getAugBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/9/sewer")
    public ResponseEntity<?> Block9Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getSepBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/10/sewer")
    public ResponseEntity<?> Block10Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getOctBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/11/sewer")
    public ResponseEntity<?> Block11Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getNovBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/12/sewer")
    public ResponseEntity<?> Block12Sewer(){
        // 1월 하수구 찾기
        int BlockCount = sewerService.getDecBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }





    // 메소드 하수구 전체 리스크 보기 및 하수구 전체 리스트 개수 확인시 사용
    public List<ResponseActiveSewerListDto> findActiveSewer(){
        List<Sewer> orangeSewers = sewerService.ListActiveStateOrage("orange");// 분홍일시 하수구 얻기
        List<Sewer> redSewers = sewerService.ListActiveStateRed("red");// 빨강 하수구 얻기

        List<ResponseActiveSewerListDto> responseActiveSewerListDtos = new ArrayList<>();

//        for(Sewer sewer :redSewers){
//            ResponseActiveSewerListDto responseActiveSewerListDto = ResponseActiveSewerListDto.builder()
//                    .latitude(sewer.getLat())
//                    .longtitude(sewer.getLon())
//                    .build();
//            responseActiveSewerListDtos.add(responseActiveSewerListDto);
//
//        }
        for(Sewer sewer : orangeSewers){
            ResponseActiveSewerListDto responseActiveSewerListDto = ResponseActiveSewerListDto.builder()
                    .longtitude(sewer.getLon())
                    .latitude(sewer.getLat())
                    .state(sewer.getStates())
                    .build();
            responseActiveSewerListDtos.add(responseActiveSewerListDto);
        }
        for(Sewer sewer : redSewers){
            ResponseActiveSewerListDto responseActiveSewerListDto = ResponseActiveSewerListDto.builder()
                    .longtitude(sewer.getLon())
                    .latitude(sewer.getLat())
                    .state(sewer.getStates())
                    .build();
            responseActiveSewerListDtos.add(responseActiveSewerListDto);
        }

        return responseActiveSewerListDtos;

    }



}
