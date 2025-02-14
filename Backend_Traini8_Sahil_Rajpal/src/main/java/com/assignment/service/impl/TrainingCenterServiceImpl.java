package com.assignment.service.impl;

import com.assignment.dto.TrainingCenterDto;
import com.assignment.dto.request.TrainingCenterRequest;
import com.assignment.dto.response.ApiResponse;
import com.assignment.dto.response.TrainingCenterResponse;
import com.assignment.entity.TrainingCenter;
import com.assignment.exception.PageResponseException;
import com.assignment.exception.TrainingCenterResponseException;
import com.assignment.repo.TrainingCenterRepo;
import com.assignment.service.TrainingCenterService;
import com.assignment.utils.CenterCodeGeneration;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

    private final TrainingCenterRepo trainingCenterRepo;

    private final TrainingCenterDto trainingCenterDto;

    private final CenterCodeGeneration centerCodeGeneration;

    @Override
    public ApiResponse createTrainingCenter(TrainingCenterRequest trainingCenterRequest) {
        if (trainingCenterRequest != null) {
            if (trainingCenterRepo.existsByEmail(trainingCenterRequest.getEmail())) {
                throw new TrainingCenterResponseException("Email is already in use");
            }
            if (trainingCenterRepo.existsByPhoneNumber(trainingCenterRequest.getPhoneNumber())) {
                throw new TrainingCenterResponseException("Phone Number is already in use");
            }
            TrainingCenter trainingCenter = trainingCenterDto.requestToEntity(trainingCenterRequest);
            trainingCenter.setCenterCode(centerCodeGeneration.generateCenterCode());
            TrainingCenter savedTrainingCenter = trainingCenterRepo.save(trainingCenter);
            return new ApiResponse(HttpStatus.OK, "Training Center Added ,Training Center Code : " + savedTrainingCenter.getCenterCode());
        } else {
            throw new TrainingCenterResponseException("Please Enter Valid Training Center Details");
        }
    }

    @Override
    public List<TrainingCenterResponse> getTrainingCenterList(int pageNumber, int pageSize, String field,String order) {
        if (pageNumber < 1) throw new PageResponseException("Page number must be 1 or greater ");
        if (pageSize < 1) throw new PageResponseException("Page size must be 1 or greater ");

        if (field == null || field.isEmpty()) {
            throw new PageResponseException("Please Select a Valid Field");
        }

        Sort.Direction sortOrder = (order!= null  && order.equalsIgnoreCase("desc")) ? Sort.Direction.DESC : Sort.Direction.ASC;
        return trainingCenterRepo.findAll(PageRequest.of(pageNumber - 1, pageSize, Sort.by(sortOrder,field)))
                .stream().map(trainingCenterDto::entityToResponse).toList();
    }


}
