package org.example.expert.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.user.dto.request.UserChangePasswordRequest;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.dto.response.UserResponse2;
import org.example.expert.domain.user.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers(
            @RequestParam String nickname
    ) {
        return ResponseEntity.ok(userService.getUsers(nickname));
    }

    @GetMapping("/users2")
    public ResponseEntity<List<UserResponse2>> getUsers2(
        @RequestParam String nickname
    ) {
        return ResponseEntity.ok(userService.getUser2(nickname));
    }


    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping("/users2/{userId}")
    public ResponseEntity<UserResponse2> getUsers2(
        @PathVariable long userId
    ) {
        return ResponseEntity.ok(userService.getUser2(userId));
    }

    @PutMapping("/users")
    public void changePassword(@AuthenticationPrincipal AuthUser authUser, @RequestBody UserChangePasswordRequest userChangePasswordRequest) {
        userService.changePassword(authUser.getId(), userChangePasswordRequest);
    }

    @PutMapping("/users2")
    public void changePassword2(@AuthenticationPrincipal AuthUser authUser, @RequestBody UserChangePasswordRequest request) {
        userService.changePassword2(authUser.getId(), request);
    }

//    @PutMapping(value = "/users/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public void changeImage(
//            @AuthenticationPrincipal AuthUser authUser,
//            @RequestPart("file") MultipartFile file
//    ) {
//        userService.changeImage(authUser, file);
//    }
}
