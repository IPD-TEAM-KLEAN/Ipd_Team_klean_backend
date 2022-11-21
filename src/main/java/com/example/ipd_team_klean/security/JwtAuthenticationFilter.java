package com.example.ipd_team_klean.security;

import com.example.ipd_team_klean.Entity.Admin;
import com.example.ipd_team_klean.auth.PrincipalDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
// 첫 로그인시 인증 필터
public class JwtAuthenticationFilter extends JsonIdPwAuthenticationFilter {
    private  final AuthenticationManager authenticationManager;
    private  final TokenProvider tokenProvider;

    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
       try{
           PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();
           Admin admin = principalDetails.getAdmin();
           String jwt = tokenProvider.create(admin);
           response.setContentType("application/json");

           response.addHeader("Authorization","Bearer "+jwt);
           Map<String, Object> res = new HashMap<>();
           res.put("msg", "login success");
           ResponseEntity.ok().body(res);

           String result = objectMapper.writeValueAsString(res);
           response.getWriter().write(result);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{
        try{
            Admin admin = objectMapper.readValue(request.getInputStream(),Admin.class);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(admin.getEmail(),admin.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            return authentication;
        }catch (IOException e){
            return  null;

        }
    }
}
