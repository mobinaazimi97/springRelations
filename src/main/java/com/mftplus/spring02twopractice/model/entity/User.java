package com.mftplus.spring02twopractice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "userEntity")
@Table(name = "user_table")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "username")
    private String username;
    private String password;
    private String email;
    private Integer age;
}
