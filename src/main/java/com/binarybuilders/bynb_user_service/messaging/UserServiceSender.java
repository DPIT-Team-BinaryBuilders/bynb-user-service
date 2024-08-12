package com.binarybuilders.bynb_user_service.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceSender {

    private static final Logger log = LoggerFactory.getLogger(UserServiceSender.class);
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public UserServiceSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendDangerMessage(DangerMessage dangerMessage){
        try {
            // Convert the Danger object to a JSON string
            String message = objectMapper.writeValueAsString(dangerMessage);

            // Send the JSON string as a message
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_USER_TO_DANGER, message);
        } catch (JsonProcessingException e) {
            log.error("Error sending danger message: {}", e.getMessage());
        }
    }
}