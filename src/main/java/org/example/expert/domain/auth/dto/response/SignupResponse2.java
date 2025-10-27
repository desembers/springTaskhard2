package org.example.expert.domain.auth.dto.response;

import lombok.Getter;

@Getter
public class SignupResponse2 {

    private final String bearerToken;

    public SignupResponse2(String bearerToken) {
        this.bearerToken = bearerToken;
    }

}
