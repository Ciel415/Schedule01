## Schedule Comment API

Spring Boot 기반의 일정 관리 REST API 프로젝트입니다.  
일정(Schedule)과 댓글(Comment), 대댓글(1 Depth)을 포함한 CRUD 기능을 제공합니다.

---

## 기술 스택

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- MySQL 8.x
- Lombok
- H2 (개발용 선택 가능)
- Postman (API 테스트)

---

## 기능 요약

## 일정 기능 (Schedule)
- 일정 생성
- 일정 전체 조회 / 상세 조회
- 일정 수정 / 삭제
- 댓글 수(commentCount) 포함 가능

## 댓글 기능 (Comment)
- 댓글 생성 / 조회 / 수정 / 삭제
- 일정별 댓글 목록 조회
- 댓글 정렬: 작성일 기준 오름차순
- 대댓글(1 Depth) 지원
  - 부모 댓글 하위에 `replies`로 포함

---

## 엔티티 구조

### Schedule
- `id`, `title`, `content`, `writerId`
- `createdAt`, `updatedAt` (JPA Auditing)

### Comment
- `id`, `content`, `writerId`
- `schedule` (일정 ID 참조)
- `parentComment` (부모 댓글 참조, 대댓글용)
- `replies` (1 Depth 대댓글 목록)

---

## API 예시

## 일정 생성

POST /api/schedules
Content-Type: application/json

{
  "title": "회의",
  "content": "회의 내용 정리",
  "writerId": "yun10"
}
