package com.codeHustlers.OpenInnovation.Service;

import com.codeHustlers.OpenInnovation.Model.Challenge;
import com.codeHustlers.OpenInnovation.Model.Submission;
import com.codeHustlers.OpenInnovation.Model.User;
import com.codeHustlers.OpenInnovation.Repository.ChallengeRepository;
import com.codeHustlers.OpenInnovation.Repository.SubmissionRepository;
import com.codeHustlers.OpenInnovation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;
    @Autowired
    private ChallengeRepository challengeRepository;
    @Autowired
    private UserRepository userRepository;

    public void addSubmission(Submission submission){
        submissionRepository.save(submission);
    }
    public Optional<Submission> getSubmission(String ChallengeId,String UserId){
        Optional<Submission> submission=submissionRepository.findByChallengeIdAndUserId(ChallengeId,UserId);
        return submission;
    }
    public List<Submission> getSubmissionsByChallengeId(String challengeId){
        Optional<Challenge> challenge=challengeRepository.findById(challengeId);

            List<Submission>
             submissionsForChallenge = submissionRepository.findAllByChallengeId(challengeId);



        return submissionsForChallenge;
    }

    public List<Submission> getSubmissionsByUserId(String userId) {
        Optional<User> user=userRepository.findById(userId);
        List<Submission> submissions =submissionRepository.findByUserId(userId);
        return submissions;
    }
}
