package com.ex.ssg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// 스프링 세큐리티 인증 필수 인수 생성자
// @RequiredArgsConstructor
// 스프링의 환경설정 파일임을 의미하는 어노테이션
@Configuration
// 웹 보안 활성화. 모든 요청 URL이 스프링 세큐리티의 제어를 받도록 만드는 어노테이션
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 모든 인증되지 않은 요청을 허락한다는 의미. 로그인을 하지 않더라도 모든 페이지에 접근 할 수 있다.
        http.authorizeRequests()
            // .requestMatchers( new AntPathRequestMatcher("/**")).permitAll()
            .antMatchers("/**").permitAll()
            // .and()
                // .csrf().ignoringRequestMatchers( new AntPathRequestMatcher("/**"))

            // .antMatchers("/admin/**").hasAnyAuthority("ADMIN")

        // http 객체의 설정을 이어서 할 수 있게 하는 메서드이다.
            // .and()
                // .csrf().disable() .headers().frameOptions().disable()
        // .and()
        //     .headers()
        //     .addHeaderWriter(new XFrameOptionsHeaderWriter(
        //             XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
            .and()
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/")
            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
        ;
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
