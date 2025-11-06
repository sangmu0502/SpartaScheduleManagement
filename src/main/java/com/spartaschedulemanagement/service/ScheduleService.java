package com.spartaschedulemanagement.service;

import com.spartaschedulemanagement.dto.CreateScheduleRequest;
import com.spartaschedulemanagement.dto.CreateScheduleResponse;
import com.spartaschedulemanagement.dto.GetOneScheduleResponse;
import com.spartaschedulemanagement.entity.Schedule;
import com.spartaschedulemanagement.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    // LV2. 전체 일정 조회
    // 조회는 readOnly = true를 추가해준다.
    @Transactional(readOnly = true)
    public List<GetOneScheduleResponse> getAll() {
        // schedules에 Repository에 findAll메서드 jpa로 요청
        List<Schedule> schedules = scheduleRepository.findAll();

        // schedules을 바로 받으면 3 layer architecture에 위반
        List<GetOneScheduleResponse> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            GetOneScheduleResponse dto = new GetOneScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getNickname(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public GetOneScheduleResponse getOne(Long scheduleId) {
        // findById메서드를 사용하면 Optional 객체로 받아오기 때문에 Optional을 벗겨줘야한다.
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        // 여기서 스케쥴을 바로 return해주면 아키텍쳐 레이어에 위반된다.
        return new GetOneScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getNickname(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }
}
