package com.example.wx_zaoan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WxZaoanApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxZaoanApplication.class, args);
    }

}
