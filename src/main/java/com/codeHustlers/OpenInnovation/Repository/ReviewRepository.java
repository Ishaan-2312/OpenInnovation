package com.codeHustlers.OpenInnovation.Repository;

import com.codeHustlers.OpenInnovation.Model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review,String> {
    Optional<Review> findByChallengeIdAndReviewId(String challengeId, String reviewId);

    List<Review> findAllByCompanyId(String companyId);

    List<Review> findAllByChallengeId(String challengeId);
}
