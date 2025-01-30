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

@Entity(name = "employeeEntity")
@Table(name = "employee_table")
public class Employees {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_person",foreignKey = @ForeignKey(name = "person_fk"))
    private Person person;
}
