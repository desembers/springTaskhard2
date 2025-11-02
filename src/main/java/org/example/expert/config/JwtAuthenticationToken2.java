package org.example.expert.config;


import org.example.expert.domain.common.dto.AuthUser2;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthenticationToken2 extends AbstractAuthenticationToken {

    private final AuthUser2 authUser2;

    public JwtAuthenticationToken2(AuthUser2 authUser2) {
        super(authUser2.getAuthorities());
        this.authUser2 = authUser2;

    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return authUser2;
    }

}
