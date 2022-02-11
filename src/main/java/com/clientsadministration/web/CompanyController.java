package com.clientsadministration.web;

import com.clientsadministration.model.Company;
import com.clientsadministration.repository.CompanyRepository;
import com.clientsadministration.service.CompanyService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedStoredProcedureQueries;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/company","/"})
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String showCompanies(Model model, HttpServletRequest request , @RequestParam(required = false) String search)
    {
        Pageable stranica = PageRequest.of(0,5);
        request.getSession().setAttribute("momentalna",1);
        if(search == null || search.isEmpty()) {
            model.addAttribute("companies", companyService.findAll(stranica));
            model.addAttribute("pageSize", companyService.findAll(stranica).getNumberOfElements());
            model.addAttribute("size", companyService.findAll().size());
        }
        else{
            model.addAttribute("companies", companyService.findAllByNameContaining(stranica,search));
            model.addAttribute("pageSize", companyService.findAllByNameContaining(stranica,search).getNumberOfElements());
            model.addAttribute("size", companyService.findAllByNameContaining(search).size());
        }
        return "showCompanies";
    }

    @GetMapping("{page}")
    public String ShowCompanies(@PathVariable Integer page,
                                Model model,HttpServletRequest request)
    {
        double listSize = Math.ceil(companyService.findAll().size()/5.0);
        int momentalna;
        if(page>listSize && page!=10 || page==-1) {
            return "redirect:/company";
        }
        else{
            momentalna=page;
            request.getSession().setAttribute("momentalna",momentalna);
        }
        if(page==10)
        {
            momentalna= (int) listSize;
            request.getSession().setAttribute("momentalna",momentalna);
        }
        Pageable stranica = PageRequest.of(momentalna-1,5);
        model.addAttribute("size",companyService.findAll().size());
        model.addAttribute("pageSize",companyService.findAll(stranica).getNumberOfElements());
        model.addAttribute("companies",companyService.findAll(stranica));
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
                              @RequestParam String founder,
                              @RequestParam String logoURL) {
        Company company = new Company();
        company.setName(name);
        company.setAddress(address);
        company.setBrand(brand);
        company.setFounder(founder);
        company.setLogoUrl(logoURL);
        companyService.save(company);
        return "redirect:/company";
    }
    //EDIT
    @GetMapping("/edit/{id}")
    public String editCompany(@PathVariable Long id,
                              Model model)
    {
        Company company = companyService.findById(id);
        company.populateEntities();
        model.addAttribute("company",company);
        model.addAttribute("entities",company.getEntities());
        return "add-company";
    }
    @PostMapping("/save/{id}")
    public String updateCompany(@RequestParam Map<String,String> entities,
                                @PathVariable Long id)
    {
        Company company = companyService.findById(id);

//        company.setName(name);
//        company.setAddress(address);
//        company.setBrand(brand);
//        company.setFounder(founder);
//        company.setLogoUrl(logoURL);
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