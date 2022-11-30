package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.SewerRequestDTO.RequestCreateSewerDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.*;
import com.example.ipd_team_klean.Error.CustomException;
import com.example.ipd_team_klean.Error.ErrorCode;
import com.example.ipd_team_klean.Service.SewerService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/active/sewer")
    public ResponseEntity<?>  ActiveSewerList(Authentication authentication){
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }

        ResponseActiveSewerListSize responseActiveSewerListDtos  = sewerService.getStateActiveSewer();

        return  ResponseEntity.ok().body(responseActiveSewerListDtos);

    }



    @GetMapping("/active/sewer/info/{id}")
    public  ResponseEntity<?> BlockSewerInfo(Authentication authentication, @PathVariable(value = "id") int id) throws Throwable {
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }


        ResponseSewerInfo sewer = sewerService.findSewer(id);


        return ResponseEntity.ok().body(sewer);
    }

    @GetMapping("/active/sewer/list")
    public ResponseEntity<?> GetSewerScroll(Pageable pageable , Authentication authentication){
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }

        Slice<ResponseActiveSewerListDto> responseActiveSewerListDtos = sewerService.getSewerScroll(pageable);

        return ResponseEntity.ok().body(responseActiveSewerListDtos);
    }










}
