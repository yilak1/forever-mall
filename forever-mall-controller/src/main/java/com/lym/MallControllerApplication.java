package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.lym.mapper")
public class MallControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallControllerApplication.class, args);
    }
}
