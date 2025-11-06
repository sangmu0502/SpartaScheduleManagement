package com.spartaschedulemanagement.controller;

import com.spartaschedulemanagement.dto.*;
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

    // LV3. 수정 컨트롤러
    // 서버에 일정 수정을 요청할 때 비밀번호를 함께 전달해줘야한다.(Request dto에 비밀번호 필요)
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@RequestBody UpdateScheduleRequest request, @PathVariable Long scheduleId) {
        UpdateScheduleResponse result = scheduleService.updateSchedule(scheduleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // LV4. 삭제 컨트롤러
    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@RequestBody DeleteScheduleRequest request, @PathVariable Long scheduleId) {
        scheduleService.delete(scheduleId, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
