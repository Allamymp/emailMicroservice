package com.ms.email.models;


import com.ms.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_EMAILS")
@Getter
@NoArgsConstructor
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    @Setter
    private UUID userId;
    @Setter
    private String emailFrom;
    @Setter
    private String emailTo;
    @Setter
    private String subject;
    @Column(columnDefinition = "TEXT")
    @Setter
    private String text;
    @Setter
    private LocalDateTime sendDateEmail;
    @Setter
    private StatusEmail statusEmail;

    public EmailModel(UUID userId, String emailFrom, String emailTo, String subject
            , String text, LocalDateTime sendDateEmail, StatusEmail statusEmail) {
        this.userId = userId;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
        this.sendDateEmail = sendDateEmail;
        this.statusEmail = statusEmail;
    }
}
