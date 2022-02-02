package com.clientsadministration.web;

import com.clientsadministration.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/company","/"})
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public String showCompanies(Model model)
    {
        model.addAttribute("companies",companyService.findAll());
        return "showCompanies";
    }
}
