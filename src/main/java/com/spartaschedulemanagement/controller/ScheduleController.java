package com.spartaschedulemanagement.controller;

import com.spartaschedulemanagement.dto.CreateScheduleRequest;
import com.spartaschedulemanagement.dto.CreateScheduleResponse;
import com.spartaschedulemanagement.dto.GetOneScheduleResponse;
import com.spartaschedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // LV2. 일정 조회 컨트롤러
    // 전체 일정 조회 컨트롤러
    // 1. TopDown 방식으로 컨트롤러에 먼저 GetMapping 작성
    // 2. dto 작성
    // 3. service에 메서드 작성
    @GetMapping("/schedules")
    public ResponseEntity<List<GetOneScheduleResponse>> getAllSchedules() {
        List<GetOneScheduleResponse> result = scheduleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 선택 일정 조회 컨트롤러
    // 일정의 고유 식별자를 사용해서 조회
    // 고유 식별자가 있기 때문에 PathVariable 매개변수로 받아줘야한다.
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetOneScheduleResponse> getOneSchedule(@PathVariable Long scheduleId) {
        GetOneScheduleResponse result = scheduleService.getOne(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
