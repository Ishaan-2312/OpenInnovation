package com.codeHustlers.OpenInnovation.Service;

import com.codeHustlers.OpenInnovation.Model.User;
import com.codeHustlers.OpenInnovation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User addUser(User user){
        userRepository.save(user);
        return user;
    }
    public Optional<User> getUser(String UserId){
        Optional<User> user=userRepository.findById(UserId);
        return user;
    }
    public Optional<User> loginUser(String userId,String password){
        Optional<User> user=userRepository.findByUserIdAndPassword(userId,password);
        return user;
    }

}
