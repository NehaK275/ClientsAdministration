package com.clientsadministration.service.Impl;

import com.clientsadministration.model.CompanyDataSearch;
import com.clientsadministration.repository.CompanyDataSearchRepository;
import com.clientsadministration.service.CompanyDataSearchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyDataSearchServiceImpl implements CompanyDataSearchService {
    private final CompanyDataSearchRepository companyDataSearchRepository;

    public CompanyDataSearchServiceImpl(CompanyDataSearchRepository companyDataSearchRepository) {
        this.companyDataSearchRepository = companyDataSearchRepository;
    }

    @Override
    public List<CompanyDataSearch> findAll() {
        return companyDataSearchRepository.findAll();
    }

    @Override
    public void save(String name, String url) {
        companyDataSearchRepository.save(new CompanyDataSearch(name,url));
    }
}
