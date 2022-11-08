package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.RequestCreateSewerDto;
import com.example.ipd_team_klean.DTO.RequestDTO.RequestUpdateSewerDto;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Repository.SewerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SewerService {
    private final SewerRepository sewerRepository;
    private  final  LocationService locationService;


    public Sewer CreateSewer(RequestCreateSewerDto requestCreateSewerDto) throws Exception {
        if(sewerRepository.existsByLatAndLon(requestCreateSewerDto.getLatitude(),requestCreateSewerDto.getLongitude())== true){
            throw  new Exception("해당 하수구가 이미 존재합니다.");
        }
        //System.out.println(requestCreateSewerDto.getLongitude());
        //System.out.println(requestCreateSewerDto.getLatitude());
        Map<String, Object> map = locationService.getLocation(requestCreateSewerDto.getLongitude(),requestCreateSewerDto.getLatitude()).documents[0].address; // y 위도 latitude, x 경도 longitude

       // System.out.println(map);
        Collection<Object> values = map.values();
//        System.out.println(values);
        String Address_name = (String) map.get("address_name");
        String Region_name = (String) map.get("region_1depth_name");
//        System.out.println(Address_name);
//        System.out.println(Region_name);
        Sewer sewer = Sewer.builder()
                .longitude(requestCreateSewerDto.getLongitude())
                .latitude(requestCreateSewerDto.getLatitude())
                .state(requestCreateSewerDto.getState())
                .blockCount(0)
                .jan(0)
                .feb(0)
                .mar(0)
                .apr(0)
                .may(0)
                .jun(0)
                .july(0)
                .aug(0)
                .sep(0)
                .oct(0)
                .nov(0)
                .dec(0)
                .region_name(Region_name)
                .address_name(Address_name)
                .build();

        return sewerRepository.save(sewer);
    }

    public Sewer UpdateSewer(RequestUpdateSewerDto requestUpdateSewerDto) throws Exception {
        // 위도 경도 하수구 찾기
        Sewer findsewer = sewerRepository.findByLatAndLon(requestUpdateSewerDto.getLatitude(),requestUpdateSewerDto.getLongitude());
        // 초록 -> 빨간 일시
        if(findsewer.getStates().equals("green")){ // 현상태가 초록
            if(requestUpdateSewerDto.getState().equals("orange") || requestUpdateSewerDto.getState().equals("red")){ // 입력 상태가 주황색일시
                findsewer.setStates(requestUpdateSewerDto.getState()); // 초록 -> 주황
                findsewer.setBlockCount(findsewer.getBlockCount()+1); // 막힌 상태는 현 상태 +1
                // 월 구하기
                LocalDate nowmonth = LocalDate.now();
                if (nowmonth.getMonthValue()==1){
                    findsewer.setJan_Count(findsewer.getJuly_Count()+1);
                }else if (nowmonth.getMonthValue()==2){
                    findsewer.setFeb_Count(findsewer.getFeb_Count()+1);
                } else if (nowmonth.getMonthValue()==3) {
                    findsewer.setMar_Count(findsewer.getMar_Count()+1);
               }else if (nowmonth.getMonthValue()==4) {
                    findsewer.setApr_Count(findsewer.getApr_Count()+1);
                }else if (nowmonth.getMonthValue()==5) {
                    findsewer.setMay_Count(findsewer.getMay_Count()+1);
                }else if (nowmonth.getMonthValue()==6) {
                    findsewer.setJun_Count(findsewer.getJun_Count()+1);
                }else if (nowmonth.getMonthValue()==7) {
                    findsewer.setJuly_Count(findsewer.getJun_Count()+1);
                }else if (nowmonth.getMonthValue()==8) {
                    findsewer.setAug_Count(findsewer.getAug_Count()+1);
                }else if (nowmonth.getMonthValue()==9) {
                    findsewer.setSep_Count(findsewer.getSep_Count()+1);
                }else if (nowmonth.getMonthValue()==10) {
                    findsewer.setOct_Count(findsewer.getOct_Count()+1);

                }else if (nowmonth.getMonthValue()==11) {
                    findsewer.setNov_Count(findsewer.getNov_Count()+1);
                }else if (nowmonth.getMonthValue()==12) {
                    findsewer.setDec_Count(findsewer.getDec_Count()+1);
                }

                findsewer.setBlockDate(LocalDate.now()); // 막힌 날짜
                findsewer.setBlockTime(LocalTime.now()); // 막힌 시간

            }
        } else if (findsewer.getStates().equals("orange")  ) {
            // 주-> 초록
            if(requestUpdateSewerDto.getState().equals("green")){
                findsewer.setStates(requestUpdateSewerDto.getState());

            }

            if(requestUpdateSewerDto.getState().equals("red")){
                findsewer.setStates(requestUpdateSewerDto.getState());
            }


        } else if (findsewer.getStates().equals("red")) { // 주->빨
            if(requestUpdateSewerDto.getState().equals("green")){
                findsewer.setStates(requestUpdateSewerDto.getState());

            }

        } else{
            throw new Exception("값이 아님");
        }

        return sewerRepository.save(findsewer);
    }
    //오랜지 하수구 전체 리스트 얻기
    public List<Sewer> ListActiveStateOrage(String state){
        return sewerRepository.getStateActiveSewerOrange(state);
    }
    // 빨간하수구 전체 리스트 얻기
    public List<Sewer> ListActiveStateRed(String state){
        return sewerRepository.getStateActiveSewerRed(state);
    }
    public Sewer findSewer( double lat, double lon){
        return sewerRepository.findByLatAndLon(lat, lon);
    }

    public int getJanBlockSewer( ){
        // 1월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockJanSewer();
        int totalJan = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalJan = totalJan + sewer.getJan_Count();
        }
        return  totalJan;
    }
    public int getFebBlockSewer( ){
        // 2월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockFebSewer();
        int totalFeb = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalFeb = totalFeb + sewer.getFeb_Count();
        }
        return  totalFeb;
    }
    public int getMarBlockSewer( ){
        // 3월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockMarSewer();
        int totalMar = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalMar = totalMar + sewer.getMar_Count();
        }
        return  totalMar;
    }
    public int getAprBlockSewer( ){
        // 4월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockAprSewer();
        int totalApr = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalApr = totalApr + sewer.getApr_Count();
        }
        return  totalApr;
    }
    public int getMayBlockSewer( ){
        // 5월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockMaySewer();
        int totalMay = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalMay = totalMay + sewer.getMay_Count();
        }
        return  totalMay;
    }
    public int getJunBlockSewer( ){
        // 6월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockJunSewer();
        int totalJun = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalJun = totalJun + sewer.getJun_Count();
        }
        return  totalJun;
    }
    public int getJulyBlockSewer( ){
        // 7월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockJulySewer();
        int totalJuly = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalJuly = totalJuly + sewer.getJuly_Count();
        }
        return  totalJuly;
    }
    public int getAugBlockSewer( ){
        // 8월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockAugSewer();
        int totalAug = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalAug = totalAug + sewer.getAug_Count();
        }
        return  totalAug;
    }
    public int getSepBlockSewer( ){
        // 9월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockSepSewer();
        int totalSep = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalSep = totalSep + sewer.getSep_Count();
        }
        return  totalSep;
    }
    public int getOctBlockSewer( ){
        // 10월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockOctSewer();
        int totalOct = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalOct = totalOct + sewer.getAug_Count();
        }
        return  totalOct;
    }
    public int getNovBlockSewer( ){
        // 11월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockNovSewer();
        int totalNov = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalNov = totalNov + sewer.getNov_Count();
        }
        return  totalNov;
    }
    public int getDecBlockSewer( ){
        // 12월이 0이아닌 하수구를 구해서
        List<Sewer> sewers = sewerRepository.getBlockDecSewer();
        int totalDec = 0;
        for(Sewer sewer : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalDec = totalDec + sewer.getDec_Count();
        }
        return  totalDec;
    }

}
