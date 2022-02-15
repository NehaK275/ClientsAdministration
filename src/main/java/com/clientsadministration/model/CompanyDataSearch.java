package com.clientsadministration.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class CompanyDataSearch {
    public CompanyDataSearch(String name, String urlPattern) {
        this.name = name;
        this.urlPattern = urlPattern;
    }
    public CompanyDataSearch() {

    }

    @Id
    private String name;
    private String urlPattern;
}
