package com.clientsadministration.config;

import com.clientsadministration.service.CompanyService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class DataInitializer {

    private final CompanyService companyService;

    public DataInitializer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostConstruct
    public void initData() {
        for(int i=1;i<=19;i++)
        {
            companyService.create("Company " + i,"Founder " + i,"Address " + i,"Brand " + i);
        }
    }
}
