package com.codeHustlers.OpenInnovation.Repository;

import com.codeHustlers.OpenInnovation.Model.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends MongoRepository<Submission,String> {
//    Optional<Submission> findByChallengeId(String challengeId);

    Optional<Submission> findByChallengeIdAndUserId(String challengeId,String UserId);

    List<Submission> findAllByChallengeId(String challengeId);

    List<Submission> findByUserId(String userId);
}
