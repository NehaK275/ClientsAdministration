package com.clientsadministration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ClientsAdministrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientsAdministrationApplication.class, args);
    }

}
