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

@Entity(name = "dismissEntity")
@Table(name = "dismiss_table")
public class Dismissal {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH}, fetch = FetchType.EAGER)
   @JoinTable(name = "dismissal_employee",foreignKey = @ForeignKey(name = "employee_fk"))
    private Employees employees;

}
