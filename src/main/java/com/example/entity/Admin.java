package com.example.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    private int id;
    @NonNull
    private String login;
    @NonNull
    private String password;
}
