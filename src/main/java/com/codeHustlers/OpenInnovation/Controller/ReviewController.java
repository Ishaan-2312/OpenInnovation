package com.codeHustlers.OpenInnovation.Controller;

import com.codeHustlers.OpenInnovation.Model.Challenge;
import com.codeHustlers.OpenInnovation.Model.Company;
import com.codeHustlers.OpenInnovation.Model.Review;
import com.codeHustlers.OpenInnovation.Service.ChallengeService;
import com.codeHustlers.OpenInnovation.Service.CompanyService;
import com.codeHustlers.OpenInnovation.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/Reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ChallengeService challengeService;
    @PostMapping("/addReview/{submissionId}")
    public ResponseEntity<Review> addReview(@RequestBody Review review, @PathVariable String submissionId){
        Boolean bool= reviewService.addReview(review,submissionId);
        if(bool==true){
            return ResponseEntity.ok(review);
        }
        return new ResponseEntity<>(NOT_FOUND);



    }
    @GetMapping("/{challengeId}/{reviewId}/getReview")
    public ResponseEntity<Optional<Review>> getReview(@PathVariable String challengeId,@PathVariable String reviewId){
        Optional<Review> review=reviewService.getReview(challengeId,reviewId);
        if(review!=null){
            return ResponseEntity.ok(review);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }
    @GetMapping("/{companyId}/getReview")
    public ResponseEntity<List<Review>> getReviews(@PathVariable String companyId){
        Optional<Company> company=companyService.getCompanyById(companyId);
        List<Review> reviews=reviewService.getReviewsByCompanyId(companyId);
        if(company!=null){
            return ResponseEntity.ok(reviews);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }
    @GetMapping("/{challengeId}")
    public ResponseEntity<List<Review>> getReviewsByChallengeId(@PathVariable String challengeId){
        Optional<Challenge> challenge=challengeService.getChallengeByChallengeId(challengeId);
        List<Review> reviews=reviewService.getReviewsByChallengeId(challengeId);
        if(challenge!=null){
            return ResponseEntity.ok(reviews);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }

}
