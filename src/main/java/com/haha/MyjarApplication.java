package com.haha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.haha.dao")
public class MyjarApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyjarApplication.class, args);
    }

}
