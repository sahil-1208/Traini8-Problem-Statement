package com.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detailedAddress;

    private String city;

    private String state;

    private String pinCode;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private TrainingCenter trainingCenter;
}
