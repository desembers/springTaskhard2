# SPRING PLUS

### 대용량 데이터 처리

- nickname 필드에 index 적용

> index 적용 방법은 User 엔티티 클래스에서 @Index 어노테이션을 사용하여 적용하거나, ALTER SQL 문으로 직접 적용할 수 있다.

```java
@Table(name = "users", indexes = {
        @Index(name = "idx_nickname", columnList = "nickname")
})
public class User extends Timestamped {
```

```sql
ALTER TABLE users ADD INDEX idx_nickname (nickname);
```

#### 결과 정리

| 데이터 건수  | Index 적용 여부 | 응답 시간 (ms) | 감소율 (%) |
|--------------|-----------------|------------|---------|
| 1,000,000    | 미적용          | 4,920      | -       |
| 1,000,000    | 적용            | 251        | 94.9%   |



API 작성    
TODO (해야 할일)
일정작성하기  POST  도메인(todo)  /todos/{todoId}/comments
일정조회하기  GET   도메인(todo)  /todos/{todoId}/comments

Manager(관리자)
관리자작성 POST 도메인(Manager) /todos/{todoId}/managers
관리자확인 GET  도메인(Manager) /todos/{todoId}/managers
관리자제거 DELETE 도메인(Manager) /todos/{todoId}/managers/{managerId}

User(사용자)
사용자닉네임조회하기 GET 도메인(User) /users
사용자정보조회하기 GET 도메인(User) /user/{userId}
사용자정보수정하기 Put 도메인(User) /users
사용자권한수정하기 Patch 도메인(User) /admin/users/{userId}

Comment(댓글)
댓글생성 POST 도메인(Comment) /todos/{todoId}/comments
댓글조회 GET  도메인(Comment) /todos/{todoId}/comments

Auth(인증인가)
등록 Post 도메인(Auth) /auth/signup
회원가입 Post 도메인(Auth) /auth/sigin

Git Commit 규칙
fix(버그픽스), feat(기능 개발), refactor(리펙토링), docs(문서업데이트)
feat : 기능 설명

Repository 
다른 서비스 사용된것 
00By000Id
내부 구현용 케이스
000InterfaceService
List<000> get000By000Id()

develop최신화 
feature 브랜치 체크아웃

## 기술 스택
Jwt, Security

## DataBase
JPA 
 
## Build Tool
BuildGradle

## Language
Java.17

## AWS
S3

#ERD관계
User : Manager (1:N)
하나의 사용자가 많은 매니저를 관리합니다 

Todo : Manager (1:N)
하나의 일정을 많은 매니저가 관리합니다 

Comment : Todo (N : 1)
하나의 일정이 많은 댓글을 답니다 

User : todo (1 : N)
하나의 사용자가 많은 일정을 작성합니다.




