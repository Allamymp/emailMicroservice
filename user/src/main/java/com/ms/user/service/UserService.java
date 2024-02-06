package com.ms.user.service;

import com.ms.user.model.UserModel;
import com.ms.user.producer.UserProducer;
import com.ms.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserProducer userProducer;

    public UserService(UserRepository repository, UserProducer userProducer) {
        this.repository = repository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        try{
            userModel = repository.save(userModel);
            userProducer.publishMessageEmail(userModel);
            return userModel;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
