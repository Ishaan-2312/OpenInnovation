package com.codeHustlers.OpenInnovation.Repository;

import com.codeHustlers.OpenInnovation.Model.Company;
//import com.codeHustlers.OpenInnovation.Model.Organization;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CompanyRepository extends MongoRepository<Company,String>
{
    Optional<Company> findByCompanyIdAndPassword(String companyId, String Password);
}
