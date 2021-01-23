package com.isgoto.synchronous;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.isgoto.synchronous.mapper")
public class SynchronousApplication {

    public static void main(String[] args) {
        SpringApplication.run(SynchronousApplication.class, args);
    }

}
