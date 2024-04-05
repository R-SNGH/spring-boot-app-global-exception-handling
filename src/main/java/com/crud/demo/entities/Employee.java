package com.crud.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employee")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
