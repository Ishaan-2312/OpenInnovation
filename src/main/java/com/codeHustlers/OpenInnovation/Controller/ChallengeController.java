package com.codeHustlers.OpenInnovation.Controller;

import com.codeHustlers.OpenInnovation.Model.Challenge;
import com.codeHustlers.OpenInnovation.Model.Company;
import com.codeHustlers.OpenInnovation.Service.ChallengeService;
import com.codeHustlers.OpenInnovation.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/Challenges")

public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private CompanyService companyService;
    @PostMapping("/{CompanyId}/createChallenge")
    public ResponseEntity<Challenge> createChallenge(@PathVariable String CompanyId,@RequestBody Challenge challenge){
        challengeService.createChallenge(CompanyId,challenge);
        return ResponseEntity.ok(challenge);
    }
    @GetMapping("/{companyId}/{id}")
    public ResponseEntity<Optional<Challenge>> getChallenge(@PathVariable String companyId,@PathVariable String id){
       Optional<Challenge> challenge=challengeService.getChallenge(companyId,id);
       if(challenge!=null){
           return ResponseEntity.ok(challenge);
       }
       return new ResponseEntity<>(NOT_FOUND);

    }
    @GetMapping("/getChallenges/{companyId}")
    public ResponseEntity<List<Challenge>> getAllChallenges(@PathVariable String companyId){
        Optional<Company> company=companyService.getCompanyById(companyId);
        List<Challenge> challenges=challengeService.getChallengesByCompanyId(companyId);
        if(company!=null){
            return ResponseEntity.ok(challenges);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }
    @GetMapping("/allChallenges")
    public List<Challenge> displayChallenges(){
        List<Challenge> challenges=challengeService.getAllChallenges();
        return challenges;
    }
    @GetMapping("/{challengeId}")
    public Optional<Challenge> getChallenge(@PathVariable String challengeId){
        Optional<Challenge> challenge=challengeService.getChallengeByChallengeId(challengeId);
        return challenge;
    }


}
