package com.calendar.schedule.controller;

import com.calendar.schedule.entity.Schedule;
import com.calendar.schedule.entity.Comment;
import com.calendar.schedule.service.ScheduleService;
import com.calendar.schedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final CommentService commentService;

    // 일정 생성
    @PostMapping("/schedules")
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.create(schedule);
    }

    // 전체 일정 목록 조회
    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleService.findAll();
    }

    // 특정 일정 상세 조회
    @GetMapping("/schedules/{id}")
    public Schedule getSchedule(@PathVariable Long id) {
        return scheduleService.findById(id);
    }

    // 일정 수정
    @PutMapping("/schedules/{id}")
    public Schedule updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        return scheduleService.update(id, schedule);
    }

    // 일정 삭제
    @DeleteMapping("/schedules/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleService.delete(id);
    }

    // 댓글 생성
    @PostMapping("/comments")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    // 특정 일정의 댓글 목록 조회
    @GetMapping("/schedules/{scheduleId}/comments")
    public List<Comment> getComments(@PathVariable Long scheduleId) {
        return commentService.getCommentsBySchedule(scheduleId);
    }

    // 댓글 수정
    @PutMapping("/comments/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment update) {
        return commentService.update(id, update.getContent());
    }

    // 댓글 삭제
    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }
}

