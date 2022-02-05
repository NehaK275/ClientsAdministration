package com.clientsadministration.model;


import lombok.Data;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

    @Transient
    Map<String,Object> entities = new HashMap<>();

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
    @PostConstruct
    public void populateEntities()
    {
        entities.put("foundingDate",foundingDate);
        entities.put("hasParentOrganisation",hasParentOrganisation);
        entities.put("hasPos",hasPos);
        entities.put("name",name);
        entities.put("founder",founder);
        entities.put("address",address);
        entities.put("areaServed",areaServed);
        entities.put("award",award);
        entities.put("brand",brand);
        entities.put("contactPoint",contactPoint);
        entities.put("department",department);
        entities.put("description",description);
        entities.put("duns",duns);
        entities.put("email",email);
        entities.put("employee",employee);
        entities.put("event",event);
        entities.put("fax_number",fax_number);
        entities.put("foundingLocation",foundingLocation);
        entities.put("funder",funder);
        entities.put("knowsAbout",knowsAbout);
        entities.put("knowsLanguage",knowsLanguage);
        entities.put("member",member);
        entities.put("parentOrganisation",parentOrganisation);
        entities.put("phone",phone);
        entities.put("review",review);
        entities.put("slogan",slogan);
        entities.put("taxId",taxId);
        entities.put("products",products);
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
