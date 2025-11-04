package com.spring.batch_processing.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;


@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String indexValue;
    private String userId;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String jobTitle;

}
