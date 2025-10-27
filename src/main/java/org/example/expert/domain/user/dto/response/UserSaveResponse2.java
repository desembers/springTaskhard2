package org.example.expert.domain.user.dto.response;

import lombok.Getter;

@Getter
public class UserSaveResponse2 {

     private final String bearertoken;

     public UserSaveResponse2(String bearertoken) {
         this.bearertoken = bearertoken;
     }

}
