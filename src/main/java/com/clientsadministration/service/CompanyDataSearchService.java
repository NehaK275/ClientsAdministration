package com.clientsadministration.service;

import com.clientsadministration.model.CompanyDataSearch;

import java.util.List;

public interface CompanyDataSearchService {
    List<CompanyDataSearch> findAll();
    void save(String name,String url);
}
