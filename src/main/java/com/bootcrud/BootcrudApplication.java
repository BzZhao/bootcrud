package com.bootcrud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mapperScan 指定当前项目中mapper接口路径的位置，在项目启动的时候会自动加载所有的接口
@MapperScan("com.bootcrud.mapper")
public class BootcrudApplication {


    public static void main(String[] args) {
        SpringApplication.run(BootcrudApplication.class, args);
    }


    }
