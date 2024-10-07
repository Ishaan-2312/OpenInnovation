package com.codeHustlers.OpenInnovation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Submission")

public class Submission {
    @Id
    private String SubmissionId;
    private String challengeId;
    private String CompanyId;
    private String userId;
    private String review;

    public String getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(String ChallengeId) {
        challengeId = ChallengeId;
    }

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String UserId) {
        userId = UserId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
