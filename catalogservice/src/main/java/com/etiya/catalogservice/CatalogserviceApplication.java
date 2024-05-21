package com.etiya.catalogservice;

import com.etiya.common.annotations.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSecurity()
public class CatalogserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogserviceApplication.class, args);
    }

}
