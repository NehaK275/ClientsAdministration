package com.clientsadministration.service.Impl;

import com.clientsadministration.exceptions.InvalidCompanyIdException;
import com.clientsadministration.model.Company;
import com.clientsadministration.repository.CompanyRepository;
import com.clientsadministration.service.CompanyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Company> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public Company create(String name, String founder, String address, String brand) {
        return this.companyRepository.save(new Company(name,founder,address,brand));
    }

    @Override
    public Page<Company> findAllByNameContaining(Pageable pageable,String text) {
        return this.companyRepository.findAllByNameContaining(pageable,text);
    }

    @Override
    public List<Company> findAllByNameContaining(String text) {
        return this.companyRepository.findAllByNameContaining(text);
    }
}
