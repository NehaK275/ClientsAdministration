package com.clientsadministration.web;

import com.clientsadministration.model.Company;
import com.clientsadministration.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("/addCompany")
    public String addCompany()
    {
        return "add-company";
    }
    @PostMapping("/save")
    public String saveCompany(@RequestParam String name,
                              @RequestParam String address,
                              @RequestParam String brand,
                              @RequestParam String founder) {
        Company company = new Company();
        company.setName(name);
        company.setAddress(address);
        company.setBrand(brand);
        company.setFounder(founder);
        companyService.save(company);
        return "redirect:/company";
    }
    //EDIT
    @GetMapping("/edit/{id}")
    public String editCompany(@PathVariable Long id,
                              Model model)
    {
        model.addAttribute("company",companyService.findById(id));
        return "add-company";
    }
    @PostMapping("/save/{id}")
    public String updateCompany(@RequestParam String name,
                                @RequestParam String address,
                                @RequestParam String brand,
                                @RequestParam String founder,
                                @PathVariable Long id)
    {
        Company company = companyService.findById(id);
        company.setName(name);
        company.setAddress(address);
        company.setBrand(brand);
        company.setFounder(founder);
        companyService.save(company);
        return "redirect:/company";
    }
    //DELETE
    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id)
    {
        companyService.deleteById(id);
        return "redirect:/company";
    }
    @GetMapping("/showDetails/{id}")
    public String showDetails(@PathVariable Long id,
                              Model model) {
        Company company = companyService.findById(id);
        company.populateEntities();
        model.addAttribute("entities",company.getEntities());
        model.addAttribute("company",company);
        return "companyDetails";
    }
}
