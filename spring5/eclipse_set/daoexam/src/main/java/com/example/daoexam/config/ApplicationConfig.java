package com.example.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//ctrl+shift+o-자동 임포트
@Configuration
@Import({com.example.daoexam.config.DBConfig.class})
@ComponentScan(basePackages = {"com.example.daoexam001.dao"})
public class ApplicationConfig {

}
