package com.clientsadministration.service;

import com.clientsadministration.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    void deleteById(Long id);
}
