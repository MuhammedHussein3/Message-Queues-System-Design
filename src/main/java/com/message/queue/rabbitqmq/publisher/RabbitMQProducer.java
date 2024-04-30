package com.message.queue.rabbitqmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    private final RabbitTemplate rabbitTemplate;
    private final static Logger LOG = LoggerFactory.getLogger(RabbitMQProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
      LOG.info(String.format("Sending message: %s", message));
      rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
