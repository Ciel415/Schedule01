package com.calendar.schedule.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Schedule {

    //고유 식별자 (스케쥴 ID)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //일정 제목
    @Column(nullable = false, length = 100)
    private String title;

    //일정 내용
    @Lob // 제한 없이 긴 문자열 저장가능
    @Column(nullable = false)
    private String content;

    //작성자 이름
    private String writerId;

    // 생성 시각
    @CreatedDate
    private LocalDateTime createdAt;

    // 수정 시각
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // 일정에 달린 댓글 목록 (1:N 관계)
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comment> comments;
}
