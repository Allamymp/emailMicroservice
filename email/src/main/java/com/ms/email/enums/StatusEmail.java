package com.ms.email.enums;

import lombok.Getter;

@Getter
public enum StatusEmail {

    SENT("sent"),
    ERROR("error");


    private final String status;

    StatusEmail(String status) {
        this.status = status;
    }
}
