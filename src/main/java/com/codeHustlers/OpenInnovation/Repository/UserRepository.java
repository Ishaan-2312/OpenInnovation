package com.codeHustlers.OpenInnovation.Repository;

import com.codeHustlers.OpenInnovation.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUserIdAndPassword(String userId, String password);
}
