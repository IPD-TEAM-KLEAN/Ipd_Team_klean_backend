package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO.RequestBlockSewerInfo;
import com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO.RequestCreateSewerDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.*;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Service.SewerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SewerController {

    private final SewerService sewerService;

    // 하수구 생성 및 db 저장
    @PostMapping("/create/sewer")
    public ResponseEntity<?> CreateSewer(@RequestBody RequestCreateSewerDto requestCreateSewerDto) throws Exception {

        ResponseCreateSewerDto sewer = sewerService.CreateSewer(requestCreateSewerDto);

        return  ResponseEntity.ok().body(sewer);
    }


    // 하수구 상태 업데이트 (센서에서 들어 온 값 업데이트)

    // 막힌 하수구 전체 리스트 보기



    @GetMapping("block/sewer/info")
    public  ResponseEntity<?> BlockSewerInfo(@RequestBody RequestBlockSewerInfo requestBlockSewerInfo){
        Sewer sewer = sewerService.findSewer(requestBlockSewerInfo.getLatitude(),requestBlockSewerInfo.getLongitude());

        ResponseBlockSewerInfo responseBlockSewerInfo = ResponseBlockSewerInfo.builder()
                .latitude(sewer.getLat())
                .longtitude(sewer.getLon())
                .state(sewer.getBlock().getStates())
                .blockCount(sewer.getBlock().getBlockCount())
                .jan(sewer.getBlock().getJan_Count())
                .feb(sewer.getBlock().getFeb_Count())
                .mar(sewer.getBlock().getMar_Count())
                .apr(sewer.getBlock().getApr_Count())
                .may(sewer.getBlock().getMay_Count())
                .jun(sewer.getBlock().getJun_Count())
                .july(sewer.getBlock().getJuly_Count())
                .aug(sewer.getBlock().getAug_Count())
                .sep(sewer.getBlock().getSep_Count())
                .oct(sewer.getBlock().getOct_Count())
                .nov(sewer.getBlock().getNov_Count())
                .dec(sewer.getBlock().getDec_Count())
                .blockDate(sewer.getBlock().getBlockDate())
                .blockTime(sewer.getBlock().getBlockTime())
                .address_name(sewer.getAddress_name())
                .region_name(sewer.getRegion_name())
                .build();
        return ResponseEntity.ok().body(responseBlockSewerInfo);
    }










}
