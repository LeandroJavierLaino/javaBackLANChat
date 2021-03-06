package com.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    public List<User> findByUsername(String message);

    public List<User> findAll();
}
