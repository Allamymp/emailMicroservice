package com.ms.user.producer;

import com.ms.user.dto.EmailDto;
import com.ms.user.model.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel){
        var emailDto = new EmailDto();
        emailDto.setUserId(userModel.getUserId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Api test email!");
        emailDto.setText(userModel.getName()+", welcome! Email "+userModel.getEmail()+" successfully registered in an api made by Allamy Monteiro.");

        rabbitTemplate.convertAndSend("",routingKey,emailDto);
    }
}
