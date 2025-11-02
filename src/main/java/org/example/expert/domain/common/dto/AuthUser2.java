package org.example.expert.domain.common.dto;

import lombok.Getter;
import org.example.expert.domain.user.enums.UserRole;
import org.example.expert.domain.user.enums.UserRole2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
public class AuthUser2 {

    private final Long id;
    private final String email;
    private final String nickname;
    private final UserRole2 userRole2;
    private final Collection<? extends GrantedAuthority> authorities;

    public AuthUser2(Long id, String email, String nickname, UserRole2 userRole2) {
           this.id = id;
           this.email = email;
           this.nickname = nickname;
           this.userRole2 = userRole2;
           this.authorities = List.of(new SimpleGrantedAuthority(userRole2.name()));
    }
}
