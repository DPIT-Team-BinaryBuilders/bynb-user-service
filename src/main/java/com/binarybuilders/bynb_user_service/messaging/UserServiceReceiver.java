package com.binarybuilders.bynb_user_service.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserServiceReceiver {
    @RabbitListener(queues = RabbitMQConfig.DANGER_TO_USER_QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
