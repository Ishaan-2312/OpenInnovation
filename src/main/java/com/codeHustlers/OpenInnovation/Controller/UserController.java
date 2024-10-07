package com.codeHustlers.OpenInnovation.Controller;

import com.codeHustlers.OpenInnovation.LoginRequest.UserLoginRequest;
import com.codeHustlers.OpenInnovation.Model.User;
import com.codeHustlers.OpenInnovation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;

    }
    @PostMapping("/addUser")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User newUser=userService.addUser(user);

        return ResponseEntity.ok(user);

    }
    @GetMapping("/getUser/{UserId}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable String UserId){
        Optional<User> user=userService.getUser(UserId);
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginRequest userLoginRequest){
        Optional<User> user=userService.loginUser(userLoginRequest.getUserId(), userLoginRequest.getPassword());
        if(user.isPresent()){
            return ResponseEntity.ok("Logged In Successfully");
        }
        return new ResponseEntity<>(NOT_FOUND);

    }
}
