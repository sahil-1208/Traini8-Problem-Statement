package com.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 12)
    private String centerCode;

    @Column(nullable = false,length = 40)
    private String centerName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",nullable = false)
    private Address address;

    @Column(nullable = false)
    private Integer studentCapacity;

    @ElementCollection
    @Column(nullable = false)
    private List<String>  coursesOffered;

    @CreatedDate
    private Long createdOn;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true,length = 10)
    private String phoneNumber;

    @PrePersist
    public void prePersist() {
        this.createdOn = Instant.now().getEpochSecond();
    }

}
