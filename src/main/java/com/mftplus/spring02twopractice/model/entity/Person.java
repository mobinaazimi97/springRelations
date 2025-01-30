package com.mftplus.spring02twopractice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "personEntity")
@Table(name = "person_table")
public class Person {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String family;
    private Integer age;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
             foreignKey = @ForeignKey(name = "user_fk"),
            name = "person_users",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "username"))
    private List<User> userList;
}
