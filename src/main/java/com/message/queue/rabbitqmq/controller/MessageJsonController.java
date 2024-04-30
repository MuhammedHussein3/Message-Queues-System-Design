package com.message.queue.rabbitqmq.controller;

import com.message.queue.rabbitqmq.dto.User;
import com.message.queue.rabbitqmq.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/message")
@RequiredArgsConstructor
public class MessageJsonController {

    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
         rabbitMQJsonProducer.sendJsonMessage(user);
         return ResponseEntity.ok("{\"message\": \"" + user + "\"}");
    }
}
