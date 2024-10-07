package com.codeHustlers.OpenInnovation.Controller;

import com.codeHustlers.OpenInnovation.Model.Challenge;
import com.codeHustlers.OpenInnovation.Model.Submission;
import com.codeHustlers.OpenInnovation.Model.User;
import com.codeHustlers.OpenInnovation.Service.SubmissionService;
import com.codeHustlers.OpenInnovation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/Submissions")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;
    @Autowired
    private UserService userService;
    @PostMapping("/addSubmission")
    public ResponseEntity<Submission> addSubmission(@RequestBody Submission submission){
        submissionService.addSubmission(submission);
        return  ResponseEntity.ok(submission);
    }
    @GetMapping("/{challengeId}/{userId}/getSubmission")
    public ResponseEntity<Optional<Submission>> getSubmissionByChallengeIdAndUserId(@PathVariable String challengeId,@PathVariable String userId){
        Optional<Submission> submission=submissionService.getSubmission(challengeId,userId);
        if(submission!=null){
            return ResponseEntity.ok(submission);
        }
        return new ResponseEntity<>(NOT_FOUND);

    }
    @GetMapping("/challenge/{challengeId}")
    public ResponseEntity<List<Submission>> getSubmissionsByChallengeId(@PathVariable String challengeId){
        List<Submission> submissions=submissionService.getSubmissionsByChallengeId(challengeId);
        return ResponseEntity.ok(submissions);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Submission>> getSubmissionsByUserId(@PathVariable String userId){
        List<Submission> submissions=submissionService.getSubmissionsByUserId(userId);
        Optional<User> user=userService.getUser(userId);
        if(user!=null){
            return  ResponseEntity.ok(submissions);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }


}
