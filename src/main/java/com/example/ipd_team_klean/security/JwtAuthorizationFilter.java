package com.example.ipd_team_klean.security;

import com.example.ipd_team_klean.Entity.Admin;
import com.example.ipd_team_klean.Repository.AdminRepository.AdminRepository;
import com.example.ipd_team_klean.auth.PrincipalDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private  TokenProvider tokenProvider;
    private AdminRepository adminRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, TokenProvider tokenProvider,AdminRepository adminRepository ){
        super(authenticationManager);
        this.tokenProvider = tokenProvider;
        this.adminRepository = adminRepository;
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        if(request.getMethod().equals("OPTIONS")){
            return true;
        }
        return super.shouldNotFilter(request);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String jwtHeader = request.getHeader("Authorization");
        //System.out.println("jwtHeader:"+ jwtHeader);
        // wjt 토큰을 검증을 해서 정상적인 사용자인지 확인 하면 됨
        // header가 있는지 확인

        if(jwtHeader == null || !jwtHeader.startsWith("Bearer") || jwtHeader.equals("Bearer null") ){
            chain.doFilter(request,response);
            return;
        }

        //헤더가 있으면
        String token = request.getHeader("Authorization").replace("Bearer ","");
        System.out.println(token);





        // 토큰 검증
        String adminEmail = tokenProvider.validateAndGetUserEmail(token);

        System.out.println(adminEmail);


        // 서명이 정상적으로 됨
        if(adminEmail != null){
            Admin adimnEntity =adminRepository.findByEmail(adminEmail)
                    .orElseThrow(()->new RuntimeException());

            // user 인증 객체 생성
            // 인증 객체는 서명을 통해서 만든는거 로그인 요청으로 처리한것은 아님 서명을 토큰 서명을 통한 객체
            PrincipalDetails principalDetails = new PrincipalDetails(adimnEntity);
            Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails,null,principalDetails.getAuthorities());

            //강제로 시큐리티의 세션에 접근하여 Authentication객체를 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request,response);


        }
    }
}
