package com.message.queue.rabbitqmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMQConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"rabbitmq.queue.name"})
    private void consume(String message){
        LOG.info("Consuming message: " + message);
    }
}
