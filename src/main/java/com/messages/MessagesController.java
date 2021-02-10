package com.messages;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MessagesController {
    @Autowired
    private MessageRepository repository;

    @GetMapping("/messages")
    public String getMessages() throws JsonProcessingException {
        List<Message> messages = repository.findAll();

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(messages);
        } catch (JsonGenerationException e) {
            throw e;
        }
    }

    @GetMapping("/messagesClean")
    public String messagesClean() throws JsonProcessingException {
        repository.deleteAll();

        Message messageA = new Message("usuario A", "mensaje A");
        Message messageB = new Message("usuario B", "mensaje B");
        Message messageC = new Message("usuario C", "mensaje C");
        Message messageD = new Message("usuario D", "mensaje D");
        Message messageE = new Message("usuario E", "mensaje E");

        repository.save(messageA);
        repository.save(messageB);
        repository.save(messageC);
        repository.save(messageD);
        repository.save(messageE);

        return "Messages were refreshed";
    }

    @GetMapping("/nukeMessages")
    public String nukeMessages() {
        repository.deleteAll();

        return "Messages were deleted";
    }
}
