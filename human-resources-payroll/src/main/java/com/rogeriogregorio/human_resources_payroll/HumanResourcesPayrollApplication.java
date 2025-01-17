package com.rogeriogregorio.human_resources_payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HumanResourcesPayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanResourcesPayrollApplication.class, args);
    }

}
