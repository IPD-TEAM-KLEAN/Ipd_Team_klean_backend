package com.example.ipd_team_klean.Controller;


import com.example.ipd_team_klean.DTO.ResponseDTO.DeclarationDTO.DeclarationDTO;
import com.example.ipd_team_klean.DTO.ResponseDTO.DeclarationDTO.DeclarationGetDTO;
import com.example.ipd_team_klean.Service.DeclarationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeclarationController {
    private  final DeclarationService declarationService;


    @GetMapping("/declaration/{lat}/{lon}")
    public ResponseEntity<?> declaration(@PathVariable(value = "lat") double lat, @PathVariable(value = "lon") double lon) throws Exception {
        System.out.println(lat);
        System.out.println(lon);
        // 위도 경도로 찾기
        DeclarationDTO declarationDTO = declarationService.declaration(lat, lon);
        return  ResponseEntity.ok().body(declarationDTO);
    }

    @GetMapping("/declaration/get/list")
    public ResponseEntity<?> declarationGet(){
        List<DeclarationGetDTO> declarationGetDTOList = declarationService.getdeclaration();
        return  ResponseEntity.ok().body(declarationGetDTOList);

    }




}
