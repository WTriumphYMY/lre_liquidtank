package cn.edu.nwpu.liquidtank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LiquidtankApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiquidtankApplication.class, args);
    }

}
