package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.jk.mapper")
public class SpringDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDubboProviderApplication.class, args);
    }

}
