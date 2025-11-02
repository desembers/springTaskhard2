package org.example.expert.domain.todo.dto.response;

import lombok.Getter;
import org.example.expert.domain.user.dto.response.UserResponse2;

@Getter
public class TodoSaveResponse2 {

    private final Long id;
    private final String title;
    private final String contents;
    private final String weather;
    private final UserResponse2 user;

    public TodoSaveResponse2(Long id, String title, String contents, String weather, UserResponse2 user) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.weather = weather;
        this.user = user;
    }

}
