package com.spartaschedulemanagement.controller;

import com.spartaschedulemanagement.dto.CreateScheduleRequest;
import com.spartaschedulemanagement.dto.CreateScheduleResponse;
import com.spartaschedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // LV1. 일정 생성 컨트롤러
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> create(@RequestBody CreateScheduleRequest request) {
        CreateScheduleResponse result = scheduleService.saveSchedule(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
