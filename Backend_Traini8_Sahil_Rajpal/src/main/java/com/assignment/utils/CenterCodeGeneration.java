package com.assignment.utils;

import com.assignment.repo.TrainingCenterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@RequiredArgsConstructor
@Component
public class CenterCodeGeneration {

    private final TrainingCenterRepo trainingCenterRepo;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int RANDOM_PART_LENGTH = 10;
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String PREFIX = "TC";

    public String generateCenterCode() {
        String centerCode;
        do {
            centerCode = PREFIX + generateRandomCode();
        } while (trainingCenterRepo.findByCenterCode(centerCode).isPresent());

        return centerCode;
    }

    private String generateRandomCode() {
        StringBuilder sb = new StringBuilder(RANDOM_PART_LENGTH);
        for (int i = 0; i < RANDOM_PART_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }


}
