package com.clientsadministration.service;

import com.clientsadministration.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CompanyService {
    List<Company> findAll();
    void deleteById(Long id);
    Company findById(Long id);
    Company save(Company c);
    Page<Company> findAll(Pageable pageable);
}
