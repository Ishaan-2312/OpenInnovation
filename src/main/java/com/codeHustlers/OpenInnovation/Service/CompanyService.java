package com.codeHustlers.OpenInnovation.Service;

import com.codeHustlers.OpenInnovation.Model.Company;
import com.codeHustlers.OpenInnovation.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company RegisterCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(String id) {
        Optional<Company> organization= companyRepository.findById(id);
        return organization;
    }
    public Optional<Company> login(String companyId,String Password){
        Optional<Company> company=companyRepository.findByCompanyIdAndPassword(companyId,Password);
        return company;
    }
}

