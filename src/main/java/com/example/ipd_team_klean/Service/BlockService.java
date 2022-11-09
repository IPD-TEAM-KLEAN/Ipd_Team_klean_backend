package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.BlockRequestDTO.RequestUpdateSewerBlockDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.BlockResponseDTO.ResponseUpdateBlockSewerDto;
import com.example.ipd_team_klean.Entity.Block;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Repository.BlockRepository.BlockRepository;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlockService {
    private final BlockRepository blockRepository;
    private final SewerRepository sewerRepository;


    public ResponseUpdateBlockSewerDto UpdateSewer(RequestUpdateSewerBlockDto requestUpdateSewerDto) throws Exception {
        // 위도 경도 하수구 찾기
        Sewer findsewer = sewerRepository.findByLatAndLon(requestUpdateSewerDto.getLatitude(),requestUpdateSewerDto.getLongitude());

        // 초록 -> 빨간 일시
        if(findsewer.getBlock().getStates().equals("green")){ // 현상태가 초록
            if(requestUpdateSewerDto.getState().equals("orange") || requestUpdateSewerDto.getState().equals("red")){ // 입력 상태가 주황색일시
                findsewer.getBlock().setStates(requestUpdateSewerDto.getState()); // 초록 -> 주황
                findsewer.getBlock().setBlockCount(findsewer.getBlock().getBlockCount()+1); // 막힌 상태는 현 상태 +1
                // 월 구하기
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
        } else if (findsewer.getBlock().getStates().equals("orange")  ) {
            // 주-> 초록
            if(requestUpdateSewerDto.getState().equals("green")){
                findsewer.getBlock().setStates(requestUpdateSewerDto.getState());

            }

            if(requestUpdateSewerDto.getState().equals("red")){
                findsewer.getBlock().setStates(requestUpdateSewerDto.getState());
            }


        } else if (findsewer.getBlock().getStates().equals("red")) { // 주->빨
            if(requestUpdateSewerDto.getState().equals("green")){
                findsewer.getBlock().setStates(requestUpdateSewerDto.getState());

            }

        } else{
            throw new Exception("값이 아님");
        }
        sewerRepository.save(findsewer);

        ResponseUpdateBlockSewerDto responseUpdateSewerDto = ResponseUpdateBlockSewerDto.builder()
                .state(findsewer.getBlock().getStates())
                .blockCount(findsewer.getBlock().getBlockCount())
                .jan(findsewer.getBlock().getJan_Count())
                .feb(findsewer.getBlock().getFeb_Count())
                .apr(findsewer.getBlock().getApr_Count())
                .may(findsewer.getBlock().getMay_Count())
                .jun(findsewer.getBlock().getJun_Count())
                .july(findsewer.getBlock().getJuly_Count())
                .aug(findsewer.getBlock().getAug_Count())
                .sep(findsewer.getBlock().getSep_Count())
                .oct(findsewer.getBlock().getOct_Count())
                .nov(findsewer.getBlock().getNov_Count())
                .dec(findsewer.getBlock().getDec_Count())
                .blockDate(findsewer.getBlock().getBlockDate())
                .blockTime(findsewer.getBlock().getBlockTime())
                .build();

        return responseUpdateSewerDto;
    }


    public List<Block> ListActiveStateOrage(String state){
        return blockRepository.getStateActiveSewerOrange(state);
    }
    // 빨간하수구 전체 리스트 얻기
    public List<Block> ListActiveStateRed(String state){
        return blockRepository.getStateActiveSewerRed(state);
    }
    public int getJanBlockSewer( ){
        // 1월이 0이아닌 하수구를 구해서
        List<Block> blocks = blockRepository.getBlockJanSewer();
        int totalJan = 0;
        for(Block block : blocks){
            //각 하수구가 막힌 횟수 막힌 합
            totalJan = totalJan + block.getJan_Count();
        }
        return  totalJan;
    }
    public int getFebBlockSewer( ){
        // 2월이 0이아닌 하수구를 구해서
        List<Block> blocks = blockRepository.getBlockFebSewer();
        int totalFeb = 0;
        for(Block block : blocks){
            //각 하수구가 막힌 횟수 막힌 합
            totalFeb = totalFeb + block.getFeb_Count();
        }
        return  totalFeb;
    }
    public int getMarBlockSewer( ){
        // 3월이 0이아닌 하수구를 구해서
        List<Block> sewers = blockRepository.getBlockMarSewer();
        int totalMar = 0;
        for(Block block : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalMar = totalMar + block.getMar_Count();
        }
        return  totalMar;
    }
    public int getAprBlockSewer( ){
        // 4월이 0이아닌 하수구를 구해서
        List<Block> sewers = blockRepository.getBlockAprSewer();
        int totalApr = 0;
        for(Block block : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalApr = totalApr + block.getApr_Count();
        }
        return  totalApr;
    }
    public int getMayBlockSewer( ){
        // 5월이 0이아닌 하수구를 구해서
        List<Block> sewers = blockRepository.getBlockMaySewer();
        int totalMay = 0;
        for(Block block : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalMay = totalMay + block.getMay_Count();
        }
        return  totalMay;
    }
    public int getJunBlockSewer( ){
        // 6월이 0이아닌 하수구를 구해서
        List<Block> sewers = blockRepository.getBlockJunSewer();
        int totalJun = 0;
        for(Block block : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalJun = totalJun + block.getJun_Count();
        }
        return  totalJun;
    }
    public int getJulyBlockSewer( ){
        // 7월이 0이아닌 하수구를 구해서
        List<Block> sewers = blockRepository.getBlockJulySewer();
        int totalJuly = 0;
        for(Block block : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalJuly = totalJuly + block.getJuly_Count();
        }
        return  totalJuly;
    }
    public int getAugBlockSewer( ){
        // 8월이 0이아닌 하수구를 구해서
        List<Block> sewers = blockRepository.getBlockAugSewer();
        int totalAug = 0;
        for(Block block : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalAug = totalAug + block.getAug_Count();
        }
        return  totalAug;
    }
    public int getSepBlockSewer( ){
        // 9월이 0이아닌 하수구를 구해서
        List<Block> sewers = blockRepository.getBlockSepSewer();
        int totalSep = 0;
        for(Block block : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalSep = totalSep + block.getSep_Count();
        }
        return  totalSep;
    }
    public int getOctBlockSewer( ){
        // 10월이 0이아닌 하수구를 구해서
        List<Block> sewers = blockRepository.getBlockOctSewer();
        int totalOct = 0;
        for(Block block : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalOct = totalOct + block.getAug_Count();
        }
        return  totalOct;
    }
    public int getNovBlockSewer( ){
        // 11월이 0이아닌 하수구를 구해서
        List<Block> sewers = blockRepository.getBlockNovSewer();
        int totalNov = 0;
        for(Block block : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalNov = totalNov + block.getNov_Count();
        }
        return  totalNov;
    }
    public int getDecBlockSewer( ){
        // 12월이 0이아닌 하수구를 구해서
        List<Block> sewers = blockRepository.getBlockDecSewer();
        int totalDec = 0;
        for(Block block : sewers){
            //각 하수구가 막힌 횟수 막힌 합
            totalDec = totalDec + block.getDec_Count();
        }
        return  totalDec;
    }


}
