package com.spartaschedulemanagement.service;

import com.spartaschedulemanagement.dto.CreateScheduleRequest;
import com.spartaschedulemanagement.dto.CreateScheduleResponse;
import com.spartaschedulemanagement.entity.Schedule;
import com.spartaschedulemanagement.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // LV1. 일정 생성 service
    @Transactional
    public CreateScheduleResponse saveSchedule(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContents(),
                request.getNickname(),
                request.getPassword()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);

        // Schedule -> CreateScheduleResponse로 형변환 해줘야한다.
        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getNickname(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }
}
