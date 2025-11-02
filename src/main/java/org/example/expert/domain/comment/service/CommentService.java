package org.example.expert.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.comment.dto.request.CommentSaveRequest;
import org.example.expert.domain.comment.dto.request.CommentSaveRequest2;
import org.example.expert.domain.comment.dto.response.CommentResponse;
import org.example.expert.domain.comment.dto.response.CommentResponse2;
import org.example.expert.domain.comment.dto.response.CommentSaveResponse;
import org.example.expert.domain.comment.dto.response.CommentSaveResponse2;
import org.example.expert.domain.comment.entity.Comment;
import org.example.expert.domain.comment.repository.CommentRepository;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.common.dto.AuthUser2;
import org.example.expert.domain.common.exception.InvalidRequestException;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.todo.repository.TodoRepository;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.dto.response.UserResponse2;
import org.example.expert.domain.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponse saveComment(AuthUser authUser, long todoId, CommentSaveRequest commentSaveRequest) {
        User user = User.fromAuthUser(authUser);
        Todo todo = todoRepository.findById(todoId).orElseThrow(() ->
                new InvalidRequestException("Todo not found"));

        Comment newComment = new Comment(
                commentSaveRequest.getContents(),
                user,
                todo
        );

        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponse(
                savedComment.getId(),
                savedComment.getContents(),
                new UserResponse(user.getId(), user.getEmail())
        );
    }

    public CommentSaveResponse2 saveComment2(AuthUser2 authUser2, long todoId, CommentSaveRequest2 request2) {
        User user = User.fromAuthUser2(authUser2);
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new InvalidRequestException("Todo not found")
        );

        Comment newComment2 = new Comment(
                request2.getContents(),
                user,
                todo
        );

        Comment SavedComment2 = commentRepository.save(newComment2);
        return new CommentSaveResponse2(
                SavedComment2.getId(),
                SavedComment2.getContents(),
                new UserResponse2(user.getId(), user.getEmail())
        );

    }

    public List<CommentResponse> getComments(long todoId) {
        List<Comment> commentList = commentRepository.findByTodoIdWithUser(todoId);

        List<CommentResponse> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            User user = comment.getUser();
            CommentResponse dto = new CommentResponse(
                    comment.getId(),
                    comment.getContents(),
                    new UserResponse(user.getId(), user.getEmail())
            );
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<CommentResponse2> getComments2(long todoId) {
        List<Comment> commentList2 = commentRepository.findByTodoIdWithUser(todoId);

        List<CommentResponse2> todoList2 = new ArrayList<>();
        for (Comment comment : commentList2) {
            User user = comment.getUser();
            CommentResponse2 dtos = new CommentResponse2(
                 comment.getId(),
                 comment.getContents(),
                 new UserResponse2(user.getId(), user.getEmail())
            );
            todoList2.add(dtos);
        }
        return todoList2;
    }
    
}
