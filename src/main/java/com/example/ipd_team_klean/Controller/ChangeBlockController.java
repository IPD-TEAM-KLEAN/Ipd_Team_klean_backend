package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.ChnageBlockDTO.ChangeBlockRequestDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChageBlockResponseDTO.ChangeBlockListResponseDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChageBlockResponseDTO.ChangeBlockReponseDto;
import com.example.ipd_team_klean.Service.ChangeBlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChangeBlockController {

    private  final ChangeBlockService changeBlockService;


    @PostMapping("/change/block")
    public ResponseEntity<?> ChangeBlock(@RequestBody ChangeBlockRequestDto changeBlockRequestDto){
        //현재 dto 로 changeblock 만들어 주고
        // 위도 경도로 해당 하수구를 찾기
        // 해당 하수구 state 와 분기 숫자 change
        // save 해주고
        // create 주고
        ChangeBlockReponseDto changeBlockReponseDto = changeBlockService.changeBlock(changeBlockRequestDto);
        return  ResponseEntity.ok().body(changeBlockReponseDto);

    }

    @GetMapping("/change/block/list")
    public ResponseEntity<?> ChangeBlockList(){

        List<ChangeBlockListResponseDto> changeBlockListResponseDtoList = changeBlockService.changeBlockList();
        return ResponseEntity.ok().body(changeBlockListResponseDtoList);

    }
}
