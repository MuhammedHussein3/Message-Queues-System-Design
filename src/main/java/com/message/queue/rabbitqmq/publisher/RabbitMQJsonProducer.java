package com.message.queue.rabbitqmq.publisher;

import com.message.queue.rabbitqmq.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQJsonProducer {

    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.json.key}")
    private String jsonRoutingKey;


    public void sendJsonMessage(User user) {
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);
        log.info("Message sent to exchange {}", exchange);
    }
}
