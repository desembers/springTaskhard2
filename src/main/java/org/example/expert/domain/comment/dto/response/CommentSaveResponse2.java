package org.example.expert.domain.comment.dto.response;

import lombok.Getter;
import org.example.expert.domain.user.dto.response.UserResponse2;

@Getter
public class CommentSaveResponse2 {

    private final Long id;
    private final String contents;
    private final UserResponse2 user;

    public CommentSaveResponse2(Long id, String contents, UserResponse2 user) {
        this.id = id;
        this.contents = contents;
        this.user = user;
    }

}
