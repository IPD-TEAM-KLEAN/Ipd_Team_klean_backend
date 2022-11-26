package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.SmallSensorRequestDTO.RequestUpdateSewerSmallDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseQuarterBlockDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.SmallSensorResponeDTO.*;
import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Entity.Small_Sensor;
import com.example.ipd_team_klean.Error.CustomException;
import com.example.ipd_team_klean.Error.ErrorCode;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import com.example.ipd_team_klean.Repository.Small_SensorRepository.Small_SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Small_SensorService {
    private  final Small_SensorRepository small_sensorRepository;
    private  final SewerRepository sewerRepository;


    // changesmall 에서

//    public ResponseUpdateSmallSewerDto UpdateSewer(RequestUpdateSewerSmallDto requestUpdateSewerSmallDto){
//
//        Sewer findsewer = sewerRepository.findByLatAndLon(requestUpdateSewerSmallDto.getLatitude(), requestUpdateSewerSmallDto.getLongitude());
//        if(findsewer.getSmall_sensor().getStates().equals("Disable")){
//            if(requestUpdateSewerSmallDto.getState().equals("Active")){
//                findsewer.setState("Active");
//                findsewer.getSmall_sensor().setStates(requestUpdateSewerSmallDto.getState());
//                findsewer.getSmall_sensor().setSmallCount(findsewer.getSmall_sensor().getSmallCount()+1);
//                LocalDate nowmonth = LocalDate.now();
//                if (nowmonth.getMonthValue()==1){
//                    findsewer.getSmall_sensor().setJan_Count(findsewer.getSmall_sensor().getJuly_Count()+1);
//                }else if (nowmonth.getMonthValue()==2){
//                    findsewer.getSmall_sensor().setFeb_Count(findsewer.getSmall_sensor().getFeb_Count()+1);
//                } else if (nowmonth.getMonthValue()==3) {
//                    findsewer.getSmall_sensor().setMar_Count(findsewer.getSmall_sensor().getMar_Count()+1);
//                }else if (nowmonth.getMonthValue()==4) {
//                    findsewer.getSmall_sensor().setApr_Count(findsewer.getSmall_sensor().getApr_Count()+1);
//                }else if (nowmonth.getMonthValue()==5) {
//                    findsewer.getSmall_sensor().setMay_Count(findsewer.getSmall_sensor().getMay_Count()+1);
//                }else if (nowmonth.getMonthValue()==6) {
//                    findsewer.getSmall_sensor().setJun_Count(findsewer.getSmall_sensor().getJun_Count()+1);
//                }else if (nowmonth.getMonthValue()==7) {
//                    findsewer.getSmall_sensor().setJuly_Count(findsewer.getSmall_sensor().getJun_Count()+1);
//                }else if (nowmonth.getMonthValue()==8) {
//                    findsewer.getSmall_sensor().setAug_Count(findsewer.getSmall_sensor().getAug_Count()+1);
//                }else if (nowmonth.getMonthValue()==9) {
//                    findsewer.getSmall_sensor().setSep_Count(findsewer.getSmall_sensor().getSep_Count()+1);
//                }else if (nowmonth.getMonthValue()==10) {
//                    findsewer.getSmall_sensor().setOct_Count(findsewer.getSmall_sensor().getOct_Count()+1);
//
//                }else if (nowmonth.getMonthValue()==11) {
//                    findsewer.getSmall_sensor().setNov_Count(findsewer.getSmall_sensor().getNov_Count()+1);
//                }else if (nowmonth.getMonthValue()==12) {
//                    findsewer.getSmall_sensor().setDec_Count(findsewer.getSmall_sensor().getDec_Count()+1);
//                }
//
//                findsewer.getSmall_sensor().setSmallDate(LocalDate.now()); // 막힌 날짜
//                findsewer.getSmall_sensor().setSmallTime(LocalTime.now()); // 막힌 시간
//                }
//            }
//
//        if(findsewer.getSmall_sensor().getStates().equals("Active")){
//            if(requestUpdateSewerSmallDto.getState().equals("Disable")){
//                findsewer.getSmall_sensor().setStates("Disable");
//                if(findsewer.getBlock().getStates().equals("Disable") && findsewer.getTh_sensor().getHStates().equals("Disable") && findsewer.getTh_sensor().getTStates().equals("Disable")){
//                    findsewer.setState("Disable");
//                }
//            }
//
//
//        }
//        sewerRepository.save(findsewer);
//
//        ResponseUpdateSmallSewerDto responseUpdateSmallSewerDto = ResponseUpdateSmallSewerDto.builder()
//                .state(findsewer.getSmall_sensor().getStates())
//                .smallCount(findsewer.getSmall_sensor().getSmallCount())
//                .jan(findsewer.getSmall_sensor().getJan_Count())
//                .feb(findsewer.getSmall_sensor().getFeb_Count())
//                .apr(findsewer.getSmall_sensor().getApr_Count())
//                .may(findsewer.getSmall_sensor().getMay_Count())
//                .jun(findsewer.getSmall_sensor().getJun_Count())
//                .july(findsewer.getSmall_sensor().getJuly_Count())
//                .aug(findsewer.getSmall_sensor().getAug_Count())
//                .sep(findsewer.getSmall_sensor().getSep_Count())
//                .oct(findsewer.getSmall_sensor().getOct_Count())
//                .nov(findsewer.getSmall_sensor().getNov_Count())
//                .dec(findsewer.getSmall_sensor().getDec_Count())
//                .smallDate(findsewer.getSmall_sensor().getSmallDate())
//                .smallTime(findsewer.getSmall_sensor().getSmallTime())
//
//                .build();
//
//        return responseUpdateSmallSewerDto;
//
//    }

    public ResponseSmallInfoDto SmallInfo(int id) throws Throwable {
        Sewer findsewer = (Sewer) sewerRepository.findById(id).orElseThrow(()-> new CustomException("", ErrorCode.NotFoundUserException));

        ResponseSmallInfoDto responseSmallInfoDto = ResponseSmallInfoDto.builder()
                .state(findsewer.getSmall_sensor().getStates())
                .smallCount(findsewer.getSmall_sensor().getSmallCount())
                .jan(findsewer.getSmall_sensor().getJan_Count())
                .feb(findsewer.getSmall_sensor().getFeb_Count())
                .apr(findsewer.getSmall_sensor().getApr_Count())
                .may(findsewer.getSmall_sensor().getMay_Count())
                .jun(findsewer.getSmall_sensor().getJun_Count())
                .july(findsewer.getSmall_sensor().getJuly_Count())
                .aug(findsewer.getSmall_sensor().getAug_Count())
                .sep(findsewer.getSmall_sensor().getSep_Count())
                .oct(findsewer.getSmall_sensor().getOct_Count())
                .nov(findsewer.getSmall_sensor().getNov_Count())
                .dec(findsewer.getSmall_sensor().getDec_Count())
                .smallDate(findsewer.getSmall_sensor().getSmallDate())
                .smallTime(findsewer.getSmall_sensor().getSmallTime())


                .build();

        return responseSmallInfoDto;
    }

    public List<ResponseActiveSmallSewerListDto> ListActiveSmallBlock(){
        List<Small_Sensor> small_sensors = small_sensorRepository.getActiveSmall();

        List<ResponseActiveSmallSewerListDto> responseActiveSmallSewerListDtos = new ArrayList<>();
        for(Small_Sensor small_sensor : small_sensors){
            ResponseActiveSmallSewerListDto responseActiveSmallSewerListDto = ResponseActiveSmallSewerListDto.builder()
                    .id(small_sensor.getSewer().getId())
                    .longtitude(small_sensor.getSewer().getLon())
                    .latitude(small_sensor.getSewer().getLat())
                    .state(small_sensor.getStates())
                    .address_name(small_sensor.getSewer().getAddress_name())
                    .region_name(small_sensor.getSewer().getRegion_name())
                    .build();
            responseActiveSmallSewerListDtos.add(responseActiveSmallSewerListDto);
        }
        return responseActiveSmallSewerListDtos;
    }



    public int getJanSmallSewer( ){
        // 1월이 0이아닌 하수구를 구해서
        List<Small_Sensor> small_sensors = small_sensorRepository.getSmallJanSewer();
        int totalJan = 0;
        for(Small_Sensor small_sensor : small_sensors){
            //각 하수구가 막힌 횟수 막힌 합
            totalJan = totalJan + small_sensor.getJan_Count();
        }
        return  totalJan;
    }
    public int getFebSmallSewer( ){
        // 2월이 0이아닌 하수구를 구해서
        List<Small_Sensor> small_sensors = small_sensorRepository.getSmallFebSewer();
        int totalFeb = 0;
        for(Small_Sensor small_sensor : small_sensors){
            //각 하수구가 막힌 횟수 막힌 합
            totalFeb = totalFeb + small_sensor.getFeb_Count();
        }
        return  totalFeb;
    }
    public int getMarSmallSewer( ){
        // 3월이 0이아닌 하수구를 구해서
        List<Small_Sensor> sewers = small_sensorRepository.getSmallMarSewer();
        int totalMar = 0;
        for(Small_Sensor small_sensor : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalMar = totalMar + small_sensor.getMar_Count();
        }
        return  totalMar;
    }
    public int getAprSmallSewer( ){
        // 4월이 0이아닌 하수구를 구해서
        List<Small_Sensor> sewers = small_sensorRepository.getSmallAprSewer();
        int totalApr = 0;
        for(Small_Sensor small_sensor : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalApr = totalApr + small_sensor.getApr_Count();
        }
        return  totalApr;
    }
    public int getMaySmallSewer( ){
        // 5월이 0이아닌 하수구를 구해서
        List<Small_Sensor> sewers = small_sensorRepository.getSmallMaySewer();
        int totalMay = 0;
        for(Small_Sensor small_sensor : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalMay = totalMay + small_sensor.getMay_Count();
        }
        return  totalMay;
    }
    public int getJunSmallSewer( ){
        // 6월이 0이아닌 하수구를 구해서
        List<Small_Sensor> sewers = small_sensorRepository.getSmallJunSewer();
        int totalJun = 0;
        for(Small_Sensor small_sensor : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalJun = totalJun + small_sensor.getJun_Count();
        }
        return  totalJun;
    }
    public int getJulySmallSewer( ){
        // 7월이 0이아닌 하수구를 구해서
        List<Small_Sensor> sewers = small_sensorRepository.getSmallJulySewer();
        int totalJuly = 0;
        for(Small_Sensor small_sensor : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalJuly = totalJuly + small_sensor.getJuly_Count();
        }
        return  totalJuly;
    }
    public int getAugSmallSewer( ){
        // 8월이 0이아닌 하수구를 구해서
        List<Small_Sensor> sewers = small_sensorRepository.getSmallAugSewer();
        int totalAug = 0;
        for(Small_Sensor small_sensor : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalAug = totalAug + small_sensor.getAug_Count();
        }
        return  totalAug;
    }
    public int getSepSmallSewer( ){
        // 9월이 0이아닌 하수구를 구해서
        List<Small_Sensor> sewers = small_sensorRepository.getSmallSepSewer();
        int totalSep = 0;
        for(Small_Sensor small_sensor : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalSep = totalSep + small_sensor.getSep_Count();
        }
        return  totalSep;
    }
    public int getOctSmallSewer( ){
        // 10월이 0이아닌 하수구를 구해서
        List<Small_Sensor> sewers = small_sensorRepository.getSmallOctSewer();
        int totalOct = 0;
        for(Small_Sensor small_sensor : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalOct = totalOct + small_sensor.getAug_Count();
        }
        return  totalOct;
    }
    public int getNovSmallSewer( ){
        // 11월이 0이아닌 하수구를 구해서
        List<Small_Sensor> sewers = small_sensorRepository.getSmallNovSewer();
        int totalNov = 0;
        for(Small_Sensor small_sensor : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalNov = totalNov + small_sensor.getNov_Count();
        }
        return  totalNov;
    }
    public int getDecSmallSewer( ){
        // 12월이 0이아닌 하수구를 구해서
        List<Small_Sensor> sewers = small_sensorRepository.getSmallDecSewer();
        int totalDec = 0;
        for(Small_Sensor small_sensor : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalDec = totalDec + small_sensor.getDec_Count();
        }
        return  totalDec;
    }

    public ResponseLookUpSmallDto LookUpSamll(String lat, String lon){

        Sewer findSewer = sewerRepository.findByLatAndLon(lat, lon);
        ResponseLookUpSmallDto responseLookUpSmallDto = ResponseLookUpSmallDto.builder()
                .state(findSewer.getSmall_sensor().getStates())
                .build();

        return responseLookUpSmallDto;

    }

    public ResponeQuarterSmallDto QurterBlock(){

        List<Small_Sensor> findallSmalls = small_sensorRepository.findAll();

        int firstquarter = 0;
        int secondquarter =0;
        int thirdquarter =0;
        int fourthquarter =0;


        for(Small_Sensor small_sensor : findallSmalls){
            firstquarter +=  small_sensor.getJan_Count() + small_sensor.getFeb_Count()+ small_sensor.getMar_Count();
            secondquarter += small_sensor.getApr_Count() + small_sensor.getMay_Count() + small_sensor.getJun_Count() ;
            thirdquarter += small_sensor.getJuly_Count() + small_sensor.getAug_Count() + small_sensor.getSep_Count();
            fourthquarter += small_sensor.getOct_Count() + small_sensor.getNov_Count() +small_sensor.getDec_Count();

        }
        ResponeQuarterSmallDto responseQuarterSmallDto = ResponeQuarterSmallDto.builder()
                .firstquarter(firstquarter)
                .secondquarter(secondquarter)
                .thirdquarter(thirdquarter)
                .fourthquarter(fourthquarter)
                .build();
        return  responseQuarterSmallDto;




    }



}
