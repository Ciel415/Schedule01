package com.calendar.schedule.service;

import com.calendar.schedule.entity.Schedule;
import com.calendar.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public Schedule create(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // 전체 일정 목록 조회
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    //특정 일정 상세 조회
    public Schedule findById(Long id) {
        return scheduleRepository.findById(id).orElseThrow();
    }

    //일정 삭제
    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }

    //일정 수정
    public Schedule update(Long id, Schedule updated) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        schedule.setTitle(updated.getTitle());
        schedule.setContent(updated.getContent());
        return scheduleRepository.save(schedule);
    }
}
