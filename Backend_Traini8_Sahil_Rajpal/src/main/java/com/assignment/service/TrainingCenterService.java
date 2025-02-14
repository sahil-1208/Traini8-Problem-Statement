package com.assignment.service;

import com.assignment.dto.request.TrainingCenterRequest;
import com.assignment.dto.response.ApiResponse;
import com.assignment.dto.response.TrainingCenterResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainingCenterService {
    ApiResponse createTrainingCenter(TrainingCenterRequest trainingCenterRequest);
    List<TrainingCenterResponse> getTrainingCenterList(int pageNumber, int pageSize, String field,String order);
}
