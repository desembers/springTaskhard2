package org.example.expert.domain.comment.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.comment.dto.request.CommentSaveRequest;
import org.example.expert.domain.comment.dto.request.CommentSaveRequest2;
import org.example.expert.domain.comment.dto.response.CommentResponse;
import org.example.expert.domain.comment.dto.response.CommentResponse2;
import org.example.expert.domain.comment.dto.response.CommentSaveResponse;
import org.example.expert.domain.comment.dto.response.CommentSaveResponse2;
import org.example.expert.domain.comment.service.CommentService;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.common.dto.AuthUser2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public ResponseEntity<CommentSaveResponse> saveComment(
            @AuthenticationPrincipal AuthUser authUser,
            @PathVariable long todoId,
            @Valid @RequestBody CommentSaveRequest commentSaveRequest
    ) {
        return ResponseEntity.ok(commentService.saveComment(authUser, todoId, commentSaveRequest));
    }

    @PostMapping("/todos/{todoId}/comment")
    public ResponseEntity<CommentSaveResponse2> saveComment2(
            @AuthenticationPrincipal AuthUser2 authUser2,
            @PathVariable Long todoId,
            @Valid @RequestBody CommentSaveRequest2 request2
            ) {
        return ResponseEntity.ok(commentService.saveComment2(authUser2, todoId, request2));
    }

    @GetMapping("/todos/{todoId}/comments")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable long todoId) {
        return ResponseEntity.ok(commentService.getComments(todoId));
    }

    @GetMapping("/todos/{todoId}/comment")
    public ResponseEntity<List<CommentResponse2>> getComments2(@PathVariable long todoId) {
        return ResponseEntity.ok(commentService.getComments2(todoId));
    }


}
