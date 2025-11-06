package com.spartaschedulemanagement.repository;

import com.spartaschedulemanagement.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // id와 password가 일치하는 엔티티가 존재하는지 확인하는 메서드
    boolean existsByIdAndPassword(Long id, String password);
}
