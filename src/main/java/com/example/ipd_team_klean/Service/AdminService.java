package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.RequestDTO.AdminRequestDTO.AdminJoinRequestDTO;
import com.example.ipd_team_klean.DTO.ResponseDTO.AdminResponseDTO.AdminJoinResponseDTO;
import com.example.ipd_team_klean.Entity.Admin;
import com.example.ipd_team_klean.Error.CustomException;
import com.example.ipd_team_klean.Error.ErrorCode;
import com.example.ipd_team_klean.Repository.AdminRepository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AdminService {
    private  final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public AdminJoinResponseDTO create(AdminJoinRequestDTO adminJoinRequestDTO) throws Exception {
        if(adminRepository.existsByEmail(adminJoinRequestDTO.getEmail())){
            throw new Exception();
        }
        if(adminJoinRequestDTO.getEmail().equals("")){
            throw new CustomException("해당 이메일이 존재 합니다.", ErrorCode.DuplicatedEmilException);
        }
        if(adminJoinRequestDTO.getAddress().equals("")){
            throw new CustomException("잘못된 형식의 데이터 입니다.",ErrorCode.BadParameterException);
        }

        if(adminJoinRequestDTO.getPassword().equals("")){
            throw new CustomException("잘못된 형식의 데이터 입니다.",ErrorCode.BadParameterException);
        }
        if(adminJoinRequestDTO.getAdminname().equals("")){
            throw new CustomException("잘못된 형식의 데이터 입니다.",ErrorCode.BadParameterException);
        }
        if(adminJoinRequestDTO.getPhoneNumber().equals("")){
            throw new CustomException("잘못된 형식의 데이터 입니다.",ErrorCode.BadParameterException);
        }

        Admin admin = Admin.builder()
                .email(adminJoinRequestDTO.getEmail())
                .password(passwordEncoder.encode((adminJoinRequestDTO.getPassword())))
                .adminname(adminJoinRequestDTO.getAdminname())
                .address(adminJoinRequestDTO.getAddress())
                .roles("ROLE_ADMIN")
               .phoneNumber(adminJoinRequestDTO.getPhoneNumber()).build();


        System.out.println(admin.getEmail());
        if(admin == null || admin.getEmail().equals("")){
            throw new NoSuchElementException("잘못된 형식의 데이터 입니다. ");
        }
        adminRepository.save(admin);
        AdminJoinResponseDTO adminJoinResponseDTO = AdminJoinResponseDTO.builder()
                .email(admin.getEmail())
                .adminname(admin.getAdminname())
                .address(admin.getAddress())
                .phoneNumber(admin.getPhoneNumber())
                .createDate(admin.getCreateDate())
                .build();



        return adminJoinResponseDTO;
    }



}
