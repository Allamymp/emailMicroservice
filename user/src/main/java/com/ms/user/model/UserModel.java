package com.ms.user.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Getter
@NoArgsConstructor
@Table(name="TB_USERS")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Setter
    private String name;
    @Setter
    private String email;

    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
