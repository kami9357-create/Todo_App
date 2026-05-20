package com.devamateur.Todo_App.controller;

import com.devamateur.Todo_App.dto.request.TaskPatchRequest;
import com.devamateur.Todo_App.service.TaskService;
import com.devamateur.Todo_App.dto.request.TaskRequest;
import com.devamateur.Todo_App.dto.response.ApiResponse;
import com.devamateur.Todo_App.dto.response.TaskResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TaskController {
    TaskService taskService;

    @GetMapping
    public ApiResponse<List<TaskResponse>> getTasks(@RequestParam(required = false) Boolean completed) {
        return ApiResponse.<List<TaskResponse>>builder()
                .result(taskService.getTasks(completed))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<TaskResponse> getTaskById(@PathVariable Long id) {
        return ApiResponse.<TaskResponse>builder()
                .result(taskService.getTaskById(id))
                .build();
    }

    @GetMapping("/search")
    public ApiResponse<List<TaskResponse>> searchTasks(@RequestParam String keyword) {
        return ApiResponse.<List<TaskResponse>>builder()
                .result(taskService.searchTasks(keyword))
                .build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<TaskResponse> createTask(@RequestBody @Valid TaskRequest request) {
        return ApiResponse.<TaskResponse>builder()
                .result(taskService.createTask(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskResponse> updateTask(@PathVariable Long id, @RequestBody @Valid TaskRequest request) {
        return ApiResponse.<TaskResponse>builder()
                .result(taskService.updateTask(id, request))
                .build();
    }

    @PatchMapping("/{id}")
    public ApiResponse<TaskResponse> patchTask(@PathVariable Long id, @RequestBody @Valid TaskPatchRequest request) {
        return ApiResponse.<TaskResponse>builder()
                .result(taskService.patchTask(id, request))
                .build();
    }

    @PatchMapping("/{id}/complete")
    public ApiResponse<TaskResponse> markTaskAsCompleted(@PathVariable Long id) {
        return ApiResponse.<TaskResponse>builder()
                .result(taskService.markTaskAsCompleted(id))
                .build();
    }

    @PatchMapping("/{id}/uncomplete")
    public ApiResponse<TaskResponse> markTaskAsUncompleted(@PathVariable Long id) {
        return ApiResponse.<TaskResponse>builder()
                .result(taskService.markTaskAsUncompleted(id))
                .build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
