package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.ChnageBlockDTO.ChangeBlockRequestDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChageBlockResponseDTO.ChangeBlockListResponseDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChageBlockResponseDTO.ChangeBlockReponseDto;
import com.example.ipd_team_klean.Entity.ChangeBlock;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Error.CustomException;
import com.example.ipd_team_klean.Error.ErrorCode;
import com.example.ipd_team_klean.Repository.BlockRepository.ChangeBlockRepository;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChangeBlockService {
    private  final ChangeBlockRepository changeBlockRepository;
    private  final SewerRepository sewerRepository;

    public ChangeBlockReponseDto changeBlock(ChangeBlockRequestDto changeBlockRequestDto){
        //현재 dto 로 changeblock 만들어 주고
        // 위도 경도로 해당 하수구를 찾기
        // 해당 하수구 state 와 분기 숫자 change
        // save 해주고
        // create 주고
        System.out.println(changeBlockRequestDto.getState());
        System.out.println(changeBlockRequestDto.getLongitude()); // 일단 여건 맞음


        if(changeBlockRequestDto.getState().equals("Active")){
            System.out.println("123123");
        }


        Sewer findsewer = sewerRepository.findByLatAndLon(changeBlockRequestDto.getLatitude(), changeBlockRequestDto.getLongitude());
        if(findsewer == null){
            new CustomException("", ErrorCode.NotFoundUserException);
        }
        System.out.println(changeBlockRequestDto.getValue());
        findsewer.getBlock().setValue(changeBlockRequestDto.getValue());
        if(findsewer.getBlock().getStates().equals("Disable")){ // 전값이 disable이고 현재 오는 값이 active일시
            System.out.println("yes");
            if(changeBlockRequestDto.getState().equals("Active")){
                findsewer.setState("Active");
                findsewer.getBlock().setStates(changeBlockRequestDto.getState()); // 초록 -> 주황
                findsewer.getBlock().setBlockCount(findsewer.getBlock().getBlockCount()+1); // 막힌 상태는 현 상태 +1
                LocalDate nowmonth = LocalDate.now();
                if (nowmonth.getMonthValue()==1){
                    findsewer.getBlock().setJan_Count(findsewer.getBlock().getJuly_Count()+1);
                }else if (nowmonth.getMonthValue()==2){
                    findsewer.getBlock().setFeb_Count(findsewer.getBlock().getFeb_Count()+1);
                } else if (nowmonth.getMonthValue()==3) {
                    findsewer.getBlock().setMar_Count(findsewer.getBlock().getMar_Count()+1);
                }else if (nowmonth.getMonthValue()==4) {
                    findsewer.getBlock().setApr_Count(findsewer.getBlock().getApr_Count()+1);
                }else if (nowmonth.getMonthValue()==5) {
                    findsewer.getBlock().setMay_Count(findsewer.getBlock().getMay_Count()+1);
                }else if (nowmonth.getMonthValue()==6) {
                    findsewer.getBlock().setJun_Count(findsewer.getBlock().getJun_Count()+1);
                }else if (nowmonth.getMonthValue()==7) {
                    findsewer.getBlock().setJuly_Count(findsewer.getBlock().getJun_Count()+1);
                }else if (nowmonth.getMonthValue()==8) {
                    findsewer.getBlock().setAug_Count(findsewer.getBlock().getAug_Count()+1);
                }else if (nowmonth.getMonthValue()==9) {
                    findsewer.getBlock().setSep_Count(findsewer.getBlock().getSep_Count()+1);
                }else if (nowmonth.getMonthValue()==10) {
                    findsewer.getBlock().setOct_Count(findsewer.getBlock().getOct_Count()+1);

                }else if (nowmonth.getMonthValue()==11) {
                    findsewer.getBlock().setNov_Count(findsewer.getBlock().getNov_Count()+1);
                }else if (nowmonth.getMonthValue()==12) {
                    findsewer.getBlock().setDec_Count(findsewer.getBlock().getDec_Count()+1);
                }

                findsewer.getBlock().setBlockDate(LocalDate.now()); // 막힌 날짜
                findsewer.getBlock().setBlockTime(LocalTime.now()); // 막힌 시간
            }
        }

        if(findsewer.getBlock().getStates().equals( "Active")){
            if(changeBlockRequestDto.getState().equals("Disable")){
                findsewer.getBlock().setStates("Disable"); // 블록 센서 disable 처리하기
                if(findsewer.getSmall_sensor().getStates().equals("Disable")){
                    findsewer.setState("Disable");
                }

            }
        }

        sewerRepository.save(findsewer);
        ChangeBlock changeBlock = ChangeBlock.builder()
                .value(changeBlockRequestDto.getValue())
                .crateDate(LocalDateTime.now())
                .block(findsewer.getBlock())
                .build();
        changeBlockRepository.save(changeBlock); // 변화된 블록 저장

        ChangeBlockReponseDto changeBlockReponseDto = ChangeBlockReponseDto.builder().value(changeBlock.getValue()).build();
        return changeBlockReponseDto;
    }

    public List<ChangeBlockListResponseDto> changeBlockList(){
        List<ChangeBlock> changeBlocklist = changeBlockRepository.findAll();
        List<ChangeBlockListResponseDto> changeBlockReponseDtoList = new ArrayList<>();
        for(ChangeBlock changeBlock : changeBlocklist){
            ChangeBlockListResponseDto changeBlockReponseDto = ChangeBlockListResponseDto
                    .builder()
                    .id(changeBlock.getId())
                    .localDateTime(changeBlock.getCrateDate())
                    .value(changeBlock.getValue())
                    .address_name(changeBlock.getBlock().getSewer().getAddress_name())
                    .latitude(changeBlock.getBlock().getSewer().getLat())
                    .longitude(changeBlock.getBlock().getSewer().getLon())
                    .sewerId(changeBlock.getBlock().getSewer().getId())
                    .build();

            changeBlockReponseDtoList.add(changeBlockReponseDto);
        }
        return changeBlockReponseDtoList;
    }

}