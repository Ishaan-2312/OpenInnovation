package com.codeHustlers.OpenInnovation.Service;

import com.codeHustlers.OpenInnovation.Model.Challenge;
import com.codeHustlers.OpenInnovation.Model.Company;
import com.codeHustlers.OpenInnovation.Repository.ChallengeRepository;
import com.codeHustlers.OpenInnovation.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    @Autowired
    private ChallengeRepository challengeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    public void createChallenge(String CompanyId,Challenge challenge){
        Optional<Company> company=companyRepository.findById(CompanyId);
        if(company!=null){
            challengeRepository.save(challenge);
        }else throw new RuntimeException("Company Does Not Exist");



    }
    public Optional<Challenge> getChallenge(String companyId,String id){
        Optional<Challenge> challenge=challengeRepository.findByCompanyIdAndId(companyId,id);

            return challenge;


    }

    public Optional<Challenge> getChallengeByChallengeId(String challengeId) {
        Optional<Challenge> challenge=challengeRepository.findById(challengeId);
        return challenge;
    }

    public List<Challenge> getChallengesByCompanyId(String companyId) {
        List<Challenge> challenges=challengeRepository.findAllByCompanyId(companyId);
        return challenges;
    }
//@Cacheable(value = "Challenge")
    public List<Challenge> getAllChallenges() {
        List<Challenge> challenges=challengeRepository.findAll();
        return challenges;
    }
}
