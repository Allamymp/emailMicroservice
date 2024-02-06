package com.ms.user.controller;


import com.ms.user.dto.UserRecordDto;
import com.ms.user.model.UserModel;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> create(@RequestBody @Valid UserRecordDto data) {
        try {
            var userModel = new UserModel();
            BeanUtils.copyProperties(data, userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userModel));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
