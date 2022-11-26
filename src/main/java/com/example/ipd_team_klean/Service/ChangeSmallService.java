package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.ChnagSmallDTO.ChangeSmallRequestDto;
import com.example.ipd_team_klean.DTO.RequestDTO.ChnageBlockDTO.ChangeBlockRequestDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChageBlockResponseDTO.ChangeBlockReponseDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeSmallResponeDTO.ChangeSmallResponseDto;
import com.example.ipd_team_klean.Entity.ChangeBlock;
import com.example.ipd_team_klean.Entity.ChangeSmall;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import com.example.ipd_team_klean.Repository.Small_SensorRepository.ChangeSmallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class ChangeSmallService {
    private  final ChangeSmallRepository changeSmallRepository;
    private  final SewerRepository sewerRepository;
    public ChangeSmallResponseDto changeSmall(ChangeSmallRequestDto changeSmallRequestDto){

        //현재 dto 로 changsmall 만들어 주고
        // 위도 경도로 해당 하수구를 찾기
        // 해당 하수구 state 와 분기 숫자 change
        // save 해주고
        // create 주고


        Sewer findsewer = sewerRepository.findByLatAndLon(changeSmallRequestDto.getLatitude(), changeSmallRequestDto.getLongitude());


        if(findsewer.getSmall_sensor().getStates().equals("Disable")){
            if(changeSmallRequestDto.getState().equals("Active")){
                findsewer.setState("Active");
                findsewer.getSmall_sensor().setStates(changeSmallRequestDto.getState());
                findsewer.getSmall_sensor().setSmallCount(findsewer.getSmall_sensor().getSmallCount()+1);
                LocalDate nowmonth = LocalDate.now();
                if (nowmonth.getMonthValue()==1){
                    findsewer.getSmall_sensor().setJan_Count(findsewer.getSmall_sensor().getJuly_Count()+1);
                }else if (nowmonth.getMonthValue()==2){
                    findsewer.getSmall_sensor().setFeb_Count(findsewer.getSmall_sensor().getFeb_Count()+1);
                } else if (nowmonth.getMonthValue()==3) {
                    findsewer.getSmall_sensor().setMar_Count(findsewer.getSmall_sensor().getMar_Count()+1);
                }else if (nowmonth.getMonthValue()==4) {
                    findsewer.getSmall_sensor().setApr_Count(findsewer.getSmall_sensor().getApr_Count()+1);
                }else if (nowmonth.getMonthValue()==5) {
                    findsewer.getSmall_sensor().setMay_Count(findsewer.getSmall_sensor().getMay_Count()+1);
                }else if (nowmonth.getMonthValue()==6) {
                    findsewer.getSmall_sensor().setJun_Count(findsewer.getSmall_sensor().getJun_Count()+1);
                }else if (nowmonth.getMonthValue()==7) {
                    findsewer.getSmall_sensor().setJuly_Count(findsewer.getSmall_sensor().getJun_Count()+1);
                }else if (nowmonth.getMonthValue()==8) {
                    findsewer.getSmall_sensor().setAug_Count(findsewer.getSmall_sensor().getAug_Count()+1);
                }else if (nowmonth.getMonthValue()==9) {
                    findsewer.getSmall_sensor().setSep_Count(findsewer.getSmall_sensor().getSep_Count()+1);
                }else if (nowmonth.getMonthValue()==10) {
                    findsewer.getSmall_sensor().setOct_Count(findsewer.getSmall_sensor().getOct_Count()+1);

                }else if (nowmonth.getMonthValue()==11) {
                    findsewer.getSmall_sensor().setNov_Count(findsewer.getSmall_sensor().getNov_Count()+1);
                }else if (nowmonth.getMonthValue()==12) {
                    findsewer.getSmall_sensor().setDec_Count(findsewer.getSmall_sensor().getDec_Count()+1);
                }

                findsewer.getSmall_sensor().setSmallDate(LocalDate.now()); // 막힌 날짜
                findsewer.getSmall_sensor().setSmallTime(LocalTime.now()); // 막힌 시간
            }
        }

        if(findsewer.getSmall_sensor().getStates().equals("Active")){
            if(changeSmallRequestDto.getState().equals("Disable")){
                findsewer.getSmall_sensor().setStates("Disable");
                if(findsewer.getBlock().getStates().equals("Disable")){
                    findsewer.setState("Disable");
                }
            }
        }
        sewerRepository.save(findsewer);

        ChangeSmall changeSmall = ChangeSmall.builder()
                .value(changeSmallRequestDto.getValue())
                .crateDate(LocalDateTime.now())
                .small_sensor(findsewer.getSmall_sensor())
                .build();
        changeSmallRepository.save(changeSmall); // 변화된 냄새 저장
        ChangeSmallResponseDto changeSmallResponseDto = ChangeSmallResponseDto.builder().value(changeSmall.getValue()).build();

        return  changeSmallResponseDto;






    }
}
