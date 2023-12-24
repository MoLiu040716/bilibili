package com.example.bilibili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//token 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
@SpringBootApplication
@EnableScheduling
public class BilibiliApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilibiliApplication.class, args);
    }
}
