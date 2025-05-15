package com.calendar.schedule.service;

import com.calendar.schedule.entity.Comment;
import com.calendar.schedule.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    // 댓글 생성
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    // 특정 일정에 달린 댓글 목록 조회 (부모 댓글만)
    public List<Comment> getCommentsBySchedule(Long scheduleId) {
        return commentRepository.findByScheduleIdAndParentCommentIsNullOrderByCreatedAt(scheduleId);
    }

    // 댓글 수정
    public Comment update(Long id, String content) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        comment.setContent(content);
        return commentRepository.save(comment);
    }

    // 댓글 삭제
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
