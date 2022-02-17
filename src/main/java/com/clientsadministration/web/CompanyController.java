package com.clientsadministration.web;

import com.clientsadministration.model.Company;
import com.clientsadministration.service.CompanyDataSearchService;
import com.clientsadministration.service.CompanyService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
@RequestMapping({"/company","/"})
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyDataSearchService companyDataSearchService;

    public CompanyController(CompanyService companyService, CompanyDataSearchService companyDataSearchService) {
        this.companyService = companyService;
        this.companyDataSearchService = companyDataSearchService;
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
        model.addAttribute("dataSearchValidators",companyDataSearchService.findAll());
        return "add-company";
    }
    @PostMapping("/save/{id}")
    public String updateCompany(
            @RequestParam String name,
            @RequestParam String founder,
            @RequestParam String address,
            @RequestParam String areaServed,
            @RequestParam String award,
            @RequestParam String brand,
            @RequestParam String contactPoint,
            @RequestParam String department,
            @RequestParam String description,
            @RequestParam String duns,
            @RequestParam String email,
            @RequestParam String employee,
            @RequestParam String event,
            @RequestParam String fax_number,
            @RequestParam String foundingDate,
            @RequestParam String foundingLocation,
            @RequestParam String funder,
            @RequestParam boolean hasParentOrganisation,
            @RequestParam boolean hasPos,
            @RequestParam String knowsAbout,
            @RequestParam String knowsLanguage,
            @RequestParam String logoUrl,
            @RequestParam String member,
            @RequestParam String parentOrganisation,
            @RequestParam String phone,
            @RequestParam String review,
            @RequestParam String slogan,
            @RequestParam String taxId,
            @RequestParam String products,
            @PathVariable Long id)
    {
        Company company;
        if(id != null){
            company = companyService.findById(id);
            company.setName(name);
            company.setFounder(founder);
            company.setAddress(address);
            company.setAreaServed(areaServed);
            company.setAward(award);
            company.setBrand(brand);
            company.setContactPoint(contactPoint);
            company.setDepartment(department);
            company.setDescription(description);
            company.setDuns(duns);
            company.setEmail(email);
            company.setEvent(event);
            company.setFax_number(fax_number);
            company.setFoundingDate(LocalDate.parse(foundingDate));
            company.setFunder(funder);
            company.setParentOrganisation(parentOrganisation);
            company.setHasPos(hasPos);
            company.setKnowsAbout(knowsAbout);
            company.setKnowsLanguage(knowsLanguage);
            company.setLogoUrl(logoUrl);
            company.setMember(member);
            company.setParentOrganisation(parentOrganisation);
            company.setPhone(phone);
            company.setReview(review);
            company.setSlogan(slogan);
            company.setTaxId(taxId);
            company.setProducts(products);
        }
        else{
            company = new Company(name, founder, address, areaServed, award, brand, contactPoint, department, description, duns, email, employee, event, fax_number,LocalDate.parse(foundingDate), foundingLocation, funder, hasParentOrganisation, hasPos, knowsAbout, knowsLanguage, logoUrl, member, parentOrganisation, phone, review, slogan, taxId, products);
        }
        companyService.save(company);
        return "redirect:/company";
        //TEST
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