/*package com.binarybuilders.bynb_user_service.service;

import com.binarybuilders.bynb_user_service.config.DangerRequestConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class DangerRequestService {

    private final RabbitTemplate rabbitTemplate;

    public DangerRequestService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String getDangerId(String userId) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setReplyTo(DangerRequestConfig.REPLY_QUEUE);
        Message message = new Message(userId.getBytes(), messageProperties);

        Message response = rabbitTemplate.sendAndReceive(DangerRequestConfig.REQUEST_QUEUE, message);
        return response != null ? new String(response.getBody()) : null;
    }
}
*/