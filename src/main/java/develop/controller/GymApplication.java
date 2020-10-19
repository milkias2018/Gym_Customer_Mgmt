package develop.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"develop.controller","develop.service",
                                            "develop.dao","develop.dto","develop.entity"})
@EntityScan(basePackages = "develop.entity")
public class GymApplication
{
    public static void main(String[] args) {
        SpringApplication.run(GymApplication.class, args);
    }

}