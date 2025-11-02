package org.example.expert.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.common.dto.AuthUser2;
import org.example.expert.domain.common.entity.Timestamped;
import org.example.expert.domain.user.enums.UserRole;
import org.example.expert.domain.user.enums.UserRole2;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "users", indexes = {
        @Index(name = "idx_nickname", columnList = "nickname")
})
public class User extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String nickname;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Enumerated(EnumType.STRING)
    private UserRole2 userRole2;
    private String imageUrl;

    public User(String email, String password, String nickname, UserRole userRole) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.userRole = userRole;
    }

    private User(Long id, String email, String nickname, UserRole userRole) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.userRole = userRole;
    }

    public User(Long id, String email, String nickname, UserRole2 userRole2) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.userRole2 = userRole2;
    }

    public static User fromAuthUser(AuthUser authUser) {
        return new User(authUser.getId(), authUser.getEmail(), authUser.getNickname(), authUser.getUserRole());
    }

   public static User fromAuthUser2(AuthUser2 authUser2) {
        return new User(authUser2.getId(), authUser2.getEmail(), authUser2.getNickname(), authUser2.getUserRole2());
   }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void updateRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
