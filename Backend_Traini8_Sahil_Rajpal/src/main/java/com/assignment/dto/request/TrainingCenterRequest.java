package com.assignment.dto.request;

import com.assignment.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainingCenterRequest {

    @NotBlank(message = "Center Name cannot be Empty")
    @Size(max = 40, message = "Center Name cannot exceed 40 characters")
    private String centerName;

    private Address address;

    private Integer studentCapacity;

    private List<String> coursesOffered;

    @NotBlank(message = "Email Cannot be Empty")
    @Email(message = "Please enter a valid Email Id")
    private String email;

    @NotBlank(message = "Phone Number Cannot be Empty")
    @Pattern(regexp = "\\d{10}", message = "Please enter a valid mobile number")
    private String phoneNumber;

}
