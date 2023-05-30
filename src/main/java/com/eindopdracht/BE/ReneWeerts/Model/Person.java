package com.eindopdracht.BE.ReneWeerts.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Persons")
public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;

    @Id
    @GeneratedValue
    private Long id;





}

