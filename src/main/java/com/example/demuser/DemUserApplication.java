package com.example.demuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
// TODO KT 2021-03-14: rename to DemoUserApplication
public class DemUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemUserApplication.class, args);
    }

}
