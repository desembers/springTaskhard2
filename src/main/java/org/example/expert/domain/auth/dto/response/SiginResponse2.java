package org.example.expert.domain.auth.dto.response;

import lombok.Getter;

@Getter
public class SiginResponse2 {

    private String bearerToken;

    public SiginResponse2(String bearerToken) {
        this.bearerToken = bearerToken;
    }

}
