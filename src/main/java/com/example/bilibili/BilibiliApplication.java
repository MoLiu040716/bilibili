package com.example.bilibili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//token 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
@SpringBootApplication
@MapperScan("com.example.bilibili.mapper.cj")
public class BilibiliApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilibiliApplication.class, args);
    }
}
