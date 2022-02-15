package com.clientsadministration.repository;

import com.clientsadministration.model.CompanyDataSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDataSearchRepository extends JpaRepository<CompanyDataSearch,String> {
}
