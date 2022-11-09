package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.BlockRequestDTO.RequestUpdateSewerBlockDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseUpdateBlockSewerDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseActiveSewerListDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseBlockListCountSewerDTO;
import com.example.ipd_team_klean.DTO.ResponseDTO.SewerResponseDTO.ResponseBlockMounthSewerDto;
import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Service.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BlockController {

    private  final BlockService blockService;

    // 위도 경도 상태를 받아서
    @PutMapping("/update/sewer")
    public ResponseEntity<?> UpdateSewer(@RequestBody RequestUpdateSewerBlockDto requestUpdateSewerDto) throws Exception {
        ResponseUpdateBlockSewerDto blcoksewer = blockService.UpdateSewer(requestUpdateSewerDto);

        return ResponseEntity.ok().body(blcoksewer);


    }


    @GetMapping("/active/state/list/sewer")
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



    // 메소드 하수구 전체 리스크 보기 및 하수구 전체 리스트 개수 확인시 사용
    public List<ResponseActiveSewerListDto> findActiveSewer(){
        List<Block> orangeSewers = blockService.ListActiveStateOrage("orange");// 분홍일시 하수구 얻기
        List<Block> redSewers = blockService.ListActiveStateRed("red");// 빨강 하수구 얻기



        List<ResponseActiveSewerListDto> responseActiveSewerListDtos = new ArrayList<>();

//        for(Sewer sewer :redSewers){
//            ResponseActiveSewerListDto responseActiveSewerListDto = ResponseActiveSewerListDto.builder()
//                    .latitude(sewer.getLat())
//                    .longtitude(sewer.getLon())
//                    .build();
//            responseActiveSewerListDtos.add(responseActiveSewerListDto);
//
//        }
        for(Block block : orangeSewers){
            ResponseActiveSewerListDto responseActiveSewerListDto = ResponseActiveSewerListDto.builder()
                    .longtitude(block.getSewer().getLon())
                    .latitude(block.getSewer().getLat())
                    .state(block.getStates())
                    .address_name(block.getSewer().getAddress_name())
                    .region_name(block.getSewer().getRegion_name())
                    .build();
            responseActiveSewerListDtos.add(responseActiveSewerListDto);
        }
        for(Block block : redSewers){
            ResponseActiveSewerListDto responseActiveSewerListDto = ResponseActiveSewerListDto.builder()
                    .longtitude(block.getSewer().getLon())
                    .latitude(block.getSewer().getLat())
                    .state(block.getStates())
                    .address_name(block.getSewer().getAddress_name())
                    .region_name(block.getSewer().getRegion_name())
                    .build();
            responseActiveSewerListDtos.add(responseActiveSewerListDto);
        }

        return responseActiveSewerListDtos;

    }
}
