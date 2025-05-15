package com.calendar.schedule.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommentDto {
    //댓글 Id
    private Long id;

    //댓글이 달린 일정 ID
    private Long scheduleId;

    //작성자 이름
    private String writerId;

    //댓글 내용
    private String content;

    //부모 댓글 ID
    private Long parentCommentId;

    //생성 시각
    private LocalDateTime createdAt;

    //수정 시각
    private LocalDateTime updatedAt;

    //대댓글 목록
    private List<CommentDto> replies;
}
