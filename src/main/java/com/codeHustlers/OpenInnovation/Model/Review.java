package com.codeHustlers.OpenInnovation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private String reviewId;
    private String challengeId;
    private String companyId;
    private String submissionId;
    private String Feedback;

    public String getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(String ChallengeId) {
        challengeId = ChallengeId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String CompanyId) {
        companyId = CompanyId;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String SubmissionId) {
        submissionId = SubmissionId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String ReviewId) {
        reviewId = ReviewId;
    }
}
