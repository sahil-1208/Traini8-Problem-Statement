package com.assignment.repo;

import com.assignment.entity.TrainingCenter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingCenterRepo extends JpaRepository<TrainingCenter,Long> {

    Optional<TrainingCenter> findByCenterCode(String centerCode);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
}
