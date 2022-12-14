package com.example.ipd_team_klean.Controller;


import com.example.ipd_team_klean.DTO.RequestDTO.ChnagSmallDTO.ChangeSmallRequestDto;
import com.example.ipd_team_klean.DTO.RequestDTO.ChnageBlockDTO.ChangeBlockRequestDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeSmallResponeDTO.ChangeSmallResponseDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeSmallResponeDTO.ChangeSmellListResponseDto;
import com.example.ipd_team_klean.Service.ChangeSmallService;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChangeSmallController {
    private  final ChangeSmallService changeSmallService;

    @GetMapping("/")
    public String root(){
        System.out.println("root");
        return "root";
    }

    @PostMapping("/change/small")
    public ResponseEntity<?> ChangeBlock(@RequestBody ChangeSmallRequestDto changeSmallRequestDto){
        //현재 dto 로 changeblock 만들어 주고
        // 위도 경도로 해당 하수구를 찾기
        // 해당 하수구 state 와 분기 숫자 change
        // save 해주고
        // create 주고

        ChangeSmallResponseDto changeSmallResponseDto = changeSmallService.changeSmall(changeSmallRequestDto);
        return  ResponseEntity.ok().body(changeSmallResponseDto);


    }
    @GetMapping("/change/smell/list")
    public ResponseEntity<?> ChangeSmellList(){
        List<ChangeSmellListResponseDto> changeSmellListResponseDtoList = changeSmallService.changeSmellListResponseDtoList();
        return ResponseEntity.ok().body(changeSmellListResponseDtoList);
    }

}
