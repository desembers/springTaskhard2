package org.example.expert.domain.user.dto.response;

import lombok.Getter;

@Getter
public class UserResponse2 {

    private Long id;
    private String email;

    public UserResponse2(Long id, String email) {
        this.id = id;
        this.email = email;
    }

}
