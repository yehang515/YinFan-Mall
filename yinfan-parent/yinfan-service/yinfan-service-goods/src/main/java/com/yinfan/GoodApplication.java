package com.yinfan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.yinfan.goods.dao"})
public class GoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodApplication.class, args);
    }
}
