package com.codeHustlers.OpenInnovation.Controller;

import com.codeHustlers.OpenInnovation.LoginRequest.CompanyLoginRequest;
import com.codeHustlers.OpenInnovation.Model.Company;
import com.codeHustlers.OpenInnovation.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/Companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/Register")
    public ResponseEntity<Company> registerCompany(@RequestBody Company company) {
        Company savedCompany = companyService.RegisterCompany(company);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginCompany(@RequestBody CompanyLoginRequest companyLoginRequest) {
        Optional<Company> company = companyService.login(companyLoginRequest.getCompanyId(), companyLoginRequest.getPassword());
        if (company.isPresent()) {
            return ResponseEntity.ok("Company Logged Successfully");
        }
        return new ResponseEntity<>(NOT_FOUND);
    }

}
