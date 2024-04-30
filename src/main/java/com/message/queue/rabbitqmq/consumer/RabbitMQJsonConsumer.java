package com.message.queue.rabbitqmq.consumer;

import com.message.queue.rabbitqmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"rabbitmq.queue.json.name"})
    public void consumeJsonMessage(User user){
        log.info("Consuming json message "+user.toString());
    }
}
