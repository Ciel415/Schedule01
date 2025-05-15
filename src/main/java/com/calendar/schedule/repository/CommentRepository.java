package com.calendar.schedule.repository;

import com.calendar.schedule.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByScheduleIdAndParentCommentIsNullOrderByCreatedAt(Long scheduleId);

    List<Comment> findByParentCommentIdOrderByCreatedAt(Long parentCommentId);

    }
