package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.ResponseDTO.BatteryResponeDTO.ChangeBatteryListResponseDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChageBlockResponseDTO.ChangeBlockListResponseDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO.ChangeHListReponseDto;
import com.example.ipd_team_klean.DTO.ResponseDTO.ChangeTHResponseDTO.ChangeTListReponseDto;
import com.example.ipd_team_klean.Service.ChangeBatteryService;
import com.example.ipd_team_klean.Service.ChangeBlockService;
import com.example.ipd_team_klean.Service.ChangeHService;
import com.example.ipd_team_klean.Service.ChangeTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AlldatacsvCotroller {

    private  final ChangeBlockService changeBlockService;
    private  final ChangeBatteryService changeBatteryService;
    private  final ChangeHService changeHService;
    private  final ChangeTService changeTService;

    @GetMapping("/download/csv")
    public ResponseEntity<?> DownloadCsv(){
        List<ChangeBlockListResponseDto> changeBlockListResponseDtoList = changeBlockService.changeBlockList(); // 거리
        List<ChangeBatteryListResponseDto> changeBatteryListResponseDtoList= changeBatteryService.batteryList(); // 배터리
        List<ChangeHListReponseDto> changeHListReponseDtoList = changeHService.changeHList(); // 습도
        List<ChangeTListReponseDto> changeTListReponseDtoList = changeTService.changeTList(); // 온도

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "text/csv; charset=MS949");
        header.add("Content-Disposition", "attachment; filename=\""+"waterpipe.csv"+"\"");
        return new ResponseEntity<>(setContent(changeBlockListResponseDtoList, changeBatteryListResponseDtoList, changeHListReponseDtoList, changeTListReponseDtoList),header, HttpStatus.CREATED);
    }



    public String setContent(List<ChangeBlockListResponseDto> changeBlockListResponseDtoList, List<ChangeBatteryListResponseDto> changeBatteryListResponseDtoList , List<ChangeHListReponseDto> changeHListReponseDtoList, List<ChangeTListReponseDto> changeTListReponseDtoList){
        String data = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
        data = "pid, 거리, 온도, 습도, 베터리,  시간, 위도, 경도 , 하수구 번호, 도로명 주소" + "\n";

        for(int i=0; i<changeBlockListResponseDtoList.size(); i++){
            data += changeBlockListResponseDtoList.get(i).getId()+","; // 거리 id
            data += changeBlockListResponseDtoList.get(i).getValue()+","; // 거리 value
            data += changeTListReponseDtoList.get(i).getValue()+",";
            data +=changeHListReponseDtoList.get(i).getValue()+",";
            data += changeBatteryListResponseDtoList.get(i).getValue()+",";
            data += changeBlockListResponseDtoList.get(i).getLocalDateTime()+",";
            data += changeBlockListResponseDtoList.get(i).getLatitude()+",";
            data += changeBlockListResponseDtoList.get(i).getLongitude()+",";
            data += changeBlockListResponseDtoList.get(i).getSewerId()+",";
            data += changeBlockListResponseDtoList.get(i).getAddress_name()+ "\n" ;

        }

//        for(ChangeBlockListResponseDto changeBlockListResponseDto : changeBlockListResponseDtoList){
//
//            data += changeBlockListResponseDto.getId() + ",";
//            data += changeBlockListResponseDto.getValue()+",";
//            data += changeBlockListResponseDto.getLocalDateTime()+",";
//            data += changeBlockListResponseDto.getLatitude() + ",";
//            data += changeBlockListResponseDto.getLongitude() + ",";
//            data += changeBlockListResponseDto.getSewerId() +",";
//            data += changeBlockListResponseDto.getAddress_name() + "\n";
//        }
        return  data;
    }
}
