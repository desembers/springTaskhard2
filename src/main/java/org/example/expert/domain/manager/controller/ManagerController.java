package org.example.expert.domain.manager.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.common.dto.AuthUser2;
import org.example.expert.domain.manager.dto.request.ManagerSaveRequest;
import org.example.expert.domain.manager.dto.request.ManagerSaveRequset2;
import org.example.expert.domain.manager.dto.response.ManagerResponse;
import org.example.expert.domain.manager.dto.response.ManagerResponse2;
import org.example.expert.domain.manager.dto.response.ManagerSaveResponse;
import org.example.expert.domain.manager.dto.response.ManagerSaveResponse2;
import org.example.expert.domain.manager.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/todos/{todoId}/managers")
    public ResponseEntity<ManagerSaveResponse> saveManager(
            @AuthenticationPrincipal AuthUser authUser,
            @PathVariable long todoId,
            @Valid @RequestBody ManagerSaveRequest managerSaveRequest
    ) {
        return ResponseEntity.ok(managerService.saveManager(authUser, todoId, managerSaveRequest));
    }

    @PostMapping("/todos/{todoId}/manager")
    public ResponseEntity<ManagerSaveResponse2> saveManager2(
            @AuthenticationPrincipal AuthUser2 authUser2,
            @PathVariable long todoId,
            @Valid @RequestBody ManagerSaveRequset2 requset2
            ) {
        return ResponseEntity.ok(managerService.saveManager2(authUser2, todoId, requset2));
    }

    @GetMapping("/todos/{todoId}/managers")
    public ResponseEntity<List<ManagerResponse>> getMembers(@PathVariable long todoId) {
        return ResponseEntity.ok(managerService.getManagers(todoId));
    }

    @GetMapping("/todos/{todoId}/manager")
    public ResponseEntity<List<ManagerResponse2>> getManagers2(
            @PathVariable long todoId
    ) {
        return ResponseEntity.ok(managerService.getManagers2(todoId));
    }

    @DeleteMapping("/todos/{todoId}/managers/{managerId}")
    public void deleteManager(
            @AuthenticationPrincipal AuthUser authUser,
            @PathVariable long todoId,
            @PathVariable long managerId
    ) {
        managerService.deleteManager(authUser, todoId, managerId);
    }

    @DeleteMapping("/todos/{todoId}/manager/{managerId}")
    public void deleteManager2(
        @AuthenticationPrincipal AuthUser2 authUser2,
        @PathVariable long todoId,
        @PathVariable long managerId
    ) {
        managerService.deleteManager2(authUser2, todoId, managerId);
    }

}
