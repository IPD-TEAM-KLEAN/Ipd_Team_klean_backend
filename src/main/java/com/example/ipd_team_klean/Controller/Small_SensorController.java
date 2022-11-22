package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.SmallSensorRequestDTO.RequestUpdateSewerSmallDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseBlockMounthSewerDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseLookUpBlockDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseQuarterBlockDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SmallSensorResponeDTO.*;
import com.example.ipd_team_klean.Error.CustomException;
import com.example.ipd_team_klean.Error.ErrorCode;
import com.example.ipd_team_klean.Service.Small_SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Small_SensorController {
    final Small_SensorService small_sensorService;

    @PutMapping("/update/small")
    public ResponseEntity<?> UpdateSmall(@RequestBody RequestUpdateSewerSmallDto requestUpdateSewerSmallDto){

        ResponseUpdateSmallSewerDto responseUpdateSmallSewerDto = small_sensorService.UpdateSewer(requestUpdateSewerSmallDto);
        return  ResponseEntity.ok().body(responseUpdateSmallSewerDto);
    }

    @GetMapping("/info/small/{id}") // id 는 하수구 아이디
    public  ResponseEntity<?> SmallInco(@PathVariable(value = "id")int id, Authentication authentication) throws Throwable {
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        ResponseSmallInfoDto responseSmallInfoDto = small_sensorService.SmallInfo(id);

        return  ResponseEntity.ok().body(responseSmallInfoDto);
    }

    @GetMapping("/active/smallstate/list/sewer")
    public ResponseEntity<?> ActiveStateSewer(Authentication authentication){
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        List<ResponseActiveSmallSewerListDto> responseActiveSmallSewerListDtos = small_sensorService.ListActiveSmallBlock();
        return ResponseEntity.ok().body(responseActiveSmallSewerListDtos);
    }



    // 월별 막힌 횟수 받기
    @GetMapping("small/1/sewer")
    public ResponseEntity<?> Block1Sewer(Authentication authentication){
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        // 1월 하수구 찾기
        int BlockCount = small_sensorService.getJanSmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount)
                .build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }

    @GetMapping("small/2/sewer")
    public ResponseEntity<?> Block2Sewer(Authentication authentication){
        // 2월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getFebSmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }
    @GetMapping("small/3/sewer")
    public ResponseEntity<?> Block3Sewer(Authentication authentication){
        // 3월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getMarSmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }
    @GetMapping("small/4/sewer")
    public ResponseEntity<?> Block4Sewer(Authentication authentication){
        // 4월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getAprSmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }
    @GetMapping("small/5/sewer")
    public ResponseEntity<?> Block5Sewer(Authentication authentication){
        // 5월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getMaySmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }
    @GetMapping("small/6/sewer")
    public ResponseEntity<?> Block6Sewer(Authentication authentication){
        // 6월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getJunSmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }
    @GetMapping("small/7/sewer")
    public ResponseEntity<?> Block7Sewer(Authentication authentication){
        // 7월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getJulySmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }
    @GetMapping("small/8/sewer")
    public ResponseEntity<?> Block8Sewer(Authentication authentication){
        // 8월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getAugSmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }
    @GetMapping("small/9/sewer")
    public ResponseEntity<?> Block9Sewer(Authentication authentication){
        // 9월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getSepSmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }
    @GetMapping("small/10/sewer")
    public ResponseEntity<?> Block10Sewer(Authentication authentication){
        // 10월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getOctSmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }
    @GetMapping("small/11/sewer")
    public ResponseEntity<?> Block11Sewer(Authentication authentication){
        // 11월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getNovSmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }


    @GetMapping("small/12/sewer")
    public ResponseEntity<?> Block12Sewer(Authentication authentication){
        // 12월 하수구 찾기
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }
        int BlockCount = small_sensorService.getDecSmallSewer();
        ResponseSmallMounthSewerDto responseSmallMounthSewerDto = ResponseSmallMounthSewerDto.builder()
                .smallCount(BlockCount).build();
        return  ResponseEntity.ok().body(responseSmallMounthSewerDto);

    }


    // 일정 시간 마다 요청 오면 상태값 체크

    @GetMapping("/lookup/small/{lat}/{lon}")
    public ResponseEntity<?> LookUpBlock(@PathVariable(value = "lat") double lat, @PathVariable(value = "lon")double lon){
        ResponseLookUpSmallDto responseLookUpSmallDto = small_sensorService.LookUpSamll(lat,lon);
        return ResponseEntity.ok().body(responseLookUpSmallDto);
    }


    @GetMapping("/quarter/small/sewer")
    public ResponseEntity<?> QuarterBlock(Authentication authentication){
        if(authentication == null){
            throw  new CustomException("허용되지 않은 접근입니다." , ErrorCode.UnauthorizedException);
        }

        ResponeQuarterSmallDto responeQuarterSmallDto = small_sensorService.QurterBlock();
        return ResponseEntity.ok().body(responeQuarterSmallDto);

    }





}
