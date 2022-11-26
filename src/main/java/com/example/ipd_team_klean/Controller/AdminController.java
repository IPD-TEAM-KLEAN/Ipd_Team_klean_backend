package com.example.ipd_team_klean.Controller;

import com.example.ipd_team_klean.DTO.RequestDTO.AdminRequestDTO.AdminJoinRequestDTO;
import com.example.ipd_team_klean.DTO.ResponseDTO.AdminResponseDTO.AdminJoinResponseDTO;
import com.example.ipd_team_klean.Service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j

@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/join")
    public ResponseEntity<?> signup(@RequestBody  @Valid  AdminJoinRequestDTO adminJoinRequestDTO) throws Exception {

        AdminJoinResponseDTO adminJoinResponseDTO = adminService.create(adminJoinRequestDTO);


        Map<String, Object> response = new HashMap<>();
        response.put("msg", "회원가입에 성공했습니다.");
        response.put("data", adminJoinResponseDTO);

        return ResponseEntity.ok().body(response);
    }

}
