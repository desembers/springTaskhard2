package org.example.expert.domain.todo.dto.response;

import lombok.Getter;
import org.example.expert.domain.user.dto.response.UserResponse2;

import java.time.LocalDateTime;

@Getter
public class TodoResponse2 {

    private final Long id;
    private final String title;
    private final String contents;
    private final String weather;
    private final UserResponse2 user;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoResponse2(Long id, String title, String contents , String weather, UserResponse2 user, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.weather = weather;
        this.user = user;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
