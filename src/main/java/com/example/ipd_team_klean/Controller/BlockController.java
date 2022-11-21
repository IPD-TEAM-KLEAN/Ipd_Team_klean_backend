package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.BlockRequestDTO.RequestUpdateSewerBlockDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseBlockInfoDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseUpdateBlockSewerDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseActiveSewerListDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseBlockListCountSewerDTO;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseBlockMounthSewerDto;
import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Error.CustomException;
import com.example.ipd_team_klean.Error.ErrorCode;
import com.example.ipd_team_klean.Service.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BlockController {

    private  final BlockService blockService;

    // 위도 경도 상태를 받아서
    @PutMapping("/update/block")
    public ResponseEntity<?> UpdateSewer(@RequestBody RequestUpdateSewerBlockDto requestUpdateSewerDto) throws Throwable {
        ResponseUpdateBlockSewerDto blcoksewer = blockService.UpdateSewer(requestUpdateSewerDto);

        return ResponseEntity.ok().body(blcoksewer);


    }

    @GetMapping("/info/block/{id}")
    public ResponseEntity<?> BlockInfo(@PathVariable(value = "id")int id, Authentication authentication) throws Throwable {

        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        ResponseBlockInfoDto responseBlockInfoDto = blockService.BlockInfo(id);

        return ResponseEntity.ok().body(responseBlockInfoDto);

    }


    @GetMapping("/active/state/list/sewer")
    public ResponseEntity<?> ActiveStateSewer(Authentication authentication){

        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }

        List<ResponseActiveSewerListDto> responseActiveSewerListDtos = blockService.ListActiveBlock();
        return ResponseEntity.ok().body(responseActiveSewerListDtos);


    }




    // 월별 막힌 횟수 받기
    @GetMapping("block/1/sewer")
    public ResponseEntity<?> Block1Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getJanBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }

    @GetMapping("block/2/sewer")
    public ResponseEntity<?> Block2Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getFebBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/3/sewer")
    public ResponseEntity<?> Block3Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getMarBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/4/sewer")
    public ResponseEntity<?> Block4Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getAprBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/5/sewer")
    public ResponseEntity<?> Block5Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getMayBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/6/sewer")
    public ResponseEntity<?> Block6Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getJunBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/7/sewer")
    public ResponseEntity<?> Block7Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getJulyBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/8/sewer")
    public ResponseEntity<?> Block8Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getAugBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/9/sewer")
    public ResponseEntity<?> Block9Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getSepBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/10/sewer")
    public ResponseEntity<?> Block10Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getOctBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/11/sewer")
    public ResponseEntity<?> Block11Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getNovBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/12/sewer")
    public ResponseEntity<?> Block12Sewer(){
        // 1월 하수구 찾기
        int BlockCount = blockService.getDecBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }


    ///////////////////////////////////////////////////////////////////////

}
