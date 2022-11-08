package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.ResponseDTO.KaKaoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {
    private  final KakaoApi kakaoApi;

    public KaKaoResponseDTO getLocation(Double x, Double y){
        return kakaoApi.getLocation( x,y);
    }
}
