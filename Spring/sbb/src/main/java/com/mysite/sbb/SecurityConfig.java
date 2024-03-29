package com.mysite.sbb;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// PasswordEncoder 빈 등록
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableMethodSecurity(prePostEnabled = true)
//PreAuthorize 애너테이션 동작 :: 로그아웃 상태에서 질문, 답변 등록 시 로그인 화면으로 이동
@Configuration
// 스프링의 환경설정 파일임을 의미하는 애너테이션
@EnableWebSecurity
// 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션
    // 애너테이션 사용 시 내부적으로 SpringSecurityFilterChain이 동작하여 URL 필터 적용.
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
        // 인증되지 않는 요청을 허락하는 제어(로그인 예외처리)
        .authorizeHttpRequests((authorizeHttpRequests)-> authorizeHttpRequests
            .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
        .csrf((csrf) -> csrf
        // h2-console csrf 예외처리
            .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
        // h2-console X-Frame-Options 예외처리
            // X-Frame-Options sameorigin으로 설정 시 frame 포함 페이지가 페이지를 제공하는 사이트와 동일한 경우 사용 가능
        .headers((headers) -> headers
            .addHeaderWriter(new XFrameOptionsHeaderWriter(
                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
        .formLogin((formLogin) -> formLogin
        // formLogin :: 스프링 시큐리티 로그인 설정 담당 부분
            .loginPage("/user/login")
            .defaultSuccessUrl("/question/list"))
        .logout((logout) -> logout
        // 로그아웃 버튼 실행시 로그아웃 URL 설정, 사용자 세션 삭제 처리, 루트 페이지 이동
            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true))
        ;
        return http.build();
    }
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
    // 스프링 시큐리티의 인증을 담당한다 (사용자 인증 시 UserSecurityService, PasswordEncoder 사용)
        throws Exception {
            return authenticationConfiguration.getAuthenticationManager();
        }
}