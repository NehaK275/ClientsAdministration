package com.clientsadministration.repository;

import com.clientsadministration.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Page<Company> findAllByNameContaining(Pageable pageable,String text);
    List<Company> findAllByNameContaining(String text);
}
