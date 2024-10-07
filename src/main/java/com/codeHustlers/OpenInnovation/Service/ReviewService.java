package com.codeHustlers.OpenInnovation.Service;

import com.codeHustlers.OpenInnovation.Model.Challenge;
import com.codeHustlers.OpenInnovation.Model.Review;
import com.codeHustlers.OpenInnovation.Repository.ChallengeRepository;
import com.codeHustlers.OpenInnovation.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ChallengeRepository challengeRepository;
    public boolean addReview(Review review,String submissionId){
        Optional<Challenge> challenge=challengeRepository.findById(submissionId);
        if(challenge!=null) {
            reviewRepository.save(review);
            return true;
        }
        else return false;
    }

    public Optional<Review> getReview(String challengeId, String reviewId) {
        Optional<Review> review=reviewRepository.findByChallengeIdAndReviewId(challengeId,reviewId);
        return review;
    }

    public List<Review> getReviewsByCompanyId(String companyId) {
        List<Review> reviews=reviewRepository.findAllByCompanyId(companyId);
        return reviews;
    }

    public List<Review> getReviewsByChallengeId(String challengeId) {
        List<Review> reviews=reviewRepository.findAllByChallengeId(challengeId);
        return reviews;
    }
}
