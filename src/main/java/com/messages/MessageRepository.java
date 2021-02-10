package com.messages;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    public Message findByMessage(String message);

    public List<Message> findByUsername(String username);

    public List<Message> findAll();
}