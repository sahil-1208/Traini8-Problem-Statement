package com.assignment.dto.response;

import com.assignment.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainingCenterResponse {

    private String centerCode;

    private String centerName;

    private Address address;

    private Integer studentCapacity;

    private List<String> coursesOffered;

    private Long createdOn;

    private String email;

    private String phoneNumber;
}
