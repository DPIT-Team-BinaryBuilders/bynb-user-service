package com.binarybuilders.bynb_user_service.messaging;

import com.binarybuilders.bynb_user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class UserServiceReceiver {
    @Autowired
    private UserService userService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final Logger log = LoggerFactory.getLogger(UserServiceSender.class);

    @RabbitListener(queues = RabbitMQConfig.DANGER_TO_USER_QUEUE)
    public void receiveMessage(String message) {

        String userId = userService.getUserIdByUsername(message);
        if(userId == null) {
            log.error("Failed to get userId from User service.");
            return;
        }
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_USER_TO_DANGER, userId);

    }
}
