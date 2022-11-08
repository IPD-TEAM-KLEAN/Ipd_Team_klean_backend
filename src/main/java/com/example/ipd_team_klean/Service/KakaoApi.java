package com.example.ipd_team_klean.Service;

import com.example.ipd_team_klean.DTO.ResponseDTO.KaKaoResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoApi {
    @Value("${kakao_id}")
    private String kakao_apikey;

    public KaKaoResponseDTO getLocation(Double x, Double y) {

        final HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + kakao_apikey);

        RestTemplate restTemplate = new RestTemplate();
        String lon = Double.toString(x);
        String lat = Double.toString(y);

//        System.out.println(lon);
//        if(lon.equals("129.4270057827989")){
//            System.out.println("동일");
//        }
        String apiURL = "https://dapi.kakao.com/v2/local/geo/coord2address.json?"
                + "&x=" + lon
                + "&y=" + lat
                + "&input_coord=" + "WGS84";
        final HttpEntity<String> entity = new HttpEntity<>(headers);

//        System.out.println(restTemplate.exchange(apiURL, HttpMethod.GET, entity,String.class).toString());

        return restTemplate.exchange(apiURL, HttpMethod.GET, entity,KaKaoResponseDTO.class).getBody();

    }
}
