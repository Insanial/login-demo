package com.demo.login_demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //过滤链配置
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            .authorizeHttpRequests(authorize -> authorize//开启授权
                .requestMatchers("/hello")//放行/hello请求
                .permitAll()//允许所有人访问
                .anyRequest()//允许所有请求
                .authenticated()//认证后访问自动授权
            )
            .formLogin(Customizer.withDefaults());//使用默认的登陆登出页面进行授权登陆
        http.csrf(csrf -> csrf.disable());//关闭csrf
        return http.build();
    }
}
