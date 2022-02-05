package com.clientsadministration.service;

import com.clientsadministration.model.Company;

import java.util.List;
import java.util.Map;

public interface CompanyService {
    List<Company> findAll();
    void deleteById(Long id);
    Company findById(Long id);
}
