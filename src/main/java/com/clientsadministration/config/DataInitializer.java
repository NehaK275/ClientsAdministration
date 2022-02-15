package com.clientsadministration.config;

import com.clientsadministration.service.CompanyDataSearchService;
import com.clientsadministration.service.CompanyService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class DataInitializer {

    private final CompanyService companyService;
    private final CompanyDataSearchService companyDataSearchService;

    public DataInitializer(CompanyService companyService, CompanyDataSearchService companyDataSearchService) {
        this.companyService = companyService;
        this.companyDataSearchService = companyDataSearchService;
    }

    @PostConstruct
    public void initData() {
        companyService.create("Apple.com","Dragan","tetovo","apple");
        companyService.create("Telekom.mk","Dragan","Skopje","Huawei");
        companyService.create("Тинекс","Dragan","Kichevo","Finki");
        for(int i=1;i<=19;i++)
        {
            companyService.create("Company " + i,"Founder " + i,"Address " + i,"Brand " + i);
        }
        companyDataSearchService.save("schema","https://validator.schema.org/#url=");
        companyDataSearchService.save("dbpedia","https://dbpedia.org/page/");
        companyDataSearchService.save("centralenRegistar(Kirilica)","https://www.crm.com.mk/mk/otvoreni-podatotsi/osnoven-profil-na-registriran-subjekt?s=");
    }
}
