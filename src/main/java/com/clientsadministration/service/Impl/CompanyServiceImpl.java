package com.clientsadministration.service.Impl;

import com.clientsadministration.model.Company;
import com.clientsadministration.repository.CompanyRepository;
import com.clientsadministration.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
