package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.BlockRequestDTO.RequestUpdateSewerBlockDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseBlockInfoDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseLookUpBlockDto;
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
    public ResponseEntity<?> Block1Sewer(Authentication authentication){
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        // 1월 하수구 찾기
        int BlockCount = blockService.getJanBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }

    @GetMapping("block/2/sewer")
    public ResponseEntity<?> Block2Sewer(Authentication authentication){
        // 2월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getFebBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/3/sewer")
    public ResponseEntity<?> Block3Sewer(Authentication authentication){
        // 3월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getMarBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/4/sewer")
    public ResponseEntity<?> Block4Sewer(Authentication authentication){
        // 4월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getAprBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/5/sewer")
    public ResponseEntity<?> Block5Sewer(Authentication authentication){
        // 5월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getMayBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/6/sewer")
    public ResponseEntity<?> Block6Sewer(Authentication authentication){
        // 6월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getJunBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/7/sewer")
    public ResponseEntity<?> Block7Sewer(Authentication authentication){
        // 7월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getJulyBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/8/sewer")
    public ResponseEntity<?> Block8Sewer(Authentication authentication){
        // 8월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getAugBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/9/sewer")
    public ResponseEntity<?> Block9Sewer(Authentication authentication){
        // 9월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getSepBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/10/sewer")
    public ResponseEntity<?> Block10Sewer(Authentication authentication){
        // 10월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getOctBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/11/sewer")
    public ResponseEntity<?> Block11Sewer(Authentication authentication){
        // 11월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getNovBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }
    @GetMapping("block/12/sewer")
    public ResponseEntity<?> Block12Sewer(Authentication authentication){
        // 12월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = blockService.getDecBlockSewer();
        ResponseBlockMounthSewerDto responseBlockMounthSewerDto = ResponseBlockMounthSewerDto.builder()
                .blockCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseBlockMounthSewerDto);

    }

    // 일정 시간 마다 요청이 오면 상태값 반환
    @GetMapping("/lookup/block/{lat}/{lon}")
    public ResponseEntity<?> LookUpBlock(@PathVariable(value = "lat") double lat, @PathVariable(value = "lon")double lon){
        ResponseLookUpBlockDto responseLookUpBlockDto = blockService.LookUpBlock(lat,lon);
        return ResponseEntity.ok().body(responseLookUpBlockDto);
    }




    ///////////////////////////////////////////////////////////////////////

}
