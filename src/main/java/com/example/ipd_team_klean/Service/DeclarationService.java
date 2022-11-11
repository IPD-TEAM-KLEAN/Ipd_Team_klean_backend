package com.example.ipd_team_klean.Service;


import com.example.ipd_team_klean.DTO.ResponseDTO.DeclarationDTO.DeclarationDTO;
import com.example.ipd_team_klean.DTO.ResponseDTO.DeclarationDTO.DeclarationGetDTO;
import com.example.ipd_team_klean.Entity.Declaration;
import com.example.ipd_team_klean.Entity.Sewer;
import com.example.ipd_team_klean.Repository.DeclarationRepository.DeclarationRepository;
import com.example.ipd_team_klean.Repository.SewerRepository.SewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeclarationService {
    private  final DeclarationRepository declarationRepository;
    private  final SewerRepository sewerRepository;


    // 신고시 신고 카운터 업데이트

    public DeclarationDTO declaration(double lat , double lon) throws Exception {
        Sewer sewer = sewerRepository.findByLatAndLon(lat, lon); // 위도 경도로 하수구 찾기
        System.out.println(sewer.getLat());
        // 하수구의 색 별로 업데이트 받아야
        // 만약 하수구의 상태가 red 일시 만 count 가 올리도록 그게 아니면 오류 처리

        if(sewer.getBlock().getStates().equals("red")){
            sewer.getDeclaration().setAccumulate_Count(sewer.getDeclaration().getAccumulate_Count()+1);
            sewer.getDeclaration().setDeclaration_Count(sewer.getDeclaration().getDeclaration_Count()+1);
            sewerRepository.save(sewer);

        }else{
            throw  new Exception(); // 500  error 핸들링 을 통한 수정 필요
        }

        // 하수구 상태 업데이트
        DeclarationDTO declarationDTO = DeclarationDTO.builder()
                .declaration_Count(sewer.getDeclaration().getDeclaration_Count()).build();
        return declarationDTO;

    }


    // 신고 카운터 보여주기
    public List<DeclarationGetDTO> getdeclaration(){
        // 신고 카운트가 0 이상인 하수구 찾기
        List<Declaration> declarations = declarationRepository.getDeclarationSewer();

        // 하수구를 response해야함
        // 위도 경도 위치 response
        List<DeclarationGetDTO> declarationGetDTOS = new ArrayList<>();
        for(Declaration declaration : declarations){
            DeclarationGetDTO declarationGetDTO = DeclarationGetDTO.builder()
                    .address_name(declaration.getSewer().getAddress_name())
                    .region_name(declaration.getSewer().getRegion_name())
                    .latitude(declaration.getSewer().getLat())
                    .longtitude(declaration.getSewer().getLon())
                    .declaration_Count(declaration.getDeclaration_Count())
                    .state(declaration.getSewer().getBlock().getStates())
                    .build();
            declarationGetDTOS.add(declarationGetDTO);
            }
        return  declarationGetDTOS;


    }



}
