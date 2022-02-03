package com.clientsadministration.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String founder;
    private String address;
    private String areaServed;
    private String award;
    private String brand;
    private String contactPoint;
    private String department;
    private String description;
    private String duns;
    private String email;
    private String employee;
    private String event;
    private String fax_number;
    private LocalDate foundingDate;
    private String foundingLocation;
    private String funder; // sponzor
    private boolean hasParentOrganisation;
    private boolean hasPos;
    private String knowsAbout;
    private String knowsLanguage;
    private String logoUrl;
    private String member;
    private String parentOrganisation;
    private String phone;
    private String review;
    private String slogan;
    private String taxId;
    private String products;

    public Company() {
        foundingDate=LocalDate.now();
        hasParentOrganisation=false;
        hasPos=false;
        name="unknown";
        founder="unknown";
        address="unknown";
        areaServed="unknown";
        award="unknown";
        brand="unknown";
        contactPoint="unknown";
        department="unknown";
        description="unknown";
        duns="unknown";
        email="unknown";
        employee="unknown";
        event="unknown";
        fax_number="unknown";
        foundingLocation="unknown";
        funder="unknown";
        knowsAbout="unknown";
        knowsLanguage="unknown";
        logoUrl="unknown";
        member="unknown";
        parentOrganisation="unknown";
        phone="unknown";
        review="unknown";
        slogan="unknown";
        taxId="unknown";
        products="unknown";
    }

    public Company(String name, String founder, String address, String areaServed, String award, String brand, String contactPoint, String department, String description, String duns, String email, String employee, String event, String fax_number, LocalDate foundingDate, String foundingLocation, String funder, boolean hasParentOrganisation, boolean hasPos, String knowsAbout, String knowsLanguage, String logoUrl, String member, String parentOrganisation, String phone, String review, String slogan, String taxId, String products) {
        this.name = name;
        this.founder = founder;
        this.address = address;
        this.areaServed = areaServed;
        this.award = award;
        this.brand = brand;
        this.contactPoint = contactPoint;
        this.department = department;
        this.description = description;
        this.duns = duns;
        this.email = email;
        this.employee = employee;
        this.event = event;
        this.fax_number = fax_number;
        this.foundingDate = foundingDate;
        this.foundingLocation = foundingLocation;
        this.funder = funder;
        this.hasParentOrganisation = hasParentOrganisation;
        this.hasPos = hasPos;
        this.knowsAbout = knowsAbout;
        this.knowsLanguage = knowsLanguage;
        this.logoUrl = logoUrl;
        this.member = member;
        this.parentOrganisation = parentOrganisation;
        this.phone = phone;
        this.review = review;
        this.slogan = slogan;
        this.taxId = taxId;
        this.products = products;
    }
}
