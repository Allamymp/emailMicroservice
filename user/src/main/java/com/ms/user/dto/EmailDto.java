package com.ms.user.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
