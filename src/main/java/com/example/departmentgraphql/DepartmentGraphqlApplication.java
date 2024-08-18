package com.example.departmentgraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DepartmentGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentGraphqlApplication.class, args);
    }

}
