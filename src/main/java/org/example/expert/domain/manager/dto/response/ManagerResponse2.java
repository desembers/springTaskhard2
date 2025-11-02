package org.example.expert.domain.manager.dto.response;

import lombok.Getter;
import org.example.expert.domain.user.dto.response.UserResponse2;

@Getter
public class ManagerResponse2 {

    private final Long id;
    private final UserResponse2 user;

    public ManagerResponse2(long id, UserResponse2 user) {
        this.id = id;
        this.user = user;
    }

}
