package com.calendar.schedule.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDto {
    //스케줄 ID
    private Long id;

    //일정 제목
    private String title;

    //일정 내용
    private String content;

    //작성자 이름
    private String writerId;

    //생성 시각
    private LocalDateTime createdAt;

    //수정 시각
    private LocalDateTime updatedAt;

    //해당 일정에 달린 댓글 수
    private int commentCount;
}
