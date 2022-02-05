package com.clientsadministration.service.Impl;

import com.clientsadministration.exceptions.InvalidCompanyIdException;
import com.clientsadministration.model.Company;
import com.clientsadministration.repository.CompanyRepository;
import com.clientsadministration.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(InvalidCompanyIdException::new);
    }

    @Override
    public Company save(Company c) {
        return companyRepository.save(c);
    }
}
