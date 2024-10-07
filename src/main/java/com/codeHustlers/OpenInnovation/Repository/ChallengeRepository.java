package com.codeHustlers.OpenInnovation.Repository;

import com.codeHustlers.OpenInnovation.Model.Challenge;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ChallengeRepository extends MongoRepository<Challenge,String> {

    Optional<Challenge> findByCompanyIdAndId(String companyId,String id);

    List<Challenge> findAllByCompanyId(String companyId);
}
