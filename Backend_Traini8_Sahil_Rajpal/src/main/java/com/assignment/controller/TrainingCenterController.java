package com.assignment.controller;

import com.assignment.dto.request.TrainingCenterRequest;
import com.assignment.dto.response.ApiResponse;
import com.assignment.dto.response.TrainingCenterResponse;
import com.assignment.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/training/center")
public class TrainingCenterController {

    @Autowired
    TrainingCenterService trainingCenterService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addTrainingCenter(@RequestBody @Valid TrainingCenterRequest trainingCenterRequest){
        return ResponseEntity.ok().body(trainingCenterService.createTrainingCenter(trainingCenterRequest));
    }

    @GetMapping("/get/pgNo/{pageNumber}/pgSize/{pageSize}/field/{fieldName}")
    public ResponseEntity<List<TrainingCenterResponse>> getTrainingCenterList(@PathVariable int pageNumber, @PathVariable int pageSize,
                                                                              @PathVariable String fieldName,@RequestParam(defaultValue = "asc") String order){
        return ResponseEntity.ok().body(trainingCenterService.getTrainingCenterList(pageNumber,pageSize,fieldName,order));

    }

}
