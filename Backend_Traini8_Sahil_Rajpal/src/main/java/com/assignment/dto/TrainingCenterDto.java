package com.assignment.dto;

import com.assignment.dto.request.TrainingCenterRequest;
import com.assignment.dto.response.TrainingCenterResponse;
import com.assignment.entity.TrainingCenter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TrainingCenterDto {

    public TrainingCenter requestToEntity(TrainingCenterRequest trainingCenterRequest){
        TrainingCenter trainingCenter = new TrainingCenter();
        BeanUtils.copyProperties(trainingCenterRequest,trainingCenter);
        return trainingCenter;
    }

    public TrainingCenterResponse entityToResponse(TrainingCenter trainingCenter){
        TrainingCenterResponse trainingCenterResponse = new TrainingCenterResponse();
        BeanUtils.copyProperties(trainingCenter,trainingCenterResponse);
        return trainingCenterResponse;
    }

}
